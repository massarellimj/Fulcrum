/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.unitedgasket.fulcrum.Fulcrum.core.model.Registration;
import com.unitedgasket.fulcrum.Fulcrum.login.RegisterFrame;

/**
 * 
 *
 * @author Michael Massarelli
 */
@SuppressWarnings("serial")
public class RegisterAction extends AbstractAction {
    public static final String TAG = "RegisterAction";
    
    private RegisterFrame registerFrame;
    
    
    public RegisterAction(RegisterFrame registerFrame) {
	super("Register");
	this.registerFrame = registerFrame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @SuppressWarnings("unused")
    public void actionPerformed(ActionEvent e) {
	Registration registration = new Registration(registerFrame.getUsername(), registerFrame.getPassword(), registerFrame.getEmail());
    }
}
