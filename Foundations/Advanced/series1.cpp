#include "series1.h"

namespace Series
{
						
	LinearSequence::LinearSequence(float first, float diff)
	{
		current = first;
		step = diff;
	}

	double LinearSequence::Next()
	{
		double result = current;
		current += step;
		return result;
	}

	PowerSequence::PowerSequence(float mult)
	{
		current = 1;
		ratio = mult;
	}

	double PowerSequence::Next()
	{
		double result = current;
		current *= ratio;
		return result;
	}
}

