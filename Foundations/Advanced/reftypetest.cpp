#include <iostream>


class Banner
{
public: 
        
	void Resize(float l, float b) //void Banner::Resize(Banner* this, float l, float b)
	{
		length = l; //this->length = l;
		breadth = b; //this->breadth = b;
	}

	double Area() const //double Banner::Area(const Banner* this)
	{
		return length * breadth - 0.86 * radius * radius;
		//return this->length * this->breadth - 0.86 * this->radius * this->radius;
	}

	Banner(float l=80, float b=25, float r=0)
	{
		length = l;
		breadth = b;
		radius = r;
		std::cout << "Banner instance initialized" << std::endl;
	}

	//destructor - a special function which handles finalization (removing side-effect of constructor)
	//of instance, it is called just before the instanced is removed from memory
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

//Reference type (T&) - it is higher level equivalent of pointer type (T*) which automatically
//(1) addresses the value assigned to it without requiring address of (&) operator
//(2) indirects to its addressed value without requiring dereferencing (*) operator
double BannerPrice(const Banner& b) //b is a read-only reference
{
	double area = b.Area(); //(*b).Area() === b->Area()
	float rate = area < 100 ? 6.25 : 8.75;

	//b.Resize(0, 0);
	return rate * area;
}

int main(void)
{
	Banner mybanner; 
	std::cout << "Price of my banner = "
		  << BannerPrice(mybanner) //(&mybanner)
		  << std::endl;

	float w, h;
	std::cout << "Width and Height of your Banner: ";
	std::cin >> w >> h;
	float c = 0.1 * (w + h) / 2;
	Banner yourbanner(w, h, c);
	std::cout << "Price of your banner = "
		  << BannerPrice(yourbanner) //(&yourbanner)
		  << std::endl;
}

