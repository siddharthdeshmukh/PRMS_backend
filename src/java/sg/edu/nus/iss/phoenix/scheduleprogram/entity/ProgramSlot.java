
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
    
/** 
 * Persistent Instance variables. This data is directly 
 * mapped to the columns of database table.
 */
  private int id;
  private int duration;
  private Date dateOfProgram;
  private Time startTime;
  private RadioProgram radioProgram;
  private String presenter;
  private String producer;
  
   /** 
     * Constructors. 
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes six
     * argument, which is the primary key of the corresponding table.
     */
  
    public ProgramSlot() {        
    }
  
    public ProgramSlot(int duration, Date dateOfProgram, Time startTime, RadioProgram radioProgram, String presenter, String producer) {
        this.duration = duration;
        this.dateOfProgram = dateOfProgram;
        this.startTime = startTime;
        this.radioProgram = radioProgram;
        this.presenter = presenter;
        this.producer = producer;
    }  

    public ProgramSlot(int id, int duration, Date dateOfProgram, Time startTime, RadioProgram radioProgram, String presenter, String producer) {
        this.id = id;
        this.duration = duration;
        this.dateOfProgram = dateOfProgram;
        this.startTime = startTime;
        this.radioProgram = radioProgram;
        this.presenter = presenter;
        this.producer = producer;
    }
    
    
 
    /** 
     * Get- and Set-methods for persistent variables. The default
     * behavior does not make any checks against malformed data,
     * so these might require some manual additions.
     * @return 
     */
 
   public void setAll(int duration, Date dateOfProgram, Time startTime, RadioProgram radioProgram, String presenter, String producer) {
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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in text log.
     */

    @Override
    public String toString() {
        return "ProgramSlot{" + "duration=" + duration + ", dateOfProgram=" + dateOfProgram + ", startTime=" + startTime + ", radioProgram=" + radioProgram + ", presenter=" + presenter + ", producer=" + producer + '}';
    }
  
}
