/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.tray;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import com.unitedgasket.fulcrum.Fulcrum.ui.FulcrumUI;
import com.unitedgasket.fulcrum.Fulcrum.ui.util.IconUtils;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class FulcrumTray {
    public static final String TAG = "FulcrumTray";
    
    
    
    public static void hideToTray() {
	TrayIcon ti = new TrayIcon(IconUtils.getLogo(),"Fulcrum", new TrayPopup(FulcrumUI.getFulcrumFrame()));
	ti.setImageAutoSize(true);
	
	try {
	    SystemTray.getSystemTray().add(ti);
	} catch (AWTException e) {
	    e.printStackTrace();
	}
	FulcrumUI.getFulcrumFrame().setFulcrumVisible(false);
    }
    
    public static void restoreFromTray() {
	FulcrumUI.getFulcrumFrame().setFulcrumVisible(true);
    }
}
