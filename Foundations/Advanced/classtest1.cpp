#include <iostream>

class Banner
{
public: //members declared in this block are visible ever where
        //commonly includes function definitions.

	void Resize(float l, float b) //void Banner::Resize(Banner* this, float l, float b)
	{
		length = l; //this->length = l;
		breadth = b; //this->breadth = b;
	}

	double Area() //double Banner::Area(Banner* this)
	{
		return length * breadth; //this->length * this->breadth
	}

	//constructor - a special member function whose name matches with class name and it
	//handles initialization of a new instance. In C++ a constructor which can be called
	//without explicitly passing any argument is called a default constructor because it is called
	//automatically.
	Banner()
	{
		length = 80;
		breadth = 25;
	}
	

private: //members declared in this block are visible only within this class
	 //commonly includes variable definitions.

	float length;
	float breadth;
};

double BannerPrice(Banner b)
{
	double area = b.Area(); //Banner::Area(&b)
	float rate = area < 100 ? 6.25 : 8.75;

	return rate * area;
}

int main(void)
{
	Banner mybanner; //instance of Banner class will be initialized (on stack) using default constructor
	std::cout << "Price of my banner = "
		  << BannerPrice(mybanner)
		  << std::endl;

	float w, h;
	std::cout << "Width and Height of your Banner: ";
	std::cin >> w >> h;
	Banner yourbanner;
	//yourbanner.length = w;
	//yourbanner.breadth = h;
	yourbanner.Resize(w, h); //Banner::Resize(&yourbanner, w, h)
	std::cout << "Price of your banner = "
		  << BannerPrice(yourbanner)
		  << std::endl;
}

