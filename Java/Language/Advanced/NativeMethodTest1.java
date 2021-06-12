class NativeMethodTest1 {

	private native static long gcd(long first, long second);

	public static void main(String[] args) {
		System.loadLibrary("nmtsup"); //on UNIX this translates to libnmtsup.so which will be searched in each directory specified in java.library.path
		switch(args[0]){
			case "gcd":
				long m = Long.parseLong(args[1]);
				long n = Long.parseLong(args[2]);
				System.out.println(gcd(m, n));
				break;
		}
	}
}

