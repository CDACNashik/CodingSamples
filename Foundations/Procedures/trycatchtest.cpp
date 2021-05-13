#include <iostream>
#include <string>

using namespace std;

long Compute(int first, int last, short step)
{
	long result  = 0;

	if(first > last)
		throw string("Invalid range");

	if(step <= 0)
		throw step;

	for(int current = first; current <= last; current += step)
	{
		result += current * current;
	}

	return result;
}


int main(void)
{

	int l, u;
	cout << "Lower and Upper Limit: ";
	cin >> l >> u;

	short i;
	cout << "Increment: ";
	cin >> i;

	try
	{
		cout << "Your Computation Result = "
	     	     << Compute(l, u, i)
	     	     << endl;
	}
	catch(string err)
	{
		cout << err << endl;
	}
	catch(short s)
	{
		cout << "Invalid increment value: " << s << endl;
	}
}

