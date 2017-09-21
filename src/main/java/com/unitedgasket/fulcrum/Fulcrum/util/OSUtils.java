/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.util;

import java.io.File;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class OSUtils {
    public static final String TAG = "OSUtils";
    
    public static final String getSysArch() {
	return System.getProperty("os.arch");
    }
    
    public static final String getPath() {
	String path = new File(".").getAbsolutePath();
	return path.substring(0, path.lastIndexOf('.'));
    }
    
    public static final String getWindowsUsername() {
	return System.getProperty("user.name");
    }
    
    public static final String getWindowsDomain() {
	return System.getenv("userdomain");
    }
    
    
    public static void main(String[] args) {
	System.out.println(getWindowsDomain() + "\\" + getWindowsUsername());
    }
}
