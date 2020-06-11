package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.InfoUtil;
import data.InpriceTongji;
import data.OutpriceTongji;
import data.UpdateSql;

/**
 * Servlet implementation class UpdateSubmitServlet
 */
@WebServlet("/UpdateSubmitServlet")
public class UpdateSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = getServletContext();  
		RequestDispatcher rd = null;   
		
		rd = sc.getRequestDispatcher("/index.jsp"); //定向的页面   
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("GB2312");
		String id = request.getParameter("id");
		String inPrice = request.getParameter("inPrice");
		String salePrice = request.getParameter("salePrice");
		String mark = request.getParameter("mark");		
		
		System.out.println("mark:"+mark);
		
		try {
			//更新商品信息
			UpdateSql.updateAllFunc(id, inPrice, salePrice, mark);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//updateSqlFunc
		
		System.out.println("确认更新信息："+"id = "+id + 
				" inPrice = "+inPrice+
				" salePrice = "+salePrice+
				" mark = "+mark);
		System.out.println("update  success");
	    ServletContext sc = getServletContext();  
		RequestDispatcher rd = null;   
	
		request.setAttribute("inPriceTongji", 
				InpriceTongji.getProductInfo());//进价统计
		request.setAttribute("outPriceTongji", 
				OutpriceTongji.getProductInfo());//售价统计
		
		request.setAttribute("preAction", "0");//0:update 1:delete 
		request.setAttribute("list", InfoUtil.getProductInfo());//获取商品信息
		rd = sc.getRequestDispatcher("/main.jsp"); //定向的页面   
		rd.forward(request, response);   
		return ;
		
	
	}

}
