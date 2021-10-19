package cyber.java.crmApp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyber.java.crmApp.util.JspConst;
import cyber.java.crmApp.util.ServletConst;
import cyber.java.crmApp.util.UrlConst;

//@WebServlet(name="homeservlet", urlPatterns = {"/home", "/home/level2"})
@WebServlet(name= ServletConst.HOME, urlPatterns = {
		UrlConst.HOME
})

public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("abc");
//		req.getRequestDispatcher("/WEB-INF/views/home/homepage.jsp").forward(req, resp);
		req.getRequestDispatcher(JspConst.HOME).forward(req, resp);

	}
}
