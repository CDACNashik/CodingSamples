#include <stdio.h>

long Summation(int count)
{
	return count * (count + 1) / 2;
}

int main(void)
{
	int lower, upper;
	long total;

	printf("Input lower and upper limits: ");
	scanf("%d%d", &lower, &upper);

	if(lower < upper)
	{
		total = Summation(upper) - Summation(lower - 1);
		printf("Sum of Integers = %ld\n", total);
	}
	else
	{
		printf("Error: Invalid range!\n");
	}
}

