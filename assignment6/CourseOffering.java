package assignment06;

import java.util.ArrayList;

public class CourseOffering
{
	private String name, title;
	private int semester;
	private ArrayList<String> annotations;
	
	public CourseOffering(String name, String title, int semester, ArrayList<String> annotations)
	{
		this.name = name;
		this.title = title;
		this.semester = semester;
		this.annotations = annotations;
	}

	public String getName()
	{
		return name;
	}

	public String getTitle()
	{
		return title;
	}

	public int getSemester()
	{
		return semester;
	}

	public ArrayList<String> getAnnotations()
	{
		return annotations;
	}
}
