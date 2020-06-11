package wxApi;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WxData.WxSingleInsert;
import WxData.WxSingleQuery;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class WxSingleQueryServlet
 */
@WebServlet("/WxINsertServlet")
public class WxINsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WxINsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				request.setCharacterEncoding("GB2312");
		        // 设置响应头允许ajax跨域访问
		        response.setHeader("Access-Control-Allow-Origin", "*");
		        // 星号表示所有的异域请求都可以接受
		        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		        String id = request.getParameter("id");
		        String  test =request.getParameter("inPrice");
		        String  test2 =request.getParameter("salePrice");
		        String  test3 =new String(request.getParameter("mark").getBytes("iso-8859-1"),"utf-8");
		        		

		        System.out.println("-----wx post insertid = "+id);
		        System.out.println("-----wx post insertinprice = "+test);
		        System.out.println("-----wx post insertsaleprice = "+test2);
		        System.out.println("-----wx post insertmark ----------"+test3);
		        
		       // WxSingleInsert.insertProductInfo(id, test, test2, test3);
		        
		        
		    	Writer out = response.getWriter();
		    	//out.write(errorObject.toString());
		    	String result = WxSingleInsert.insertProductInfo(id, test, test2, test3);
		    	out.write(result);
		    	out.close();
		    	System.out.println("微信小程序插入成功！"+result);
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
	//	WxSingleQuery.getProductInfo("2000");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
