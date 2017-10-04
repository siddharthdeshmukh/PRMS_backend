/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.service;

/**
 *
 * @author thushara
 */

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.core.exceptions.OverLapException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleProgramDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.WeeklyScheduleDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.WeeklySchedule;
public class ScheduleService {
    DAOFactoryImpl factory;
	ScheduleProgramDAO spdao;
        WeeklyScheduleDAO weeklyScheduleDAO;
        public ScheduleService() {
		super();
		// Sorry. This implementation is wrong. To be fixed.
		factory = new DAOFactoryImpl();
		spdao = factory.getSpdao();
                weeklyScheduleDAO=factory.getWeeklyScheduleDAO();
	}
        
        public boolean processCreate(ProgramSlot ps) {
            boolean created = true;
		try {
                    WeeklySchedule weeklySch= weeklyScheduleDAO.createValueObject();
                    weeklySch.setWeekNo(getWeekNumber(ps));
                    weeklySch.setStartDate(ps.getDateOfProgram()); // setting Date same as Program Start Date, it will be updated in WeeklyScheduleDAO
		if(!checkProgramSlotOverlap(ps, weeklySch)){
                    spdao.create(ps);
                }else {
                    created = false;
                }
		} catch (NotFoundException | SQLException e){
                    e.printStackTrace();
                }
                return created;
	}
        
        
        public boolean processModify(ProgramSlot ps) {
		boolean modified = true;
		try {
                    WeeklySchedule weeklySch= weeklyScheduleDAO.createValueObject();
                    weeklySch.setWeekNo(getWeekNumber(ps));
                    weeklySch.setStartDate(ps.getDateOfProgram()); // setting Date same as Program Start Date, it will be updated in WeeklyScheduleDAO
                    if(!checkProgramSlotOverlap(ps, weeklySch)){
                        spdao.save(ps);
                    }else {
                        modified = false;
                    }
		} catch (NotFoundException e){
                    e.printStackTrace();
                }catch (SQLException e){
                    e.printStackTrace();
                }
		return modified;
	}
        
        public ArrayList<ProgramSlot> findAllSP() {
		ArrayList<ProgramSlot> currentList = new ArrayList<ProgramSlot>();
		try {
                    currentList = (ArrayList<ProgramSlot>) spdao.loadAll();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
                    e.printStackTrace();
		}
		return currentList;


        }
        
        protected boolean checkProgramSlotOverlap(ProgramSlot programSlot,WeeklySchedule weeklySch) throws NotFoundException, SQLException{
         weeklySch=  weeklyScheduleDAO.getWeeklySchedule(weeklySch);
         System.out.println("Week start date is" + weeklySch.getStartDate() );
         Date startDate = new Date(weeklySch.getStartDate().getTime());
         List<ProgramSlot> programSlotForWeek = spdao.loadAllProgramSlotForWeek(startDate);
         for(ProgramSlot ps:programSlotForWeek){
             System.out.println("program slot is "+ programSlotForWeek.size()+ " "+ ps.toString());
            System.out.println("comapre result for Date " + convertDate(programSlot.getDateOfProgram())+ " and " + ps.getDateOfProgram()+ " "+  convertDate(programSlot.getDateOfProgram()).compareTo(ps.getDateOfProgram()));
             if(convertDate(programSlot.getDateOfProgram()).compareTo(ps.getDateOfProgram())==0){
                System.out.println("Called for Date "+ ps.getDateOfProgram());
                if(programSlot.getStartTime().compareTo(ps.getStartTime())==0){
                   System.out.println("Date of Program and Start Time already Present for the Week, throw OverlapException");
                return true;
                }
                java.util.Date endTime = getEndTime(ps);
                if(programSlot.getStartTime().after(ps.getStartTime()) && programSlot.getStartTime().before(endTime)){
                    return true;
                }
                
            } 
         }   
         return false;
        }
        
        protected String getWeekNumber(ProgramSlot ps){
            Calendar cal = Calendar.getInstance();
            System.out.println(ps.toString());
        cal.setTime(ps.getDateOfProgram());
        int weekNo = cal.get(Calendar.WEEK_OF_YEAR);
            System.out.println("week no is "+ weekNo);
        return Integer.toString(weekNo);
        }
      protected java.util.Date getEndTime(ProgramSlot ps){
          
          Calendar cal = Calendar.getInstance();
          cal.setTime(ps.getStartTime());
          cal.add(Calendar.MINUTE, ps.getDuration());
          java.util.Date endTime =cal.getTime();
          return endTime;
      } 
      
      
      public void deteleProgramSlot(ProgramSlot programSlot) //throws InvalidScheduleException, NotFoundException, SQLException
        {   int result =0;
            if(programSlot==null){
               // throw new InvalidScheduleException("Input object is null");
            }
            if(programSlot.getStartTime()==null || !checkValidDateAndTime(programSlot.getStartTime())){
               // throw new InvalidScheduleException("Input object start Time is null or incorrect");
            }
            if(programSlot.getDateOfProgram()==null || !checkValidDateAndTime(programSlot.getDateOfProgram())){
               // throw new InvalidScheduleException("Input object data of Program is null or incorrect");
            }
            if(programSlot.getRadioProgram()== null || programSlot.getRadioProgram().getName()== null ||programSlot.getRadioProgram().getName().isEmpty()){
                //throw new InvalidScheduleException("Input program Name is null or empty");
            }
            try {
               spdao.delete(programSlot);
            }catch(NotFoundException nFE){
                
            }catch(SQLException sE){
                
            }
        }
      
      protected boolean checkValidDateAndTime(java.util.Date date){
            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.setTime(date);
            cal.getTime();
            return true;
        }
      protected java.util.Date convertDate(java.util.Date date){
          java.util.Date newDate= null;
          System.out.print(date);
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String dateString = sdf.format(date);
        try {
            newDate =  sdf.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
          return newDate;
      }
       
}

