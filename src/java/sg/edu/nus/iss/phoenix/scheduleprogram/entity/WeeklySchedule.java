/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author siddharth
 */
public class WeeklySchedule implements Cloneable,Serializable{

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private static final long serialVersionUID = 1L;
    
    private String weekNo;
    private Date startDate;
    private String assignedBy;
    private List<ProgramSlot> programSlotList;
    
    /** 
     * Constructors. 
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes three
     * argument, which is the primary key of the corresponding table.
     */
    
    public WeeklySchedule() {
    }

    public WeeklySchedule(String weekNo, Date startDate, String assignedBy) {
        this.weekNo = weekNo;
        this.startDate = startDate;
        this.assignedBy = assignedBy;
        this.programSlotList= new ArrayList<>();
    }
    
    /** 
     * Get- and Set-methods for persistent variables. The default
     * behavior does not make any checks against malformed data,
     * so these might require some manual additions.
     * @return 
     */

    public String getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(String weekNo) {
        this.weekNo = weekNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }
    
    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the returned cloned object
     * will also have all its attributes cloned.
     * @return 
     * @throws java.lang.CloneNotSupportedException 
     */

    @Override
    protected Object clone() throws CloneNotSupportedException {
       WeeklySchedule cloned = new WeeklySchedule();

        if (this.weekNo != null)
             cloned.setWeekNo(this.weekNo); 
        if (this.startDate != null)
             cloned.setStartDate(this.startDate); 
        if (this.assignedBy != null)
             cloned.setAssignedBy(this.assignedBy); 
        if (this.programSlotList != null)
             cloned.setProgramSlotList(this.programSlotList);
        return cloned;
    }

    public List<ProgramSlot> getProgramSlotList() {
        return programSlotList;
    }

    public void setProgramSlotList(List<ProgramSlot> programSlotList) {
        this.programSlotList = programSlotList;
    }
    
}
