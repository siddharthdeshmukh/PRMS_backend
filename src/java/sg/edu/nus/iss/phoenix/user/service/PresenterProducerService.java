/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.user.entity.Presenter;
import sg.edu.nus.iss.phoenix.user.entity.Producer;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
/**
 *
 * @author Shubhanshu Gautam (e0146956)
 */
public class PresenterProducerService {

    DAOFactoryImpl factory;
    UserDao userdao;
    
    public PresenterProducerService() {
        super();
        factory = new DAOFactoryImpl();
        userdao = factory.getUserDAO();
    }
    
    public ArrayList<Presenter> getAllPresenters(){
        ArrayList<Presenter> currentList = new ArrayList<Presenter>();
            try {
		currentList = (ArrayList<Presenter>) userdao.loadAllPresenters();
            } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
	return currentList;
    }
    
    public ArrayList<Producer> getAllProducers(){
        ArrayList<Producer> currentList = new ArrayList<Producer>();
            try {
		currentList = (ArrayList<Producer>) userdao.loadAllProducers();
            } catch (SQLException e) {
		// TODO Auto-generated catch block
                e.printStackTrace();
            }
	return currentList;
    }
    
}
