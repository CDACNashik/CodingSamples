#include <iostream>


class Banner
{
public: 
        
	void Resize(float l, float b) 
	{
		length = l;
		breadth = b;
	}

	double Area() const
	{
		return length * breadth - 0.86 * radius * radius;
	}

	Banner(float l=80, float b=25, float r=0)
	{
		length = l;
		breadth = b;
		radius = r;
		std::cout << "Banner instance initialized" << std::endl;
	}

	~Banner()
	{
		std::cout << "Banner instance finalized" << std::endl;
	}

private:

	float length;
	float breadth;
	float radius;
	char text[80];
};

double BannerPrice(const Banner* b) 
{
	double area = b->Area();
	float rate = area < 100 ? 6.25 : 8.75;

	return rate * area;
}

int Run(void)
{
	Banner* mybanner = new Banner; //initializing a new instance of Banner on heap (dynamic allocation) using default constructor 
	std::cout << "Price of my banner = "
		  << BannerPrice(mybanner)
		  << std::endl;
	delete mybanner; //remove instance addressed by mybanner from heap

	Banner* yourbanner = new Banner(40, 15, 1); //initializing a new instance of Banner on heap using parameterized constructor
	std::cout << "Price of your banner = "
		  << BannerPrice(yourbanner)
		  << std::endl;
	delete yourbanner;
}

int main(void)
{
	Run();
}


