package pippin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.Observable;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MachineView extends Observable
{
	enum States
	{
		AUTO_STEPPING {
			public void enter() {
				states[ASSEMBLE] = false;
				states[CLEAR] = false;
				states[LOAD] = false;
				states[RELOAD] = false;
				states[RUN] = true;
				states[RUNNING] = true;
				states[STEP] = false;
			}		
		},

		NOTHING_LOADED {
			public void enter() {
				states[ASSEMBLE] = true;
				states[CLEAR] = false;
				states[LOAD] = true;
				states[RELOAD] = false;
				states[RUN] = false;
				states[RUNNING] = false;
				states[STEP] = false;
			}
		}, 

		PROGRAM_HALTED {
			public void enter() {
				states[ASSEMBLE] = true;
				states[CLEAR] = true;
				states[LOAD] = true;
				states[RELOAD] = true;
				states[RUN] = false;
				states[RUNNING] = false;
				states[STEP] = false;
			}		
		}, 

		PROGRAM_LOADED_NOT_AUTOSTEPPING {
			public void enter() {
				states[ASSEMBLE] = true;
				states[CLEAR] = true;
				states[LOAD] = true;
				states[RELOAD] = true;
				states[RUN] = true;
				states[RUNNING] = false;
				states[STEP] = true;
			}		
		};

		private static final int ASSEMBLE = 0;
		private static final int CLEAR = 1;
		private static final int LOAD = 2; 
		private static final int RELOAD = 3;
		private static final int RUN = 4;
		private static final int RUNNING = 5;
		private static final int STEP = 6; 

		boolean[] states = new boolean[7];

		public abstract void enter();

		public boolean getAssembleFileActive()
		{
			return states[ASSEMBLE];
		}

		public boolean getClearActive()
		{
			return states[CLEAR];
		}

		public boolean getLoadFileActive()
		{
			return states[LOAD];
		}

		public boolean getReloadActive()
		{
			return states[RELOAD];
		}

		public boolean getRunningActive()
		{
			return states[RUNNING];
		}

		public boolean getRunPauseActive()
		{
			return states[RUN];
		}

		public boolean getStepActive()
		{
			return states[STEP];
		}
	}

	static final int TICK = 500;
	private MachineModel model;
	private String defaultDir, sourceDir, dataDir, executableDir;
	private Properties properties;
	private CodeViewPanel codeViewPanel;
	private MemoryViewPanel memoryViewPanel1, memoryViewPanel2, memoryViewPanel3;
	private ControlPanel controlPanel;
	private CPUViewPanel cpuViewPanel;
	private MenuBarBuilder menuBarBuilder;
	private JFrame frame;
	private Timer timer;
	private States state;
	private File currentProgramFile, currentDataFile;
	private boolean running = false, programLoaded = false, noDataNeeded = false, autoStepOn = false;

	public boolean isAutoStepOn()
	{
		return autoStepOn;
	}

	public void setAutoStepOn(boolean autoStepOn)
	{
		this.autoStepOn = autoStepOn;
	}

	public States getState()
	{
		return state;
	}

	public void setRunning(boolean running)
	{
		this.running = running;

		if (running)
		{
			state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
		}
		else
		{
			autoStepOn = false;
			state = States.PROGRAM_HALTED;
		}

		state.enter();
		setChanged();
		notifyObservers();
	}

	public Code getCode()
	{
		return model.getCode();
	}

	public int getPC()
	{
		return model.getPC();
	}

	public int getAccum()
	{
		return model.getAccum();
	}

	public int getChangedIndex()
	{
		return model.getChangedIndex();
	}

	public int getData(int i)
	{
		return model.getData(i);
	}

	public void locateDefaultDirectory()
	{

	}

	public void loadPropertiesFile()
	{
	}

	public void createAndShowGUI()
	{
		frame = new JFrame("Pippin Simulator");
		codeViewPanel = new CodeViewPanel(this);
		memoryViewPanel1 = new MemoryViewPanel(this, 0, 160);
		memoryViewPanel2 = new MemoryViewPanel(this, 160, 240);
		memoryViewPanel3 = new MemoryViewPanel(this, 240, Memory.DATA_SIZE);
		cpuViewPanel = new CPUViewPanel(this);
		menuBarBuilder = new MenuBarBuilder(this);
		ControlPanel controlPanel = new ControlPanel(this);

		frame.add(codeViewPanel.createCodeDisplay(), BorderLayout.LINE_START);

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,3));
		frame.add(center,BorderLayout.CENTER);
		center.add(memoryViewPanel1.createMemoryDisplay());
		center.add(memoryViewPanel2.createMemoryDisplay());
		center.add(memoryViewPanel3.createMemoryDisplay());

		frame.add(cpuViewPanel.createCPUDisplay(), BorderLayout.PAGE_START);	
		frame.add(controlPanel.createControlDisplay(), BorderLayout.PAGE_END);

		

		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		bar.add(menuBarBuilder.createFileMenu());
		bar.add(menuBarBuilder.createExecuteMenu());


		frame.setSize(1200,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public MachineView(MachineModel m)
	{
		locateDefaultDirectory();
		loadPropertiesFile();
		createAndShowGUI();
	}

	public void clearAll()
	{
		model.clear();
		programLoaded = false;
		noDataNeeded = false;
		state = States.NOTHING_LOADED;
		state.enter();
		setChanged();
		notifyObservers("Clear");
	}

	public void halt()
	{
		setRunning(false);
	}

	public void setPeriod(int period)
	{
		if (timer != null)
			timer.setDelay(period);
	}

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new MachineView(new MachineModel(true)); 
			}
		});
	}
}