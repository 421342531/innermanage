package WxData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class WxSingleInsert {
	
		
		public static String insertProductInfo(String insertID,
												String insertInPrice,
													String insertSalePrice,
														String insertMark){
			
			String  re = "^[0-9]+.?[0-9]*$"; 
			    if(!insertInPrice.matches(re)||!insertSalePrice.matches(re)) {
			    	
			    	return "-1";//输入不对
			    }
			
			int rr = 0;
			
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 	System.out.println("Success loading Mysql Driver!");
			}
			 catch (Exception e) {
				 System.out.print("Error loading Mysql Driver!");
				 e.printStackTrace();
				  }
			 try {
				Connection connect = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/mysql?characterEncoding=utf8","root","nbcb,111");
				//java这个空填写的是你自己设的密码
				 
				System.out.println("Success connect Mysql server!");
				Statement statement =connect.createStatement();
				
				ResultSet rs ;
				int rr_query=0;
				String sql_qeuery =
			 			"select count(1) from productinfo t where t.id="+insertID;
				//int rr_query = statement.executeUpdate(sql_qeuery);
				PreparedStatement pstmt = null;
				pstmt = connect.prepareStatement(sql_qeuery);
				rs = pstmt.executeQuery();
			
				while(rs.next()) {
					rr_query=rs.getInt(1);
				}
				
				
				if(rr_query==0){
					String sql = "insert into productinfo VALUES('"+
				 			insertID+"','"+insertInPrice+"','"+insertSalePrice+"','"+insertMark+"')";
				 	System.out.println("insert sql = "+sql);
				 	 rr = statement.executeUpdate(sql);
				 	System.out.println("新增结果是： "+rr);
				 	// 0 or 1
				}else if(rr_query==1){
					String sql_update = "UPDATE productinfo set inPrice ='"+insertInPrice
							+"' ,saleprice='"+insertSalePrice+"',mark='"+insertMark+"'"+" where id ='"+insertID+"'";
				 	System.out.println("update sql = "+sql_update);
				 	 rr = statement.executeUpdate(sql_update);
				 	System.out.println("更新结果是： "+rr);
				 	
				}
				
				 	
				 	
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 return ""+rr;
			
		}
			
		

	}


