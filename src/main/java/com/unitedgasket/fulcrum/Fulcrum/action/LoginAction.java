/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.unitedgasket.fulcrum.Fulcrum.login.LoginFrame;
import com.unitedgasket.fulcrum.Fulcrum.login.verify.LoginVerification;

/**
 * 
 *
 * @author Michael Massarelli
 */
@SuppressWarnings("serial")
public class LoginAction extends AbstractAction {
    public static final String TAG = "LoginAction";
    
    LoginFrame frame;
    
    public LoginAction(LoginFrame frame) {
	super("Login");
	this.frame = frame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
	LoginVerification.validate(frame.getUser(), frame.getPassword());
    }

}
