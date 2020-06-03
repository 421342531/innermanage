package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//统计售价的价格分布
public class OutpriceTongji {
	
	
	public static int[] getProductInfo(){
		ResultSet rs ;
		int count[]= {0,0,0,0,0};
		
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
			 int qujian[][]= new int[5][2];
			 //0~10
			 qujian[0][0] = 0;
			 qujian[0][1]=10;
			 
			 //10~20
			 qujian[1][0]=10;
			 qujian[1][1]=20;
			 
			 //20~50
			 qujian[2][0]=20;
			 qujian[2][1]=50;
			 
			 //50~100
			 qujian[3][0]=50;
			 qujian[3][1]=100;
			 
			 //100~99999999
			 qujian[4][0]=100;
			 qujian[4][1]=999999;
			 
			 
			 for(int i =0 ;i<5;i++) {
			//	int i=0; 
			 	String sql =
			 			"select count(1) from productinfo t where t.salePrice > "+
			 					qujian[i][0]+" and t.salePrice<=  "+qujian[i][1];
				pstmt = connect.prepareStatement(sql);
			//	pstmt.setString(1, queryId);
			
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
				
				count[i]=rs.getInt(1);
				System.out.println("count="+count[i]);
				}
			 }
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return count;
		
	}
}
