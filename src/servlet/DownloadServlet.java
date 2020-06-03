package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import data.ExcelUtil;
import data.InfoUtil;

/**
 * Servlet implementation class DeleteSubmitServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("请重新登陆！");//.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ExcelUtil.setResponseHeader(response, "ppp.xsl");
			export(request,response);
	}
	
	public void export(HttpServletRequest request,HttpServletResponse response) {
        
        //excel标题
        String[] title = {"序号","二维码号","进价(元)","售价(元)","备注"};
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        //excel文件名
        String fileName = "统计表-"+df.format(new Date())+".xls";

        //sheet名
        String sheetName = "统计表";
        
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        list = InfoUtil.getProductInfo();
        String[][] content=new String[list.size()][title.length];
        int index = 0;
        for(Map map:list) {
        	 content[index][0] = (index+1)+"";
        	 content[index][1] = (String) map.get("id");
        	 content[index][2] = (String) map.get("inPrice");
        	 content[index][3] = (String) map.get("salePrice");
        	 content[index][4] = (String) map.get("mark");
        	index++;
        }
        //创建HSSFWorkbook 
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        
        //响应到客户端
        try {
            ExcelUtil.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();    
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
