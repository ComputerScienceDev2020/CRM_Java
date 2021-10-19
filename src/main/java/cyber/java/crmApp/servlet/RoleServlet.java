package cyber.java.crmApp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyber.java.crmApp.dto.RoleDto;
import cyber.java.crmApp.model.Role;
import cyber.java.crmApp.util.JspConst;
import cyber.java.crmApp.service.RoleService;
import cyber.java.crmApp.util.UrlConst;

@WebServlet(name="roleServlet", urlPatterns = {
	UrlConst.ROLE_DASHBOARD	,
	UrlConst.ROLE_ADD,
	UrlConst.ROLE_UPDATE,
	UrlConst.ROLE_DELETE	
})
public class RoleServlet extends HttpServlet{
	private RoleService service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new RoleService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getServletPath()) {	
				
		case UrlConst.ROLE_DASHBOARD: 
			getRoleDashboard(req,resp);
			break;
		case UrlConst.ROLE_ADD:
			getRoleAdd(req,resp);
			break;
		case UrlConst.ROLE_UPDATE:
			getRoleUpdate(req,resp);
			break;
		case UrlConst.ROLE_DELETE:
			getRoleDelete(req,resp);
			break;
			
		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(req.getServletPath()) {
		case UrlConst.ROLE_DASHBOARD:
			
			break;
		
		case UrlConst.ROLE_ADD:
			postRoleAdd(req,resp);
			break;
		case UrlConst.ROLE_UPDATE:
			postRoleUpdate(req,resp);
			break;
		case UrlConst.ROLE_DELETE:
			
			break;
		}	
		
	}
	

	private void getRoleDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Role> roles = service.findAll();
		
		if(roles != null && !roles.isEmpty())
			req.setAttribute("roles", roles);
		
		req.getRequestDispatcher(JspConst.ROLE_DASHBOARD)
		.forward(req, resp);
		
	}
	// get Delete
	private void getRoleDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		service.deleteById(id);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
		
	}
	// get Update
	private void getRoleUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
//		RoleDto roleDto = new RoleDto();
//		roleDto.setId(id);
		Role role = new Role();
		role = service.findById(id);
		
		req.setAttribute("role", role );
		req.getRequestDispatcher(JspConst.ROLE_UPDATE)
		.forward(req, resp);
		
	}
	// get Add
	private void getRoleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.ROLE_ADD)
		.forward(req, resp);
		
	}
	// Post Update
	private void postRoleUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		RoleDto rodto = extractDtoFromReq(req);
		service.update(rodto);
		resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
	}
	// Post Add
	private void postRoleAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		RoleDto rodto = extractAddDtoFromReq(req);
		service.add(rodto);
		resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_DASHBOARD);
	}

	// Post Add Extract
	private RoleDto extractAddDtoFromReq(HttpServletRequest req) {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		return new RoleDto(name,description, 0);

}
	private RoleDto extractDtoFromReq(HttpServletRequest req) {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		 int id = Integer.parseInt(req.getParameter("id"));
		return new RoleDto(name,description, id);
}
}
