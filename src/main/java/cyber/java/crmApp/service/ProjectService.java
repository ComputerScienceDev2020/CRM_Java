package cyber.java.crmApp.service;

import java.sql.SQLException;
import java.util.List;

import cyber.java.crmApp.dao.ProjectDao;
import cyber.java.crmApp.dto.ProjectDto;

import cyber.java.crmApp.model.Project;



public class ProjectService {
	private ProjectDao projectDao;
	
	public ProjectService() {
		projectDao = new ProjectDao();
	}
	public List<Project> findAll(){
		List<Project> projects = null;
		try {
			projects = projectDao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return projects;
	}
	public Project findById(int id) {
		Project project = new Project();
		
		try {
			project = projectDao.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return project;
	}
	
	
	
	 public void deleteById(int id) {
			try {
				projectDao.deleteById(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 public void add(ProjectDto projectdto) {
			
			try {
				projectDao.add(projectdto);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 public void update(ProjectDto projectdto) {

			try {
				projectDao.update(projectdto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	

}
