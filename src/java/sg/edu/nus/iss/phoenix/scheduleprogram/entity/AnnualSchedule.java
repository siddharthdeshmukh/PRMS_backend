/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.io.Serializable;

/**
 *
 * @author siddharth
 */
public class AnnualSchedule implements Cloneable,Serializable {
    
    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    
    private static final long serialVersionUID = 1L;
    
    private int year;
    private String assignedBy;
    
    /** 
     * Constructors. 
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes two
     * argument, which is the primary key of the corresponding table.
     */
    
    public AnnualSchedule() {
    }

    public AnnualSchedule(int year, String assignedBy) {
        this.year = year;
        this.assignedBy = assignedBy;
    }
    
    /** 
     * Get- and Set-methods for persistent variables. The default
     * behavior does not make any checks against malformed data,
     * so these might require some manual additions.
     * @return 
     */
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }   
}
