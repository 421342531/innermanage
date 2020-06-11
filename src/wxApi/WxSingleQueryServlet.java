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

import WxData.WxSingleQuery;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class WxSingleQueryServlet
 */
@WebServlet("/WxSingleQueryServlet")
public class WxSingleQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WxSingleQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				response.setContentType("text/html;charset=utf-8");
		        // 设置响应头允许ajax跨域访问
		        response.setHeader("Access-Control-Allow-Origin", "*");
		        // 星号表示所有的异域请求都可以接受
		        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		        String queryid = request.getParameter("queryid");
		        System.out.println("wx post queryid = "+queryid);
		        JSONObject object = new JSONObject();
		        
		        List<Map<String,String>>  list = WxSingleQuery.getProductInfo(queryid);
		       
		        Iterator it = list.iterator();
		        while(it.hasNext()) {
		        	  HashMap<String,String> hashMap = (HashMap<String,String>)it.next();
		        	  String id = hashMap.get("");
		        	  String inPrice = hashMap.get("inPrice");
		        	  String salePrice = hashMap.get("salePrice");
		        	  String mark = hashMap.get("mark");
		        	  object.put("id", id);
		        	  object.put("inPrice", inPrice);
		        	  object.put("salePrice", salePrice);
		        	  object.put("mark", mark);
		        }
		      
		    	Writer out = response.getWriter();
		    	
		    	System.out.println(""+object);
		    	if(list.size()==0) {
		    		 JSONObject errorObject = new JSONObject();
		    		 errorObject.put("noInfoFlag", "true");
		    		 out.write(errorObject.toString());
		    	}else {
		    		out.write(object.toString());
		    	}
		    	
		    	out.close();
		    	System.out.println("微信小程序查询成功！");
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
