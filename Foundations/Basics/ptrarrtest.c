#include "console.h"

//year identifies an array containing 64-bit integer values
long long year[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

//month identifies a 32-bit integer value
int month;

int main(void)
{
	//b identifies address of a 32-bit integer value currently identified by month
	int* b = &month; //mov rbx, offset month
	//*b indirects(refers) to value addressed by b
	int c = *b; //mov rcx, [rbx]

	month = GetInt("Month[1-12]: ");
	PutInt("Number of Days = ", year[month - 1]);
}

