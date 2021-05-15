#include <iostream>

using namespace std;

extern "C" int CountPrimes(long, long); //function is defined in a C module (no name-mangling)

int main(void)
{
	long lower, upper;
	cout << "Lower and Upper Limit: ";
	cin >> lower >> upper;

	cout << "Number of Primes = "
	     << CountPrimes(lower, upper)
	     << endl;
}

