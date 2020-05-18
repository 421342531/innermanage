package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteSQl {
	
	public static int deleteInfoFunc(String deleteId ) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 	System.out.println("Success loading Mysql Driver!");
	 	Connection connect = DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/mysql","root","nbcb,111");
	 	PreparedStatement statement ;

	 	String sql = "delete from productinfo where id=?";
		statement = connect.prepareStatement(sql);
		statement.setString(1, deleteId );
		System.out.println("deleteId "+deleteId);
		int rr = statement.executeUpdate();// 更新成功条数 1为更新成功，0未更新
		statement.close();
		return rr;
	}
	
	
	
}

