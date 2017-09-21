/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.util;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import com.unitedgasket.fulcrum.Fulcrum.ui.FulcrumUI;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class ScreenUtils {
    public static final String TAG = "ScreenUtils";
    
    static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    
    public static Dimension getDefaultScreenDimension() {
	DisplayMode dm = ge.getDefaultScreenDevice().getDisplayMode();
	return new Dimension(dm.getWidth(), dm.getHeight());
    }
    
    public static String getDefaultScreen() {
	return ge.getDefaultScreenDevice().getIDstring();
    }
    
    public static GraphicsDevice getScreenDevice(int num) {
	GraphicsDevice[] devices = ge.getScreenDevices();
	for (GraphicsDevice dev : devices) {
	    if (dev.getIDstring().contains("Display")) {
		if (dev.getIDstring().endsWith(String.valueOf(num))) {
		    return dev;
		}
	    }
	}
	return ge.getDefaultScreenDevice();
    }
    
    public static GraphicsDevice getScreenDevice(String deviceID) {
	for (char c : deviceID.toCharArray()) {
	    if (Character.isDigit(c)) {
		return getScreenDevice(Integer.parseInt(c + ""));
	    }
	}
	return null;
    }
    
    public static int getDefaultXPos() {
	int width = ge.getDefaultScreenDevice().getDisplayMode().getWidth();
	return width / 4;
    }
    
    public static int getDefaultYPos() {
	int height = ge.getDefaultScreenDevice().getDisplayMode().getHeight();
	return height / 4;
    }
    
    public static int getDefaultWidth() {
	return ge.getDefaultScreenDevice().getDisplayMode().getWidth() / 2;
    }
    
    public static int getDefaultHeight() {
	return ge.getDefaultScreenDevice().getDisplayMode().getHeight() / 2;
    }
    
    public static int getCurrentWidth() {
	return FulcrumUI.getFulcrumFrame().getWidth();
    }
    
    public static int getCurrentHeight() {
	return FulcrumUI.getFulcrumFrame().getHeight();
    }
    
    public static int getCurrentX() {
	return FulcrumUI.getFulcrumFrame().getX();
    }
    
    public static int getCurrentY() {
	return FulcrumUI.getFulcrumFrame().getY();
    }
    
    public static String getCurrentScreen() {
	return FulcrumUI.getFulcrumFrame().getGraphicsConfiguration().getDevice().getIDstring();
    }
    
    public static int getCurrentState() {
	return FulcrumUI.getFulcrumFrame().getExtendedState();
    }
    
    public static void main(String[] args) {
	System.out.println(getDefaultScreen());
    }
    
}
