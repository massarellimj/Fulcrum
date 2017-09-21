/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.action.task;

import java.awt.Component;

import javax.swing.JTextField;

import com.unitedgasket.fulcrum.Fulcrum.ui.wizards.Wizard;

/**
 * 
 *
 * @author Michael Massarelli
 */
public final class WizardContentListenTask implements Runnable {
    public static final String TAG = "WindowContentListenTask";
    
    private Component component;
    private Wizard wizard;
    private boolean b, n, f;
    
    public WizardContentListenTask(Component component, Wizard wizard, boolean b, boolean n, boolean f) {
	this.component = component;
	this.wizard = wizard;
	this.b = b;
	this.n = n;
	this.f = f;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
	if (!((JTextField)component).getText().isEmpty()) {
	    wizard.toggleButtons(b, n, f);
	} else {
	    wizard.toggleButtons(false, false, false);
	}
    }
}
