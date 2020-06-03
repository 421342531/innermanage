package server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.InfoUtil;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("this is client doGet ");
	    ServletContext sc = getServletContext();  
		RequestDispatcher rd = null;   
		
		request.setAttribute("list", InfoUtil.getProductInfo());//获取商品信息
		System.out.println(InfoUtil.getProductInfo());
		//rd = sc.getRequestDispatcher("/main.jsp"); //定向的页面   
		//rd.forward(request, response);   
		return ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("this is client doPost ");
	    ServletContext sc = getServletContext();  
		RequestDispatcher rd = null;   
		
		request.setAttribute("list", InfoUtil.getProductInfo());//获取商品信息
		System.out.println(InfoUtil.getProductInfo());
		return ;
	
	}

}
