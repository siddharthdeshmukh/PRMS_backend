/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.core.exceptions;

/**
 *
 * @author siddharth
 */
public class OverLapException extends Exception{
    
    private static final long serialVersionUID = 1L;
    
    /**
	 * Constructor for OverLapException. The input message is returned in
	 * toString() message.
	 */
	public OverLapException(String msg) {
		super(msg);
	}
    
}
