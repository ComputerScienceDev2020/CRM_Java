package cyber.java.crmApp.dao;
import java.util.ArrayList;
import java.util.List;

import cyber.java.crmApp.model.Project;
public class test {
	public static void main(String[] args) {
		ProjectDao dao = new ProjectDao();
		List<Project> projects =  dao.findAll();
		for(Project p:projects) {
			System.out.println(p);
		}
		
	}
}
