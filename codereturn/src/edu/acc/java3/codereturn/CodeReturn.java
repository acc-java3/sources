package edu.acc.java3.codereturn;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CodeReturn extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		response.setContentType("application/jar");
		
		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream("/codereturn.war");
		
		int red = 0;
		byte[] buffer = new byte[1024];
		OutputStream os = response.getOutputStream();
		while ((red = is.read(buffer)) != -1) {
			os.write(buffer, 0, red);
		}
		is.close();
		os.flush();
		os.close();		
	}

}