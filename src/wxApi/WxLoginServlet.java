package wxApi;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WxLoginServlet
 */
@WebServlet("/WxLoginServlet")
public class WxLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WxLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
        // 设置响应头允许ajax跨域访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 星号表示所有的异域请求都可以接受
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String password = request.getParameter("password");

    	Writer out = response.getWriter();
    	out.write("return password :"+password);
    	out.write("登陆成功");
    	out.close();
    	System.out.println("微信小程序登陆成功！");
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
