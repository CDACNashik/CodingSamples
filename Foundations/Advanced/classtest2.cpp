#include <iostream>

class Banner
{
public: 
        
	void Resize(float l, float b)
	{
		length = l; 
		breadth = b;
	}

	double Area() 
	{
		return length * breadth - 0.86 * radius * radius;
	}

	//parameterized constructor which is also a  default constructor because
	//it provides default arguments for each of its parameters
	Banner(float l=80, float b=25, float r=0)
	{
		length = l;
		breadth = b;
		radius = r;
	}
	//Banner() => Banner(80, 25, 0)
	//Banner(90) => Banner(90, 25, 0)
	//Banner(90, 35) => Banner(90, 35, 0)
	//Banner(90, 35, 1) 

private:

	float length;
	float breadth;
	float radius;
};

double BannerPrice(Banner b)
{
	double area = b.Area(); 
	float rate = area < 100 ? 6.25 : 8.75;

	return rate * area;
}

int main(void)
{
	Banner mybanner; 
	std::cout << "Price of my banner = "
		  << BannerPrice(mybanner)
		  << std::endl;

	float w, h;
	std::cout << "Width and Height of your Banner: ";
	std::cin >> w >> h;
	float c = 0.1 * (w + h) / 2;
	Banner yourbanner(w, h, c); // initializing instance using parameterized constructor
	std::cout << "Price of your banner = "
		  << BannerPrice(yourbanner)
		  << std::endl;
}

