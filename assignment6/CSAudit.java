package assignment06;

import java.util.ArrayList;

public class CSAudit implements DegreeAudit
{
	@Override
	public boolean hasWritingRequirement()
	{
		return true;
	}
	
	/**
	 * Looking for one of the following:
	 * 1 C/J AND "CS301"
	 */
	@Override
	public boolean writingSatisfied(ArrayList<CourseOffering> list)
	{
		boolean retVal = false, hasTaken301 = false;
		int totalC = 0;

		for (int i = 0; i < list.size(); i++)
		{
			if (!hasTaken301) // Make sure CS301 is taken
				if (list.get(i).getName().equals("CS301"))
					hasTaken301 = true;

			ArrayList<String> tmp = list.get(i).getAnnotations();
			for (int j = 0; j < tmp.size(); j++)
			{
				if (tmp.get(j).equals("C")) // List contains Composition Requirement
				{
					totalC++;
				}
				else if (tmp.get(j).equals("J")) // List contains Joint Requirement
				{
					totalC++;
				}
			}
		}
		
		if (totalC >= 1 && hasTaken301) // Satisfy all requirements
			retVal = true;
		
		return retVal;
	}
}
