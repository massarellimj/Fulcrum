/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Date;

import com.unitedgasket.fulcrum.Fulcrum.action.FulcrumInstantiationException;
import com.unitedgasket.fulcrum.Fulcrum.core.FulcrumApplication;
import com.unitedgasket.fulcrum.Fulcrum.core.FulcrumResources;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class Main {

    public static FulcrumApplication application;
    
    private static final String FILE = FulcrumResources.getDataDirPath() + ".lock";
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	if (lockInstance(FILE)) application = FulcrumApplication.getInstance();
    }
    
    private static boolean lockInstance(final String lockFile) {
	    try {
		final File file = new File(lockFile);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(new Date().toString());
		bw.flush();
		bw.close();
	        final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
	        final FileLock fileLock = randomAccessFile.getChannel().tryLock();
	        if (fileLock != null) {
	            Runtime.getRuntime().addShutdownHook(new Thread() {
	                public void run() {
	                    try {
	                        fileLock.release();
	                        randomAccessFile.close();
	                        file.delete();
	                    } catch (Exception e) {
	                        System.err.println("Unable to remove lock file: " + lockFile);
	                        System.exit(1);
	                    }
	                }
	            });
	            return true;
	        }
	    } catch (Exception e) {
		new FulcrumInstantiationException();
		System.err.println("Unable to create and/or lock file: " + lockFile);
	    }
	    return false;
	}
}
