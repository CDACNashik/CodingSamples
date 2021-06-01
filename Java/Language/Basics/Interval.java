//a class without an explicit superclass implicitly extends java.lang.Object which is a common root for all reference types
class Interval {

	private int min;
	private int sec;

	public Interval(int m, int s) {
		min = m + s / 60;
		sec = s % 60;
	}

	public int minutes() { return min; }

	public int seconds() { return sec; }

	public int time() { return 60 * min + sec; }
}

