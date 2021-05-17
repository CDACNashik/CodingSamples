typedef enum {Rectangular, Triangular, Elliptical} Geometry;

typedef struct {
	float width;
	float height;
	Geometry shape;
	char text[80];
}Banner;

//double BannerPrice(float width, float height);
double BannerPrice(const Banner*);

int BannerPrint(Banner);
