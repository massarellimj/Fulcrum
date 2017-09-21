/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.unitedgasket.fulcrum.Fulcrum.core.model.Registration;

/**
 * 
 *
 * @author Michael Massarelli
 */
@SuppressWarnings("resource")
public class FulcrumClient {
    public static final String TAG = "FulcrumClient";

    private static final int PORT = 9090;
    private static final String SERVER_ADDRESS = "127.0.0.1";

    BufferedReader in;
    PrintWriter out;


    public FulcrumClient() {
	try {
	    Socket socket = new Socket(SERVER_ADDRESS, PORT);
	    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    out = new PrintWriter(socket.getOutputStream(), true);
	    initiate();
	} catch (ConnectException e) {
	    System.out.println("COULD NOT CONNECT TO SERVER");
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    public String getEmail(String username) throws IOException {
	out.println("REQUEST EMAIL FOR _" + username);
	while (true) {
	    String response = in.readLine();
	    if (response != null && response != "USERNAME") {
		return response.substring(response.indexOf('_') + 1);
	    }
	}
    }
    
    public void register(Registration reg) throws IOException {
	out.println("REGISTRATION REQUEST");
	out.println("USERNAME_" + reg.getUsername());
	out.println("PASSWORD_" + reg.getPassword());
	out.println("FIRST_" + reg.getFirst());
	out.println("LAST_" + reg.getLast());
	out.println("EMAIL_" + reg.getEmail());
    }

    private void initiate() throws IOException {
	boolean initiated = false;
	while (!initiated) {
	    String readline = in.readLine();
	    if (readline.startsWith("USERNAME")) {
		out.println("USER_user1");
		initiated = true;
	    }
	}
    }



    public static void main(String[] args) {
	new FulcrumClient();
    }

}
