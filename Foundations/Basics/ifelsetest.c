#include <stdio.h>

int main(void)
{
	int lower, upper;
	long total;

	printf("Input lower and upper limits: ");
	scanf("%d%d", &lower, &upper);

	if(lower < upper)
	{
		total = upper * (upper + 1) / 2 - (lower - 1) * lower / 2;
		printf("Sum of Integers = %ld\n", total);
	}
	else
	{
		printf("Error: Invalid range!\n");
	}
}

