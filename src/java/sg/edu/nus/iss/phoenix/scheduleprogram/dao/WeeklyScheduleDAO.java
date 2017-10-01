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
     /**
	 * createValueObject-method. This method is used when the Dao class needs to
	 * create new value object instance. The reason why this method exists is
	 * that sometimes the programmer may want to extend also the valueObject and
	 * then this method can be over-rided to return extended valueObject.
     * @return 
	 */
    public abstract WeeklySchedule createValueObject();
     /**
	 * getWeeklySchedule. This will create and load valueObject contents from
	 * database using given Primary-Key as identifier. This method is just a
	 * convenience method for the real load-method which accepts the valueObject
	 * as a parameter. Returned valueObject will be created using the
	 * createValueObject() method.
     * @param name
     * @return 
     * @throws sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException 
     * @throws java.sql.SQLException 
	 */
    public abstract WeeklySchedule getWeeklySchedule(WeeklySchedule valueObject) throws NotFoundException,SQLException;
    
}
