/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.restful;

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
import sg.edu.nus.iss.phoenix.user.entity.Presenter;
import sg.edu.nus.iss.phoenix.user.entity.Producer;
import sg.edu.nus.iss.phoenix.user.service.PresenterProducerService;


/**
 *
 * @author Shubhanshu Gautam (e0146956)
 */
@Path("role")
@RequestScoped
public class PresenterProducerRESTService {

    @Context
    private UriInfo context;
    
    private PresenterProducerService service;
       
    public PresenterProducerRESTService() {
        service = new PresenterProducerService();
    }
    
    @GET
    @Path("/presenter/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ListOfPresenters getListOfPresenters() {
        ArrayList<Presenter> presenterListFromService = service.getAllPresenters();
        ListOfPresenters presenterList = new ListOfPresenters();
        presenterList.setPresenterList(presenterListFromService);
        return presenterList;
    }
    
    @GET
    @Path("/producer/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ListOfProducers getListOfProducers() {
        ArrayList<Producer> producerListFromService = service.getAllProducers();
        ListOfProducers producerList = new ListOfProducers();
        producerList.setProducerList(producerListFromService);
        return producerList;
    }
    
    
}
