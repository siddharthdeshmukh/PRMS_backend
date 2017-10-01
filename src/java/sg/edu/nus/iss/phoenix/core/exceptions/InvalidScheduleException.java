/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.core.exceptions;

/**
 *
 * @author Mathura Krishnan
 */
public class InvalidScheduleException extends Exception {
    /**
	 * For eclipse based unique identity
	 */
	private static final long serialVersionUID = -8937329631346507674L;

	/**
	 * Constructor for InvalidScheduletException. The input message is returned in
	 * toString() message.
	 */
	public InvalidScheduleException(String msg) {
		super(msg);
	}
}
