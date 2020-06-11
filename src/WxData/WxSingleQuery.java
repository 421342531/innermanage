package WxData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxSingleQuery {
	
		
		public static List<Map<String,String>> getProductInfo(String queryID){
			
			ResultSet rs ;
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			
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
				 "jdbc:mysql://localhost:3306/mysql","root","nbcb,111");
				//java这个空填写的是你自己设的密码
				 
				System.out.println("Success connect Mysql server!");
				 PreparedStatement pstmt = null;
				 	String sql = "select * from productinfo t where t.id="+queryID;
					pstmt = connect.prepareStatement(sql);
				//	pstmt.setString(1, queryId);
				
					rs = pstmt.executeQuery();
				while(rs.next()) {
					
					HashMap<String,String> hashMap =new HashMap<String,String>();
					
					String idout = rs.getString("id")==null?"":rs.getString("id");
					String inPriceout = rs.getString("inPrice")==null?"":rs.getString("inPrice");
					String salePriceout = rs.getString("salePrice")==null?"":rs.getString("salePrice");
					String markout = rs.getString("mark")==null?"":rs.getString("mark");
					hashMap.put("id", idout);
					hashMap.put("inPrice", inPriceout);
					hashMap.put("salePrice", salePriceout);
					hashMap.put("mark", markout);
					
					System.out.println(
							"mysql output = "+
							"id:"+idout+
							" inprice:"+inPriceout+
							" salePriceout:"+salePriceout+
							" markout:"+markout);
					list.add(hashMap);
				}
				
				
				
				
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 for(Map map:list) {
					String str1 = (String) map.get("id");
					String str2 = (String )map.get("inPrice");
					String str3 = (String )map.get("salePrice");
					String str4 = (String )map.get("mark");
					System.out.println("list:"+str1+" "+str2+" "+str3+" "+str4);
					
				}
			 
			 return list;
			
		}
			
		

	}


