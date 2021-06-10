//a class without an explicit superclass implicitly extends java.lang.Object which is the common root of all reference types
class Interval {
	
	private int hour;
	private int min;
	private int sec;

	public Interval(int m, int s) {
		min = m + s / 60;
		sec = s % 60;
	}

	public int minutes() { return min; }

	public int seconds() { return sec; }

	public int time() { return 60 * min + sec; }

	//overriding method of java.lang.Object to return the string representation of the state of this object
	public String toString() {
		return String.format("%d:%02d", min, sec);
	}

	//overriding method of java.lang.Object to return same integer value for objects with matching state
	public int hashCode() {
		return min + sec;
	}

	//overriding method of java.lang.Object to return true only if this and other object are instance of same class and have matching state
	public boolean equals(Object other) {
		if(other instanceof Interval){
			Interval that = (Interval) other;
			return (this.min == that.min) && (this.sec == that.sec);
		}
		return false;
	}
}

