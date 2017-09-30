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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.scheduleprogram.service.ScheduleService;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.scheduleprogram.restful.ScheduleProgram;

@Path("scheduleprogram")
@RequestScoped

public class ScheduleRESTService {
    
    
    @Context
    private UriInfo context;
    
    private ScheduleService service;
    
      public ScheduleRESTService() {
        service = new ScheduleService();
    }
      
      @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProgramSlot(ProgramSlot ps) {
        service.processCreate(ps);
    }
    
    
    
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProgramSlot(ProgramSlot ps) {
        service.processModify(ps);
    }
    
    
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
}
