package onlineStore;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class ProductDBHandler {
	private Connection DB;

	public ProductDBHandler() {
		try {
			DB = SingletonDB.getDB().getConnection();
		} catch (SQLException e) {
			System.out.println("Cant' Connect to The DataBase");
			e.printStackTrace();
		}
	}
	
	public void addOnlineProduct(String productID,String productName,float productPrice
			,int quantity,float discount,String category,String storeID) throws SQLException {
		
	/*	
	 | PRODUCTID       | varchar(100) | NO   | PRI | NULL    |       |
| ONLINESTORENAME | varchar(50)  | NO   | PRI | NULL    |       |
| PRODUCTPRICE    | float        | YES  |     | NULL    |       |
| PRODUCTQUANTITY | int(11)      | YES  |     | NULL    |       |
| PRODUCTDISCOUNT | float        | YES  |     | NULL    |       |
| numberOfViews   | int(11)      | YES  |     | NULL    |       |
| CATEGORYNAME    | varchar(20)  | YES  | MUL | NULL   

*/
		String insertQuery = "INSERT INTO ONLINESTOREPRODUCT (PRODUCTID,ONLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews,CATEGORYNAME)"
				+ "VALUES " + "('" + (productID+storeID) + "', '" + storeID + "',"
				+"'"+productPrice+"','"+quantity+"','"+discount+"',0,'"+category+"');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}
	
	

	public void addOflineProduct(String productID,String productName,float productPrice
			,int quantity,float discount,String category,String storeID) throws SQLException {
		
	/*	
	 | PRODUCTID       | varchar(100) | NO   | PRI | NULL    |       |
| ONLINESTORENAME | varchar(50)  | NO   | PRI | NULL    |       |
| PRODUCTPRICE    | float        | YES  |     | NULL    |       |
| PRODUCTQUANTITY | int(11)      | YES  |     | NULL    |       |
| PRODUCTDISCOUNT | float        | YES  |     | NULL    |       |
| numberOfViews   | int(11)      | YES  |     | NULL    |       |
| CATEGORYNAME    | varchar(20)  | YES  | MUL | NULL   

*/
		String insertQuery = "INSERT INTO OFFLINESTOREPRODUCT (PRODUCTID,ONLINESTORENAME,PRODUCTPRICE,"
				+ "PRODUCTQUANTITY,PRODUCTDISCOUNT,numberOfViews,CATEGORYNAME)"
				+ "VALUES " + "('" + (productID+storeID) + "', '" + storeID + "',"
				+"'"+productPrice+"','"+quantity+"','"+discount+"',0,'"+category+"');";
		System.out.println("Creating statement...");
		Statement stmt = DB.createStatement();

		stmt.executeUpdate(insertQuery);

	}
	public void updateView(String productID) {
		
	}

}