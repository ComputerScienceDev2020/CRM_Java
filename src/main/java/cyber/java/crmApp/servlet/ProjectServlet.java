package cyber.java.crmApp.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyber.java.crmApp.util.UrlConst;
import cyber.java.crmApp.dto.ProjectDto;
import cyber.java.crmApp.dto.RoleDto;
import cyber.java.crmApp.model.Project;
import cyber.java.crmApp.model.User;
import cyber.java.crmApp.service.ProjectService;
import cyber.java.crmApp.service.RoleService;
import cyber.java.crmApp.service.UserService;
import cyber.java.crmApp.util.JspConst;


@WebServlet(name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT_DASHBOARD,
		UrlConst.PROJECT_MANAGE,
		UrlConst.PROJECT_ADD,
		UrlConst.PROJECT_UPDATE,
		UrlConst.PROJECT_DELETE,
		UrlConst.PROJECT_STAFF,
		UrlConst.PROJECT_STAFF_ADD,
		UrlConst.PROJECT_STAFF_REMOVE
})
public class ProjectServlet extends HttpServlet{
private ProjectService service;
private UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProjectService();
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.PROJECT_DASHBOARD:
			getDashboard(req,resp);
			break;
		case UrlConst.PROJECT_MANAGE:
			
			break;
		case UrlConst.PROJECT_ADD:
			getProjectAdd(req,resp);
			break;
		case UrlConst.PROJECT_UPDATE:
			getProjectUpdate(req,resp);
			break;
		case UrlConst.PROJECT_DELETE:
			getProjectDelete(req,resp);
			break;
		case UrlConst.PROJECT_STAFF:
			getProject_Staff(req,resp);
			break;
		case UrlConst.PROJECT_STAFF_ADD:
			getProject_Staff_Add(req,resp);
			break;
		case UrlConst.PROJECT_STAFF_REMOVE:
			getProject_Staff_Remove(req,resp);
			break;
		default:
			
			break;
		}
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.PROJECT_DASHBOARD:
		//	getDashboard(req,resp);
			break;
		case UrlConst.PROJECT_MANAGE:
			postProject_Manage(req,resp);
			break;
		case UrlConst.PROJECT_ADD:
			try {
				postProjectAdd(req,resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case UrlConst.PROJECT_UPDATE:
			try {
				postProject_Update(req,resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case UrlConst.PROJECT_DELETE:
			postProject_Delete(req,resp);
			break;
		case UrlConst.PROJECT_STAFF:
			
			break;
		case UrlConst.PROJECT_STAFF_ADD:
			
			break;
		case UrlConst.PROJECT_STAFF_REMOVE:
			
			break;
		default:
			
			break;
		}
	}




	private void getDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Project> projects = service.findAll();
		
		if(projects != null && !projects.isEmpty())
			req.setAttribute("projects", projects);
		
		
		req.getRequestDispatcher(JspConst.PROJECT_DASHBOARD)
			.forward(req, resp);
	}
	

	

	private void getProject_Staff_Remove(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void getProject_Staff_Add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void getProject_Staff(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void getProjectDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		service.deleteById(id);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_DASHBOARD);
		
	}
	private void getProjectAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // infor from owner user load to UI
		 List<User> users = userService.findAll();
			
			if(users != null && !users.isEmpty())
				req.setAttribute("users", users);
		
		req.getRequestDispatcher(JspConst.PROJECT_ADD)
		.forward(req, resp);
	}

	private void getProjectUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		 Project project =new  Project();
		 project = service.findById(id);
		 
		 req.setAttribute("project", project );
		 
		 // infor from owner user load to UI
		 List<User> users = userService.findAll();
			
			if(users != null && !users.isEmpty())
				req.setAttribute("users", users);
		req.getRequestDispatcher(JspConst.PROJECT_UPDATE)
		.forward(req, resp);
		
	}

	

	private void postProject_Delete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}



	private void postProject_Manage(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void postProjectAdd(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
		ProjectDto projectdto = extractAddDtoFromReq(req);
		service.add(projectdto);
		resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_DASHBOARD);
	}
	
	private void postProject_Update(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
		ProjectDto projectdto = extractUpdateDtoFromReq(req);
		service.update(projectdto);
		resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_DASHBOARD);
	}


	// Post Add Extract
	private ProjectDto extractAddDtoFromReq(HttpServletRequest req) throws ParseException  {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String start_date =req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		int owner = Integer.parseInt(req.getParameter("owner"));
		
		return new ProjectDto(0, name, description, start_date, end_date, owner);
		


}
	private ProjectDto extractDtoFromReq(HttpServletRequest req) throws ParseException  {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String start_date =req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		int owner = Integer.parseInt(req.getParameter("owner"));
	    int id = Integer.parseInt(req.getParameter("id"));
		return new ProjectDto(id,name, description, start_date, end_date, owner);

}
	private ProjectDto extractUpdateDtoFromReq(HttpServletRequest req) throws ParseException  {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String start_date =req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		int owner = Integer.parseInt(req.getParameter("owner1"));
	    int id = Integer.parseInt(req.getParameter("id"));
	    Project project =new  Project();
	    project.setId(id);
	    project.setName(name);
	    project.setDescription(description);
	    project.setStart_date(start_date);
	    project.setEnd_date(end_date);
	    project.setOwner(owner);
	   
		return new ProjectDto(project);

}
}
