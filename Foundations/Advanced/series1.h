namespace Series
{
	class Sequence
	{
	public:
		//enable virtual dispatch for this function
		virtual double Next()
		{
			return 0;
		}
	};

	//LinearSequence can be used as a substitute for Sequence
	class LinearSequence : public Sequence
	{
	public:
		LinearSequence(float, float);
		double Next();
	private:
		float current;
		float step;
	};

	//PowerSequence can used as a substitute for Sequence
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


