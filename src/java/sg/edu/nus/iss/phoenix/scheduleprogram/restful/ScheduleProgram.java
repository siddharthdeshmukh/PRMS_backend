/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

/**
 *
 * @author thushara
 */
import java.util.List;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

public class ScheduleProgram {
     private List <ProgramSlot> spList;

    public List<ProgramSlot> getSpList() {
        return spList;
    }

    public void setSpList(List<ProgramSlot> spList) {
        this.spList = spList;
    }

    

    
}
