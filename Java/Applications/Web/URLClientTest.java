import java.io.*;
import java.net.*;

class URLClientTest {

	public static void main(String[] args) throws Exception {
		String host = args.length > 1 ? args[1] : "localhost";
		String addr = String.format("http://%s:6004/%s", host, args[0]);
		var url = new URL(addr);
		try{
			var reader = new BufferedReader(new InputStreamReader(url.openStream()));
			System.out.printf("Share Price: %s%n", reader.readLine());
			reader.close();
		}catch(FileNotFoundException e){
			System.out.println("No such symbol!");
		}
	}
}

