package assignment06;

import java.util.ArrayList;

public class HarpurAudit implements DegreeAudit
{
	@Override
	public boolean hasWritingRequirement()
	{
		return true;
	}
	
	/**
	 * Looking for one of the following:
	 * 2 C/J + 3 W
	 * 3 C/J + 1 W
	 * 4 C/J
	 */
	@Override
	public boolean writingSatisfied(ArrayList<CourseOffering> list)
	{
		boolean retVal = false;
		int totalC = 0, totalW = 0;

		for (int i = 0; i < list.size(); i++)
		{
			ArrayList<String> tmp = list.get(i).getAnnotations();
			for (int j = 0; j < tmp.size(); j++)
			{
				if (tmp.get(j).equals("W")) // List contains Writing Requirement
				{
					totalW++;
				}
				else if (tmp.get(j).equals("C")) // List contains Composition Requirement
				{
					totalC++;
				}
				else if (tmp.get(j).equals("J")) // List contains Joint Requirement
				{
					totalC++;
				}
			}
		}

		if ((totalC >= 2 && totalW >= 3) || (totalC >= 3 && totalW >= 1) || (totalC >= 4)) // Satisfy all requirements
			retVal = true;
		
		return retVal;
	}
}
