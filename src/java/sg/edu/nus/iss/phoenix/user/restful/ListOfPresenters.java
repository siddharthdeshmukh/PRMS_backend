/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.restful;

import java.util.List;
import sg.edu.nus.iss.phoenix.user.entity.Presenter;

/**
 *
 * @author Shubhanshu Gautam (e0146956)
 */
public class ListOfPresenters {
    
    private List<Presenter> presenterList ;
    
    public List<Presenter> getPresenterList(){
        return presenterList;
    }
    
    public void setPresenterList(List<Presenter> presenters){
        this.presenterList = presenters;
    }
}
