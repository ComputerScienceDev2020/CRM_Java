package cyber.java.crmApp.service;

import java.sql.SQLException;
import java.util.List;


import cyber.java.crmApp.dao.StatusDao;
import cyber.java.crmApp.dto.RoleDto;
import cyber.java.crmApp.dto.StatusDto;
import cyber.java.crmApp.model.Role;
import cyber.java.crmApp.model.Status;

public class StatusService {
	private StatusDao statusDao;
	
	public StatusService(){
		statusDao = new StatusDao();
	}
		public List<Status> findAll(){
			List<Status> statuss = null;
			try {
				statuss = statusDao.findAll();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return statuss;
		}
		

		public Status findById(int id) {
			 Status status  = new  Status();
			
			try {
				status = statusDao.findById(id);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return status ;
		}
		

		public void deleteById(int id) {
		try {
			statusDao.deleteById(id);
			} catch (SQLException e) {
			e.printStackTrace();
			}
			
		}
		public void add(StatusDto statusdto) {

			
			try {
				statusDao.add(statusdto);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void update(StatusDto statusdto) {

			try {
				statusDao.update(statusdto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		
}
