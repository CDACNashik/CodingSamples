#include "banner.h"

/*

double BannerPrice(float width, float height)
{
	double area = width * height;
	rate = area < 100 ? 6.25 : 8.75;

	return rate * area;
}
*/

//Prefer accepting structured type data by address (instead of value to avoid unnecessary copying of data)
//and qualify this address parameter with const (to indicate that the addressed value will be treated as read-only)
double BannerPrice(const Banner* b)
{
	double area;
	float rate;

	switch(b->shape)
	{
	case Rectangular:
		area = b->width * b->height;
		break;
	case Triangular:
		area = 0.5 * b->width * b->height;
		break;
	case Elliptical:
		area = (3.14 / 4) * b->width * b->height;
		break;
	};

	rate = area < 100 ? 6.25 : 8.75;
	//b->shape = Triangular;
	return rate * area;
}

int BannerPrint(Banner b)
{
	//code for printing b.text
	b.shape = Triangular;
	return 1;
}



