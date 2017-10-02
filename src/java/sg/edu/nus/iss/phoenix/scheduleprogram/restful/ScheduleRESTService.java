
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

/**
 *
 * @author thushara
 */

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.scheduleprogram.service.ScheduleService;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

@Path("scheduleprogram")
@RequestScoped

public class ScheduleRESTService {
    
    
    @Context
    private UriInfo context;
    
    private ScheduleService service;
     /**
     * Creates a new instance of ScheduleProgramRESTService
     */
      public ScheduleRESTService() {
        service = new ScheduleService();
    }
      
     /**
     * PUT method for creating an instance of resource
     * @param content representation for the resource
     */
      
      @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProgramSlot(ProgramSlot ps) {
        service.processCreate(ps);
    }
    
     /**
     * POST method for updating or creating an instance of resource
     * @param content representation for the resource
     */
    
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProgramSlot(ProgramSlot ps) {
        service.processModify(ps);
    }
    
    /**
     * GET method for getting all the instances of resource
     * returns all the saved schedule programs
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ScheduleProgram getAllProgramSlot() {
        ArrayList<ProgramSlot> SpList = service.findAllSP();
        ScheduleProgram spList = new ScheduleProgram();
        spList.setSpList(new ArrayList<ProgramSlot>());
        
        for (int i = 0; i < SpList.size(); i++) {
            spList.getSpList().add(
                new ProgramSlot(SpList.get(i).getDuration(),
                        SpList.get(i).getDateOfProgram(),
                        SpList.get(i).getStartTime(),
                        SpList.get(i).getRadioProgram(),
                        SpList.get(i).getPresenter(),
                        SpList.get(i).getProducer()));
        }
        return spList;
    }

    
    @DELETE
    @Path("/delete/{programName}/{dateOfProgram}/{startTime}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteProgramSlot(@PathParam("programName") String name,@PathParam("dateOfProgram") String dateOfProgram,@PathParam("startTime") String startTime) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormatter=new SimpleDateFormat("HH:mm:ss");
        Time covertedStartTime = null;
        Date convertedDateOfProgram = null;
            covertedStartTime = new Time(timeFormatter.parse(startTime).getTime());
            convertedDateOfProgram = formatter.parse(dateOfProgram);
       
        ProgramSlot ps = new ProgramSlot();
        ps.setDateOfProgram(convertedDateOfProgram);
        ps.setStartTime(covertedStartTime);
        RadioProgram radioProgram=new RadioProgram();
        radioProgram.setName(name);
        ps.setRadioProgram(radioProgram);
        service.deteleProgramSlot(ps);
    }
}