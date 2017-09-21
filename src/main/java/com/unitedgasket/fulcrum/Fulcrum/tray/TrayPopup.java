/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.tray;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.unitedgasket.fulcrum.Fulcrum.ui.FulcrumFrame;

/**
 * 
 *
 * @author Michael Massarelli
 */
@SuppressWarnings("serial")
public class TrayPopup extends PopupMenu {
    public static final String TAG = "TrayPopup";
    
    MenuItem toggle, restore, exit;
    
    public TrayPopup(final FulcrumFrame fulcrumFrame) {
	super("Fulcrum");
	
	toggle = new MenuItem("Show/Hide Fulcrum");
	toggle.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (fulcrumFrame.isVisible()) {
		    FulcrumTray.hideToTray();
		    restore.setEnabled(true);
		} else {
		    FulcrumTray.restoreFromTray();
		    restore.setEnabled(false);
		}
	    }
	});
	
	restore = new MenuItem("Restore");
	restore.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		fulcrumFrame.restore();
		restore.setEnabled(false);
	    }
	});
	
	exit = new MenuItem("Exit");
	exit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		fulcrumFrame.popupExit();
	    }
	});
	
	add(toggle);
	addSeparator();
	add(restore);
	add(exit);
    }
}
