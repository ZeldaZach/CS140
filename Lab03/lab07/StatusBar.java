package lab07;

public class StatusBar extends Buffer
{
	private Buffer attachedTo;
	
	public StatusBar(Buffer at)
	{
		attachedTo = at;
	}
	
	@Override
	public String getText()
	{
		return "----- lines: " + attachedTo.getNumlines() + " -----";
	}
}
