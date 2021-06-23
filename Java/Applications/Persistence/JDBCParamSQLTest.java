import java.sql.*;

class JDBCParamSQLTest {

	public static void main(String[] args) throws Exception {
		String customer = args[0].toUpperCase();
		int product = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Date today = new Date(System.currentTimeMillis());
		var con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost/xe", "scott", "tiger");
		con.setAutoCommit(false); //begins an explicit transaction
		try{
			var stmt = con.createStatement();
			stmt.executeUpdate("update counters set cur_val=cur_val+1 where ctr_name='orders'");
			var rs = stmt.executeQuery("select cur_val+1000 from counters where ctr_name='orders'");
			rs.next();
			int orderNo = rs.getInt(1);
			rs.close();
			stmt.close();
			var pstmt  = con.prepareStatement("insert into orders values(?, ?, ?, ?, ?)");
			pstmt.setInt(1, orderNo);
			pstmt.setDate(2, today);
			pstmt.setString(3, customer);
			pstmt.setInt(4, product);
			pstmt.setInt(5, quantity);
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){
			con.rollback();
			System.out.printf("Order Failed: %s%n", e.getMessage());
		}
		con.close();
	}
}

