/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.dao;

/**
 *
 * @author thushara
 */


import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
public interface ScheduleProgramDAO {
    
    public abstract ProgramSlot createValueObject();
    public abstract ProgramSlot getObject(String name, Date Progdate,Time duration)
			throws NotFoundException, SQLException;
    public abstract void load(ProgramSlot valueObject)
			throws NotFoundException, SQLException;
    public abstract List<ProgramSlot> loadAll() throws SQLException;
    public abstract void create(ProgramSlot valueObject) throws SQLException;
    public abstract void save(ProgramSlot valueObject)
			throws NotFoundException, SQLException;
    public abstract int delete(ProgramSlot valueObject)
			throws NotFoundException, SQLException;
    public abstract void deleteAll(Connection conn) throws SQLException;
    public abstract List<ProgramSlot> searchMatching(ProgramSlot valueObject)
			throws SQLException;
    public abstract List<ProgramSlot> loadAllProgramSlotForWeek(Date weekStartDate) throws SQLException;
    
}

