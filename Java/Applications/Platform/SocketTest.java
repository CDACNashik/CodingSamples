import java.io.*;
import java.net.*;
import java.util.*;

class SocketTest {

	public static void main(String[] args) throws Exception {
		var input = new Scanner(System.in);
		String server = args.length > 0 ? args[0] : "localhost";
		var client = new Socket();
		var remote = new InetSocketAddress(server, 6001);
		client.connect(remote);
		var reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		var writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		System.out.print("Item and Quantity: ");
		String item = input.next();
		int quantity = input.nextInt();
		System.out.println(reader.readLine());
		writer.println(item);
		writer.flush();
		String info = reader.readLine();
		writer.close();
		reader.close();
		client.close();
		if(info != null){
			String[] parts = info.split("&");
			double price = Double.parseDouble(parts[0].substring(6));
			int stock = Integer.parseInt(parts[1].substring(6));
			if(quantity > stock)
				System.out.println("Out of stock!");
			else
				System.out.printf("Total payment: %.2f%n", quantity * price);
		}else{
			System.out.println("Not available!");
		}

	}
}

