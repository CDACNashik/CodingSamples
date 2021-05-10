#include <stdio.h>

int main(void)
{
	short age;
	float amount;

	printf("Age: ");
	scanf("%hd", &age);

	switch(age)
	{
	case 16:
		amount = 60.55;
		break;
	case 18:
		amount = 75.35;
		break;
	case 21:
		amount = 99.99;
		break;
	case 50:
		amount = 120.65;
		break;
	default:
		amount = 50;
	}
	
	printf("Gift Amount = %.2f\n", age * amount);
}

