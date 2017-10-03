package sg.edu.nus.iss.phoenix.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.AnnualScheduleDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleProgramDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.WeeklyScheduleDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.WeeklySchedule;

public class UserService {
	DAOFactoryImpl factory;
	   UserDao userdao;
        WeeklyScheduleDAO weeklyScheduleDAO;
        AnnualScheduleDAO andao;
        ScheduleProgramDAO spDao; 
	public UserService() {
		super();
		// Sorry. This implementation is wrong. To be fixed.
		factory = new DAOFactoryImpl();
		userdao = factory.getUserDAO();
                weeklyScheduleDAO=factory.getWeeklyScheduleDAO();
                spDao =factory.getSpdao();
                andao =factory.getAnnualScheduleDAO();
	}
	public ArrayList<User> searchUser(User user) {
		ArrayList<User> list = new ArrayList<User>();
		try {
			list = (ArrayList<User>) userdao.searchMatching(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<User> findUserByCriteria(User user) {
		ArrayList<User> currentList = new ArrayList<User>();

		try {
			currentList = (ArrayList<User>) userdao.searchMatching(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currentList;

	}

	public User findUser(String username) {
		User currentUser = new User();
		currentUser.setName(username);
		try {
			currentUser = ((ArrayList<User>) userdao
					.searchMatching(currentUser)).get(0);
			return currentUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentUser;

	}

	public ArrayList<User> findAllUser() {
		ArrayList<User> currentList = new ArrayList<User>();
		try {
			currentList = (ArrayList<User>) userdao.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentList;

	}
        
	public void processCreate(User user) {
		try {
                    userdao.create(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                    e.printStackTrace();
		}
	}

	public void processModify(User user) {
		
			try {
                            userdao.save(user);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
                            e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
                            e.printStackTrace();
			}
		
	}

	public void processDelete(String name) {

            try {
                User user = new User(name);
                AnnualSchedule anSchedule = new AnnualSchedule();
                anSchedule.setAssignedBy(name);
                WeeklySchedule wkSchedule = new WeeklySchedule();
                wkSchedule.setAssignedBy(name);
                ProgramSlot ps = new ProgramSlot();
                ps.setPresenter(name);
                ps.setProducer(name);
                andao.updateUser(anSchedule);
                weeklyScheduleDAO.updateUser(wkSchedule);
                spDao.updatePresenterProducer(ps);
                userdao.delete(user);
            } catch (NotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	}

}
