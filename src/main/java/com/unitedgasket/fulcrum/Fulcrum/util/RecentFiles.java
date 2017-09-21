/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.unitedgasket.fulcrum.Fulcrum.core.FulcrumResources;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class RecentFiles {
    public static final String TAG = "RecentFiles";

    private static final String RECENTS = FulcrumResources.getDocPath() + "RECENT";

    private static List<String> recentFiles = new ArrayList<String>();

    private static File file;

    public static void readRecents() {
	file = new File(RECENTS);
	if (!file.exists() && !file.isFile()) {
	    createRecents();
	}
	try {
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    while (br.ready()) {
		String line = br.readLine();
		if (line != "" || line != null) recentFiles.add(line);
	    }
	    br.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static void addRecent(String recent) {
	file = new File(RECENTS);
	if (!file.exists() && !file.isFile()) {
	    createRecents();
	}
	if (recentFiles.size() == 10) {
	    recentFiles.remove(9);
	}
	recentFiles.add(0, recent);
	try {
	    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    for (int i = 0; i < 10; i++) {
		bw.write(recentFiles.get(i));
		bw.newLine();
		bw.flush();
	    }
	    bw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
    }

    public static void clearRecents() {
	file = new File(RECENTS);
	recentFiles.clear();
	try {
	    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("");
	    bw.flush();
	    bw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     */
    private static void createRecents() {
	file = new File(RECENTS);
	try {
	    Files.createFile(file.toPath());
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * @return
     */
    public static List<String> getRecentList() {
	List<String> rec = new ArrayList<String>();
	for (String s : recentFiles) {
	    rec.add(s.substring(s.lastIndexOf('/') + 1));
	}
	return rec;
    }
    
    public static String getFilePath(int index) {
	return recentFiles.get(index);
    }
}
