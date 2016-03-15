package assignment06;

import java.util.ArrayList;

public interface DegreeAudit
{
	default boolean hasWritingRequirement()
	{
		return false;
	}
	
	default boolean writingSatisfied(ArrayList<CourseOffering> list)
	{
		throw new UnsupportedOperationException();
	}
}
