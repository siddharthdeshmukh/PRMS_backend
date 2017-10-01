
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
    
  private int duration;
  private Date dateOfProgram;
  private Date startTime;
  private RadioProgram radioProgram;
  private String presenter;
  private String producer;

    public ProgramSlot(int duration, Date dateOfProgram, Date startTime, RadioProgram radioProgram, String presenter, String producer) {
        this.duration = duration;
        this.dateOfProgram = dateOfProgram;
        this.startTime = startTime;
        this.radioProgram = radioProgram;
        this.presenter = presenter;
        this.producer = producer;
    }
  
  /** 
     * Constructors. 
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */


    public ProgramSlot() {
        
    }
/** 
     * Get- and Set-methods for persistent variables. The default
     * behavior does not make any checks against malformed data,
     * so these might require some manual additions.
     * @return 
     */
 
   public void setAll(int duration, Date dateOfProgram, Date startTime, RadioProgram radioProgram, String presenter, String producer) {
          this.radioProgram = radioProgram;
          this.startTime = startTime;
          this.dateOfProgram = dateOfProgram;
          this.duration=duration;
          this.presenter = presenter;
          this.producer = producer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int Duration) {
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
