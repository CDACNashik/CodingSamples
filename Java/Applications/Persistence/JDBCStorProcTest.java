import java.sql.*;

class JDBCStorProcTest {

	public static void main(String[] args) throws Exception {
		String customer = args[0].toUpperCase();
		int product = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		var con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost/xe", "scott", "tiger");
		try{
			var cstmt = con.prepareCall("{call place_order(?, ?, ?, ?)}");
			cstmt.setString(1, customer);
			cstmt.setInt(2, product);
			cstmt.setInt(3, quantity);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.execute();
			int orderNo = cstmt.getInt(4);
			cstmt.close();
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){
			System.out.printf("Order Failed: %s%n", e.getMessage());
		}
		con.close();
	}
}

