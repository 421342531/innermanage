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

import data.DeleteSQl;
import data.InfoUtil;
import data.InpriceTongji;
import data.OutpriceTongji;

/**
 * Servlet implementation class DeleteSubmitServlet
 */
@WebServlet("/DeleteSubmitServlet")
public class DeleteSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSubmitServlet() {
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
		
		
		String id = request.getParameter("id");
		String inPrice = request.getParameter("inPrice");
		String salePrice = request.getParameter("salePrice");
		String mark = request.getParameter("mark");
		
		System.out.println("确认删除信息："+"id = "+id + 
				" inPrice = "+inPrice+
				" salePrice = "+salePrice+
				" mark = "+mark
	);
		try {
			DeleteSQl.deleteInfoFunc(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("delete success");
		
		
		
		  ServletContext sc = getServletContext();  
			RequestDispatcher rd = null;   
			// 再重新查询一遍
			
			request.setAttribute("inPriceTongji", 
					InpriceTongji.getProductInfo());//进价统计
			request.setAttribute("outPriceTongji", 
					OutpriceTongji.getProductInfo());//售价统计
			
			request.setAttribute("list", InfoUtil.getProductInfo());//获取商品信息
			request.setAttribute("preAction", "1");//0:update 1:delete  2:refersh
			rd = sc.getRequestDispatcher("/main.jsp"); //定向的页面   
			rd.forward(request, response);   
		
	}

}
