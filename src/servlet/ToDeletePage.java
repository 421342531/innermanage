package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToDeletePage
 */
@WebServlet("/ToDeletePage")
public class ToDeletePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDeletePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" start to delete");
		  ServletContext sc = getServletContext();  
			RequestDispatcher rd = null;   
			String id = request.getParameter("id");
			String inPrice = request.getParameter("inPrice");
			String salePrice = request.getParameter("salePrice");
			String mark = request.getParameter("mark");
			
			System.out.println("id = "+id + 
								" inPrice = "+inPrice+
								" salePrice = "+salePrice+
								" mark = "+mark
					);
			
			request.setAttribute("id",id );
			request.setAttribute("inPrice",inPrice );
			request.setAttribute("salePrice",salePrice );
			request.setAttribute("mark",mark );
			
			rd = sc.getRequestDispatcher("/delete.jsp"); //定向的页面   
			rd.forward(request, response);  
		
		
		
		
		
		
		
		//doGet(request, response);
	}

}
