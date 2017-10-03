/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.AnnualScheduleDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.AnnualSchedule;

/**
 *
 * @author siddharth
 */

/**
 * AnnualSchedule Data Access Object (DAO). This class contains all database
 * handling that is needed to permanently store and retrieve WeeklySchedule object
 * instances.
 */

public class AnnualScheduleDAOImpl implements AnnualScheduleDAO {
Connection connection;
   
    private void openConnection() {
		try {
			Class.forName(DBConstants.COM_MYSQL_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.connection = DriverManager.getConnection(DBConstants.dbUrl,
					DBConstants.dbUserName, DBConstants.dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
        private void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
     /* (non-Javadoc)
         * @see sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl.AnnualScheduleDAO#updateUser(sg.edu.nus.iss.phoenix.scheduleprogram.entity.AnnualSchedule)
     */
        
    @Override
    public void updateUser(AnnualSchedule valueObject) throws NotFoundException, SQLException {
       String sql = "UPDATE `annual-schedule` SET `assingedBy`= NULL WHERE (`assingedBy` = ?); ";
		PreparedStatement stmt = null;
		openConnection();
		try {
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, valueObject.getAssignedBy());

			int rowcount = databaseUpdate(stmt);
			
		} finally {
			if (stmt != null)
				stmt.close();
			closeConnection();
		}
    }
    
     /**
	 * databaseUpdate-method. This method is a helper method for internal use.
	 * It will execute all database handling that will change the information in
	 * tables. SELECT queries will not be executed here however. The return
	 * value indicates how many rows were affected. This method will also make
	 * sure that if cache is used, it will reset when data changes.
	 * 
	 * @param stmt
	 *            This parameter contains the SQL statement to be executed.
         * @return 
         * @throws java.sql.SQLException
    */
    
    protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

		int result = stmt.executeUpdate();

		return result;
	}
    
}
