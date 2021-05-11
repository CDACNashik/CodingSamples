#include <stdio.h>

int main(void)
{
	long num;
	register long a, b, c; //if possible store values in registers instead of memory

	printf("Integer Value: ");
	scanf("%ld", &num);

	a = 1;
	b = num < 0 ? -num : num;
	c = 0;

	do
	{
		c = c + 1;
		a = a * 10;
	}
	while(a <= b);

	printf("Number of Digits = %ld\n", c);
}

