#include "series2.h"

namespace Series
{
	double Sequence::Sum(int count)
	{
		double total = 0;

		for(int i = 1; i <= count; ++i)
			total += Next();

		return total;
	}

						
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

	double LinearSequence::Seek(int term)
	{
		return current += step * (term - 1);
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

