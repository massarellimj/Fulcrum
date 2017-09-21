/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.action;

import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * 
 *
 * @author Michael Massarelli
 */
@SuppressWarnings("serial")
public class FulcrumInstantiationException extends Exception {
    public static final String TAG = "FulcrumInstantiationException";
    
    private Logger log = Logger.getLogger(FulcrumInstantiationException.class.getName());
    
    private static final String MSG = "<html>Fulcrum failed to initiate due to an existing instance of the program already running."
    	+ "<br><br>Please close any running Fulcrum applications/processes and try again.</html>";
    
    public FulcrumInstantiationException() {
	super(MSG);
	log.warning("Fulcrum failed to initiate");
	try {
	    log.info("Setting look and feel to the default system UI...");
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException e) {
	    log.warning(e.getLocalizedMessage());
	} catch (InstantiationException e) {
	    log.warning(e.getLocalizedMessage());
	} catch (IllegalAccessException e) {
	    log.warning(e.getLocalizedMessage());
	} catch (UnsupportedLookAndFeelException e) {
	    log.warning(e.getLocalizedMessage());
	}
	JOptionPane.showMessageDialog(null, MSG, "Fulcrum Error", JOptionPane.OK_OPTION);
	log.info("System is now exiting with error status");
	System.exit(1);
    }
}
