/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.action.task;

/**
 * 
 *
 * @author Michael Massarelli
 */
public final class ServerConnectionTask implements Runnable {
    

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
	System.out.println("Domain: " + System.getenv("userdomain"));
	System.out.println("Logon Server: " + System.getenv("logonserver"));
    }

}
