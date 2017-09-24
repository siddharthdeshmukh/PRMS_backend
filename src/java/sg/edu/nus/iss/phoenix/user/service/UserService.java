package sg.edu.nus.iss.phoenix.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

public class UserService {
	DAOFactoryImpl factory;
	   UserDao userdao;

	public UserService() {
		super();
		// Sorry. This implementation is wrong. To be fixed.
		factory = new DAOFactoryImpl();
		userdao = factory.getUserDAO();
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

	public User findRP(String username) {
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
