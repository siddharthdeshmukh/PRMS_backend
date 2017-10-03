/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.WeeklyScheduleDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.WeeklySchedule;

/**
 *
 * @author siddharth
 */

/**
 * WeeklySchedule Data Access Object (DAO). This class contains all database
 * handling that is needed to permanently store and retrieve WeeklySchedule object
 * instances.
 */

public class WeeklyScheduleDAOImpl implements WeeklyScheduleDAO{
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

    /**
     * getWeeklySchedule. This will create and load valueObject contents from
     * database using given Primary-Key as identifier. This method is just a
     * convenience method for the real load-method which accepts the valueObject
     * as a parameter. Returned valueObject will be created using the
     * createValueObject() method.
     * @param valueObject
     * @return
     * @throws NotFoundException
     * @throws SQLException
     */
    @Override
    public WeeklySchedule getWeeklySchedule(WeeklySchedule valueObject) throws NotFoundException,SQLException {
        WeeklySchedule weeklySchedule;
        if (valueObject.getWeekNo()== null) {
		throw new NotFoundException("Can not select without Primary-Key!");
		}
              Calendar cal = Calendar.getInstance();
              cal.setTime(valueObject.getStartDate());
              int year = cal.get(Calendar.YEAR);
		String sql = "SELECT * FROM phoenix.`weekly-schedule` WHERE (`weekNo` = ? and YEAR(startDate)= ? ); ";
		PreparedStatement stmt = null;
		openConnection();
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, valueObject.getWeekNo());
                        stmt.setInt(2, year);
			weeklySchedule=singleQuery(stmt, valueObject);

		} finally {
			if (stmt != null)
				stmt.close();
			closeConnection();
                }
                return weeklySchedule;
    }
    
     /**
	 * databaseQuery-method. This method is a helper method for internal use. It
	 * will execute all database queries that will return only one row. The
	 * result set will be converted to valueObject. If no rows were found,
	 * NotFoundException will be thrown.
	 * 
	 * @param stmt
	 *            This parameter contains the SQL statement to be executed.
	 * @param valueObject
	 *            Class-instance where resulting data will be stored.
         * @throws sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException
         * @throws java.sql.SQLException
    */
    
    protected WeeklySchedule singleQuery(PreparedStatement stmt, WeeklySchedule valueObject)
			throws NotFoundException, SQLException {

		ResultSet result = null;
		openConnection();
		try {
			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setWeekNo(result.getString("weekNo"));
				valueObject.setStartDate(result.getDate("startDate"));
				valueObject.setAssignedBy(result.getString("assignedBy"));
                              

			} else {
				throw new NotFoundException("Weekly Schedule Object Not Found!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
			closeConnection();
		}
                return valueObject;
	}
    
    /* (non-Javadoc)
         * @see sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl.WeeklyScheduleDAO#createValueObject()
    */
    
    @Override
	public WeeklySchedule createValueObject() {
		return new WeeklySchedule();
	}
        
     /* (non-Javadoc)
         * @see sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl.WeeklyScheduleDAO#updateUser(sg.edu.nus.iss.phoenix.scheduleprogram.entity.WeeklySchedule)
    */

    @Override
    public void updateUser(WeeklySchedule valueObject) throws NotFoundException, SQLException {
       String sql = "UPDATE `weekly-schedule` SET `assignedBy`= NULL WHERE (`assignedBy` = ?); ";
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
