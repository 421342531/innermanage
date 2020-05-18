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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		System.out.println("post success");
		String password = request.getParameter("password");
		if(password.equals("")||password==null){
			response.getWriter().append("please input password");
			return ;
		}
		
		if(password.equals("0000")){
			System.out.println("logn in success");
		    ServletContext sc = getServletContext();  
			RequestDispatcher rd = null;   
			
			request.setAttribute("list", InfoUtil.getProductInfo());//获取商品信息
			rd = sc.getRequestDispatcher("/main.jsp"); //定向的页面   
			rd.forward(request, response);   
			return ;
		}else{
			  ServletContext sc = getServletContext();  
				RequestDispatcher rd = null;   
				
			//	request.setAttribute("list", InfoUtil.getProductInfo());//获取商品信息
				request.setAttribute("passwordAlert","true");
				rd = sc.getRequestDispatcher("/index.jsp"); //定向的页面   
				
			
			
				//response.getWriter().append("登陆密码错误");
				rd.forward(request, response); 
			return ;
		}
		
	}

}