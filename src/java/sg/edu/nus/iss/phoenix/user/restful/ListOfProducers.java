/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.restful;

import java.util.List;
import sg.edu.nus.iss.phoenix.user.entity.Producer;
/**
 *
 * @author Shubhanshu Gautam (e0146956)
 */
public class ListOfProducers {
        
    private List<Producer> producerList ;
    
    public List<Producer> getProducerList(){
        return producerList;
    }
    
    public void setProducerList(List<Producer> producers){
        this.producerList = producers;
    }
}
