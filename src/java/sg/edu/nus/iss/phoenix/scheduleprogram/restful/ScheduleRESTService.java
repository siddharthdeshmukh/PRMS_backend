
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

/**
 *
 * @author thushara
 */

import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
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
     /**
     * DELETE method for deleting an instance of resource
     * @param name name of the resource
     */
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteProgramSlot(ProgramSlot ps) {
        service.deteleProgramSlot(ps);
    }
}
