package servlet;

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
 * Servlet implementation class ToUpdateServlet
 */
@WebServlet("/ToUpdateServlet")
public class ToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("请重新登陆！");//.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
		    System.out.println("to update page success");
		    ServletContext sc = getServletContext();  
			RequestDispatcher rd = null;   
			String id = request.getParameter("id");
			String inPrice = request.getParameter("inPrice");
			String salePrice = request.getParameter("salePrice");
			String mark = request.getParameter("mark");
			
			System.out.println(" to update servlet id = "+id + 
								" inPrice = "+inPrice+
								" salePrice = "+salePrice+
								" mark = "+mark
					);
			
			request.setAttribute("id",id );
			request.setAttribute("inPrice",inPrice );
			request.setAttribute("salePrice",salePrice );
			request.setAttribute("mark",mark );
			
			rd = sc.getRequestDispatcher("/update.jsp"); //定向的页面   
			rd.forward(request, response);   
	}

}
