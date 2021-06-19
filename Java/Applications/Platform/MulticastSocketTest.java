import java.net.*;

class MulticastSocketTest {

	public static void main(String[] args) throws Exception {
		var addr = new InetSocketAddress("230.0.0.1", 0);
		var subscriber = new MulticastSocket(6001);
		subscriber.joinGroup(addr, null);
		var packet = new DatagramPacket(new byte[65507], 65507);
		for(int i = 0; i < 5; ++i){
			subscriber.receive(packet);
			String msg = new String(packet.getData(), 0, packet.getLength());
			System.out.println(msg);
		}
		subscriber.leaveGroup(addr, null);
		subscriber.close();
	}
}

