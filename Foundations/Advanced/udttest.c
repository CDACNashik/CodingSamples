#include "banner.h"
#include <stdio.h>

int main(void)
{
	Banner mybanner  = {0, 0};
	float w, h;
	printf("Width and Height of Banner: ");
	scanf("%f%f", &w, &h);

	mybanner.width = w;
	mybanner.height = h;
	printf("Price of Rectangular Banner: %.2lf\n", BannerPrice(&mybanner));
	mybanner.shape = Elliptical;
	printf("Price of Elliptical Banner: %.2lf\n", BannerPrice(&mybanner));
}

