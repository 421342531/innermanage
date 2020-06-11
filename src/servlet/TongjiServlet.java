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
@WebServlet("/TongjiServlet")
public class TongjiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TongjiServlet() {
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
	
		
		System.out.println("enter in tongji ");
		request.setCharacterEncoding("UTF-8");
		 ServletContext sc = getServletContext();  
			RequestDispatcher rd = null;   
			
			
			request.setAttribute("inPriceTongji", 
					InpriceTongji.getProductInfo());//进价统计
			request.setAttribute("outPriceTongji", 
					OutpriceTongji.getProductInfo());//售价统计
			
		rd = sc.getRequestDispatcher("/tongji.jsp"); //定向的页面   
		rd.forward(request, response);   
		return ;
		
	
	}

}
