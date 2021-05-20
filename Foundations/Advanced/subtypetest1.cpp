#include "series1.h"
#include <iostream>
#include <string>

using namespace Series;

/*
void PrintSequence(std::string label, LinearSequence& seq, int count)
{
	std::cout << label << ":";
	for(int i = 1; i <= count; ++i)
		std::cout << " " << seq.Next();
	std::cout << std::endl;
}

void PrintSequence(std::string label, PowerSequence& seq, int count)
{
	std::cout << label << ":";
	for(int i = 1; i <= count; ++i)
		std::cout << " " << seq.Next();
	std::cout << std::endl;
}
*/

void PrintSequence(std::string label, Sequence& seq, int count)
{
	std::cout << label << ":";
	for(int i = 1; i <= count; ++i)
		std::cout << " " << seq.Next(); //virtual dispatch (call Next function from virtual table addressed by virtual pointer of seq)
	std::cout << std::endl;
}

int main(void)
{
	int n;
	std::cout << "Number of years: ";
	std::cin >> n;

	LinearSequence s(1, 3);
	PrintSequence("Supply", s, n); //substituting LinearSequence for Sequence

	PowerSequence d(2);
	PrintSequence("Demand", d, n); //substituting PowerSequence for Sequence
}


