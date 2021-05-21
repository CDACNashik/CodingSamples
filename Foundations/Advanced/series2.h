namespace Series
{
	class Sequence //Abstract Data Type (ADT) it is a class which does not support creation of instances 
	               //since it defines at least one pure virtual function. It is defined specifically fo
		       //substitution purpose only
	{
	public:
		virtual double Next() = 0; //pure virtual function (will include zero-entry in v-table of Sequence)
		double Sum(int);
	};

	class LinearSequence : public Sequence
	{
	public:
		LinearSequence(float, float);
		double Next();
		double Seek(int);
	private:
		float current;
		float step;
	};

	class PowerSequence : public Sequence
	{
	public:
		PowerSequence(float);
		double Next();
	private:
		double current;
		float ratio;
	};
}


