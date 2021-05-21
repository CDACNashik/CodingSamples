#include "series2.h"
#include <iostream>
#include <string>

using namespace Series;


void PrintSequence(std::string label, Sequence& seq, int count)
{
	std::cout << label << ":";
	for(int i = 1; i <= count; ++i)
		std::cout << " " << seq.Next();
	std::cout << std::endl;
}

double Average(Sequence* sq, int count)
{
	LinearSequence* lsq = dynamic_cast<LinearSequence*>(sq); //will return zero if sq does not point an instance of LinearSequence
	if(lsq)
	{
		double first = lsq->Seek(1);
		double last = lsq->Seek(count);
		return (first + last) / 2;
	}
	return sq->Sum(count) / count;
}

int main(void)
{
	int n;
	std::cout << "Number of years: ";
	std::cin >> n;

	LinearSequence s(1, 3);
	std::cout << "Average Supply: " << Average(&s, n) << std::endl;
	PowerSequence d(2);
	std::cout << "Average Demand: " << Average(&d, n) << std::endl;
}


