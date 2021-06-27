class Server {

	public static void main(String[] args) throws Exception {
		var naming = new javax.naming.InitialContext(); //reads jdnd.properties and connects to th name-service (rmi registry)
		var ds = new oracle.jdbc.pool.OracleConnectionPoolDataSource(); //new com.mysql.cj.jdbc.MysqlConnectionPoolDataSource()
		ds.setURL("jdbc:oracle:thin:@//localhost/xe"); //"jdbc:mysql://localhost/sales"
		ds.setUser("scott");
		ds.setPassword("tiger");
		naming.rebind("jdbc/SalesDB", ds);
		naming.rebind("order-support", new shopping.OrderManagerService());
	}
}

