/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class NetworkUtils {
    public static final String TAG = "NetworkUtils";
    
    
    public static String getLocalIPv4() {
	try {
	    return InetAddress.getLocalHost().getHostAddress();
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public static void checkConnection() {
	try {
	    Socket socket = new Socket("google.com", 80);
	    socket.close();
	    System.out.println("Still connected...");
	} catch (IOException e) {
	    System.out.println("Connection interrupted!!!");
	}
    }
}
