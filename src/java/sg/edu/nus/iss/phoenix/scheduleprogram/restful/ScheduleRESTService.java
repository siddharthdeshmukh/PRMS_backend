
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
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.core.exceptions.OverLapException;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.scheduleprogram.service.ScheduleService;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.scheduleprogram.response.ResponseStatus;


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
     * @return 
     */
      
      @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProgramSlot(ProgramSlot ps)  {
          ResponseStatus response;
          Response.Status  status=null;
            boolean created = service.processCreate(ps);
            if(created){
           response= new ResponseStatus("201", "Program slot created Successfuly");
           status = Response.Status.CREATED;
            }
            else {
                response= new ResponseStatus("500", "Program slot already exists");
              // throw WebApplicationException(new OverLapException("Program Slot already exist"));
              status = Response.Status.CONFLICT;
            }
         // System.out.println(Response.status(status).type(MediaType.APPLICATION_JSON).build());
        return Response.status(status).type(MediaType.APPLICATION_JSON).build();
       //return response;
    }
    
     /**
     * POST method for updating or creating an instance of resource
     * @param ps
     * @param content representation for the resource
     * @return 
     */
    
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProgramSlot(ProgramSlot ps) {
        ResponseStatus response;
        Response.Status  status=null;
        
           boolean modified= service.processModify(ps);
           if(modified) {
           response= new ResponseStatus("201", "Program slot modified Successfuly");
           status = Response.Status.CREATED;
           }
           else {
               response= new ResponseStatus("500", "Program slot already exists");
                status = Response.Status.CONFLICT;
           }
       
        return Response.status(status).type(MediaType.APPLICATION_JSON).build();
    }
    
    /**
     * GET method for getting all the instances of resource
     * returns all the saved schedule programs
     * @return 
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
                new ProgramSlot(SpList.get(i).getId(),
                        SpList.get(i).getDuration(),
                        SpList.get(i).getDateOfProgram(),
                        SpList.get(i).getStartTime(),
                        SpList.get(i).getRadioProgram(),
                        SpList.get(i).getPresenter(),
                        SpList.get(i).getProducer()));
        }
        return spList;
    }
    /*@DELETE method for deleting the program slot
    @PathParam for extracting URI of the resource*/
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
