import java.io.*;
import java.net.*;

class ServerSocketTest {

	public static void main(String[] args) throws Exception {
		//Step 1 - create a listener socket and bind it to a well-known local endpoint
		var listener = new ServerSocket();
		var local = new InetSocketAddress("0.0.0.0", 6001);
		listener.bind(local);
		//service(listener);
		for(int i = 0; i < 3; ++i){
			var servant = new Thread(() -> {
				try{
					service(listener);
				}catch(IOException e){}
			});
			servant.start();
		}
	}

	private static void service(ServerSocket server) throws IOException {
		var shop = new Shop();
		for(;;) {
			//Step 2 - accept client's connection request from the listener as a stream socket
			var client = server.accept();
			client.setSoTimeout(20000);
			//Step 3 - using streams of above socket exchange data with the connected client
			var input = client.getInputStream();
			var output = client.getOutputStream();
			var reader = new BufferedReader(new InputStreamReader(input));
			var writer = new PrintWriter(new OutputStreamWriter(output));
			try{
				writer.println("Welcome to TechnoWorld shop");
				writer.flush();
				String item = reader.readLine();
				var info = shop.find(item);
				if(info != null){
					writer.printf("price=%.2f&stock=%d%n", info.price(), info.stock());
					writer.flush();
				}
			}catch(Exception e){}
			//Step 4 - disconnect the client by closing the streams and the socket
			output.close();
			input.close();
			client.close();
			//Step 5 - go to step 2
		}
	}

}

