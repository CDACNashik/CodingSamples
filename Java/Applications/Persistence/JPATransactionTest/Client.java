import shopping.OrderManager;
import java.rmi.Naming;

class Client {

	public static void main(String[] args) throws Exception {
		String customerId = args[0].toUpperCase();
		var stub = (OrderManager)Naming.lookup("rmi://localhost:1099/order-support");
		if(args.length > 2){
			int productNo = Integer.parseInt(args[1]);
			int quantity = Integer.parseInt(args[2]);
			try{
				int orderNo = stub.placeOrder(customerId, productNo, quantity);
				System.out.printf("New Order Number: %d%n", orderNo);
			}catch(Exception e){
				System.out.printf("Order Failed: %s%n", e.getCause().getMessage());
			}
		}else{
			var orders = stub.getOrdersOf(customerId);
			for(var i : orders)
				System.out.printf("%d\t%d\t%s%n", i.getProductNo(), i.getQuantity(), i.getOrderDate());
		}
	}
}

