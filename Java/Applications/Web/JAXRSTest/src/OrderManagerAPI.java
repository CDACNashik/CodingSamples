package modern.web.app;

import shopping.*;
import java.rmi.*;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/orders")
public class OrderManagerAPI {

	/*
	@GET
	@Path("/now")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTime() {
		return new Date().toString();
	}
	*/

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readOrders(@PathParam("id") String customerId) {
		try{
			OrderManager client = (OrderManager)Naming.lookup("rmi://localhost:20000/order-support");
			List<OrderEntity> result = client.getOrdersOf(customerId);
			if(result.size() == 0)
				return Response.status(404).build();
			return Response.ok(result).build(); //Response.status(200).entity(result).build();
		}catch(Exception e){
			String msg = e.getMessage();
			return Response.serverError().entity(msg).type("text/plain").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrder(OrderEntity entry) {
		try{
			OrderManager client = (OrderManager)Naming.lookup("rmi://localhost:20000/order-support");
			int id = client.placeOrder(entry.getCustomerId(), entry.getProductNo(), entry.getQuantity());
			entry.setOrderNo(id);
			return Response.ok(entry).build();
		}catch(Exception e){
			String msg = e.getMessage();
			return Response.serverError().entity(msg).type("text/plain").build();
		}
	}

}


