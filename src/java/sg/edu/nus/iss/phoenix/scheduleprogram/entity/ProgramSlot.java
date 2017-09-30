/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author thushara
 */
public class ProgramSlot implements Cloneable, Serializable{
    
  private Time duration;
  private Date dateOfProgram;
  private Date startTime;
  private String progamName;
  private String presenter;
  private String producer;

    public ProgramSlot(Time Duration, Date DateOfProgram, Date Starttime, String progamName, String presenter, String producer) {
        this.duration = Duration;
        this.dateOfProgram = DateOfProgram;
        this.startTime = Starttime;
        this.progamName = progamName;
        this.presenter = presenter;
        this.producer = producer;
    }
  



    public ProgramSlot() {
        
    }

 
   public void setAll(Time Duration, Date DateOfProgram, Date Starttime, String progamName, String presenter, String producer) {
          this.progamName = progamName;
          this.startTime = Starttime;
          this.dateOfProgram = DateOfProgram;
          this.duration=Duration;
          this.presenter = presenter;
          this.producer = producer;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time Duration) {
        this.duration = Duration;
    }

    public Date getDateOfProgram() {
        return dateOfProgram;
    }

    public void setDateOfProgram(Date DateOfProgram) {
        this.dateOfProgram = DateOfProgram;
    }

    public Date getStarttime() {
        return startTime;
    }

    public void setStarttime(Date Starttime) {
        this.startTime = Starttime;
    }



    public String getProgamName() {
        return progamName;
    }

    public void setProgamName(String progamName) {
        this.progamName = progamName;
    }
  
    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }
    
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
  
  
}
