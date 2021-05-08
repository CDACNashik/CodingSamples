#include "console.h"

long count = 23;

namespace Jack
{
	long count = 45;
}

int main(void)
{
	long count = 32;

	PutInt("Result = ", ::count + count + Jack::count);
}

