/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.entity;

import java.io.Serializable;

/**
 *
 * @author Shubhanshu Gautam (e0146956)
 */
public class Presenter implements Cloneable, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    	private String id;
        private String name;
        
        public void setAll(String idIn, String nameIn) {
            this.id = idIn;
            this.name = nameIn;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    	/**
	 * toString will return String object representing the state of this
	 * valueObject. This is useful during application development, and possibly
	 * when application is writing object states in console logs.
	 */
	public String toString() {
		StringBuffer out = new StringBuffer("toString: ");
		out.append("\nclass Presenter, mapping to table user\n");
		out.append("Persistent attributes: \n");
		out.append("id = " + this.id + "\n");
		out.append("name = " + this.name + "\n");
		return out.toString();
	}
        
        /**
	 * Clone will return identical deep copy of this valueObject. Note, that
	 * this method is different than the clone() which is defined in
	 * java.lang.Object. Here, the returned cloned object will also have all its
	 * attributes cloned.
	 */
	public Object clone() {
		Presenter cloned = new Presenter();
		if (this.name != null)
			cloned.setName(new String(this.name));
		if (this.id != null)
			cloned.setId(new String(this.id));
		return cloned;
	}
    
}
