package shopping;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Date;
import javax.persistence.Persistence;

public class OrderManagerService extends java.rmi.server.UnicastRemoteObject  implements OrderManager {


	public OrderManagerService() throws RemoteException {
		super(6003); //exports this object on TCP port 6003
	}

	public int placeOrder(String customerId, int productNo, int quantity) throws RemoteException {
		var emf = Persistence.createEntityManagerFactory("ShopPU");
		var em = emf.createEntityManager();
		try{
			var tx = em.getTransaction();
			tx.begin();
			var ctr = em.find(CounterEntity.class, "orders");
			int orderNo = ctr.getNextValue() + 1000;
			var ord = new OrderEntity();
			ord.setOrderNo(orderNo);
			ord.setOrderDate(new Date());
			ord.setCustomerId(customerId);
			ord.setProductNo(productNo);
			ord.setQuantity(quantity);
			em.persist(ord);
			tx.commit(); //will rollback transaction if any update fails
			return orderNo;
		}finally{
			em.close();
		}
	}

	public List<OrderEntity> getOrdersOf(String customerId) throws RemoteException {
		var emf = Persistence.createEntityManagerFactory("ShopPU");
		var em = emf.createEntityManager();
		try{	
			var query = em.createNamedQuery("findOrdersByCustomerId", OrderEntity.class);
			query.setParameter(1, customerId);
			return query.getResultList();
		}finally{
			em.close();
		}

	}
}

