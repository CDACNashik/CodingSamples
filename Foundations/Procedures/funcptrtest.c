#include <stdio.h>


float PrimarySequence(int term)
{
	return 5 * term - 2;
}

float SecondarySequence(int term)
{
	return term * term + 1;
}

/*
double SummationPrimary(int count)
{
	double total = 0;
	register int i;

	for(i = 1; i <= count; ++i)
		total += PrimarySequence(i);

	return total;
}

double SummationSecondary(int count)
{
	double total = 0;
	register int i;

	for(i = 1; i <= count; ++i)
		total += SecondarySequence(i);

	return total;
}
*/

//second parameter (sequence) is of function pointer type and it addresses 
//any function with one int type parameter and float type return value
double Summation(int count, float (*sequence)(int))
{
	double total = 0;
	register int i;

	for(i = 1; i <= count; ++i)
		total += sequence(i); //calls function addressed by sequence

	return total;
}


int main(void)
{
	int n;
	printf("Number of terms: ");
	scanf("%d", &n);

	//printf("Sum of Primary Terms = %.2lf\n", SummationPrimary(n));
	//printf("Sum of Secondary Terms = %.2lf\n", SummationSecondary(n));
	printf("Sum of Primary Terms = %.2lf\n", Summation(n, PrimarySequence));
	printf("Sum of Secondary Terms = %.2lf\n", Summation(n, SecondarySequence));
}

