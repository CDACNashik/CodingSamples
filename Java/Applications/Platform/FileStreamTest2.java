import java.io.*;

class FileStreamTest2 {

	public static void main(String[] args) throws Exception {
		if(args.length > 2) {
			String name = args[0].toLowerCase();
			double price = Double.parseDouble(args[1]);
			int stock = Integer.parseInt(args[2]);
			var output = new DataOutputStream(new FileOutputStream("store.data", true));
			output.writeUTF(name);
			output.writeDouble(price);
			output.writeInt(stock);
			output.close();
		}else{
			var input = new DataInputStream(new FileInputStream("store.data"));
			while(input.available() > 0){
				String name = input.readUTF();
				double price = input.readDouble();
				int stock = input.readInt();
				System.out.printf("%-16s%10.2f%8d%n", name, price, stock);
			}
			input.close();
		}
	}
}

