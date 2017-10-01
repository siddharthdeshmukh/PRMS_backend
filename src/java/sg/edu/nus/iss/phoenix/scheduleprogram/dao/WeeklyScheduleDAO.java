/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.dao;

import java.sql.SQLException;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.WeeklySchedule;

/**
 *
 * @author siddharth
 */
public interface WeeklyScheduleDAO {
    public abstract WeeklySchedule createValueObject();
    public abstract WeeklySchedule getWeeklySchedule(WeeklySchedule valueObject) throws NotFoundException,SQLException;
    public abstract void updateUser(WeeklySchedule valueObject) throws NotFoundException,SQLException;
}
