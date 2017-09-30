/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author thushara
 */
public class ProgramSlot implements Cloneable, Serializable{
    
  private Time duration;
  private Date dateOfProgram;
  private Date startTime;
  private RadioProgram radioProgram;
  private String presenter;
  private String producer;

    public ProgramSlot(Time duration, Date dateOfProgram, Date startTime, RadioProgram radioProgram, String presenter, String producer) {
        this.duration = duration;
        this.dateOfProgram = dateOfProgram;
        this.startTime = startTime;
        this.radioProgram = radioProgram;
        this.presenter = presenter;
        this.producer = producer;
    }
  



    public ProgramSlot() {
        
    }

 
   public void setAll(Time duration, Date dateOfProgram, Date startTime, RadioProgram radioProgram, String presenter, String producer) {
          this.radioProgram = radioProgram;
          this.startTime = startTime;
          this.dateOfProgram = dateOfProgram;
          this.duration=duration;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public RadioProgram getRadioProgram() {
        return radioProgram;
    }

    public void setRadioProgram(RadioProgram radioProgram) {
        this.radioProgram = radioProgram;
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
