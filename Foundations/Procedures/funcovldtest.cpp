#include <iostream>


long Compute(int first, int last, short step)
{
	long result  = 0;

	for(int current = first; current <= last; current += step)
	{
		result += current * current;
	}

	return result;
}

//overloading of Compute function (same name but different list of parameters)
long Compute(int last, short step)
{
	return Compute(1, last, step);
}

int main(void)
{
	using namespace std;

	int l, u;
	cout << "Lower and Upper Limit: ";
	cin >> l >> u;

	short i;
	cout << "Increment: ";
	cin >> i;

	cout << "Your Computation Result = "
	     << Compute(l, u, i)
	     << endl;
	cout << "Simple Computation Result = "
	     << Compute(u, 1)
	     << endl;
}

