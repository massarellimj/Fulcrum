/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.account;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.unitedgasket.fulcrum.Fulcrum.core.FulcrumResources;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class FulcrumAccountFile {
    public static final String TAG = "FulcrumAccountFile";
    
    public static void createAccountFile() {
	File file = new File(FulcrumResources.getBasePath() + "fulcrum.account");
	if (!file.exists())
	    try {
		Files.createFile(file.toPath());
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	System.out.println(file.getAbsolutePath());
    }
    
    public static void readAccountFile() {
	
    }
    
    public static void saveAccountFile() {
	
    }
}
