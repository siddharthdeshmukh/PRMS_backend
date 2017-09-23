/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl;

/**
 *
 * @author thushara
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleProgramDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

public class ScheduleDAOImpl implements ScheduleProgramDAO{
    
    Connection connection;
    
    @Override
	public ProgramSlot createValueObject() {
		return new ProgramSlot();
	}
        
    @Override
	public ProgramSlot getObject(String name, Date Progdate,Time duration) throws NotFoundException,
			SQLException {

		ProgramSlot valueObject = createValueObject();
		valueObject.setProgamName(name);
                valueObject.setDuration(duration);
                valueObject.setDateOfProgram(Progdate);
		load(valueObject);
		return valueObject;
	}
    
        @Override
	public void load(ProgramSlot valueObject) throws NotFoundException,
			SQLException {

		if (valueObject.getProgamName()== null) {
			// System.out.println("Can not select without Primary-Key!");
			throw new NotFoundException("Can not select without Primary-Key!");
		}

		String sql = "SELECT * FROM phoenix.`program-slot`; WHERE (`program-name` = ? ); ";
		PreparedStatement stmt = null;
		openConnection();
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, valueObject.getProgamName());

			singleQuery(stmt, valueObject);

		} finally {
			if (stmt != null)
				stmt.close();
			closeConnection();
		}
	}
        
        
        @Override
	public List<ProgramSlot> loadAll() throws SQLException {
		openConnection();
		String sql = "SELECT * FROM `program-slot` ORDER BY `program-name` ASC; ";
		List<ProgramSlot> searchResults = listQuery(connection
				.prepareStatement(sql));
		closeConnection();
		System.out.println("record size"+searchResults.size());
		return searchResults;
	}
        
        @Override
	public synchronized void create(ProgramSlot valueObject)
			throws SQLException {

		String sql = "";
		PreparedStatement stmt = null;
		openConnection();
		try {
			sql = "INSERT INTO `program-slot` (`program-name`, `dateOfProgram`, `startTime`,`duration` ) VALUES (?,?,?,?); ";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, valueObject.getProgamName());
			stmt.setDate(2, new java.sql.Date(valueObject.getDateOfProgram().getTime()));
			stmt.setDate(3, new java.sql.Date(valueObject.getStarttime().getTime()));
                        stmt.setTime(4, valueObject.getDuration());
			int rowcount = databaseUpdate(stmt);
			if (rowcount != 1) {
				// System.out.println("PrimaryKey Error when updating DB!");
				throw new SQLException("PrimaryKey Error when updating DB!");
			}

		} finally {
			if (stmt != null)
				stmt.close();
			closeConnection();
		}

	}
    protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

		int result = stmt.executeUpdate();

		return result;
	}
        
        @Override
	public void save(ProgramSlot valueObject) throws NotFoundException,
			SQLException {

		String sql = "UPDATE `program-slot` SET `startTime`=? WHERE (`duration` =? AND `dateOfProgram`=? ); ";
		PreparedStatement stmt = null;
		openConnection();
		try {
			stmt = connection.prepareStatement(sql);
			
			stmt.setDate(1, new java.sql.Date(valueObject.getStarttime().getTime()));
                        stmt.setTime(2, valueObject.getDuration());
                        stmt.setDate(3, new java.sql.Date(valueObject.getDateOfProgram().getTime()));

			int rowcount = databaseUpdate(stmt);
			if (rowcount == 0) {
				// System.out.println("Object could not be saved! (PrimaryKey not found)");
				throw new NotFoundException(
						"Object could not be saved! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
				throw new SQLException(
						"PrimaryKey Error when updating DB! (Many objects were affected!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
			closeConnection();
		}
	}

	        
        protected void singleQuery(PreparedStatement stmt, ProgramSlot valueObject)
			throws NotFoundException, SQLException {

		ResultSet result = null;
		openConnection();
		try {
			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setProgamName(result.getString("program-name"));
				valueObject.setDuration(result.getTime("duration"));
				valueObject.setDateOfProgram(result.getDate("dateOfProgram"));
                              valueObject.setStarttime(result.getTime("startTime"));

			} else {
				// System.out.println("RadioProgram Object Not Found!");
				throw new NotFoundException("ProgramSlot Object Not Found!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
			closeConnection();
		}
	}
        protected List<ProgramSlot> listQuery(PreparedStatement stmt) throws SQLException {

		ArrayList<ProgramSlot> searchResults = new ArrayList<>();
		ResultSet result = null;
		openConnection();
		try {
			result = stmt.executeQuery();

			while (result.next()) {
				ProgramSlot temp = createValueObject();

				temp.setProgamName(result.getString("program-name"));
				temp.setDateOfProgram(result.getDate("dateOfProgram"));
				temp.setStarttime(result.getTime("startTime"));
                                temp.setDuration(result.getTime("duration"));

				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
			closeConnection();
		}

		return (List<ProgramSlot>) searchResults;
	}

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

    @Override
    public void delete(ProgramSlot valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramSlot> searchMatching(ProgramSlot valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
