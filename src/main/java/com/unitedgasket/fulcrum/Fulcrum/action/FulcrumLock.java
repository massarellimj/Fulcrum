/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.action;

import javax.swing.JLayeredPane;

import com.unitedgasket.fulcrum.Fulcrum.tray.FulcrumTray;
import com.unitedgasket.fulcrum.Fulcrum.ui.FulcrumUI;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class FulcrumLock {
    public static final String TAG = "FulcrumLock";
    
    static boolean locked;
    static JLayeredPane layerPane;
    
    public static void lockFulcrum() {
	locked = true;
	FulcrumTray.hideToTray();
	FulcrumUI.refresh();
	// minimize to tray
	// require password to unlock
    }
    
    public static void unlockFulcrum() {
	locked = false;
    }
    
    
    public static boolean isFulcrumLocked() {
	return locked;
    }
    
}
