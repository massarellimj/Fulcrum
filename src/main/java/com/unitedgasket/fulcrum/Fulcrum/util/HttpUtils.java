/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Properties;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.unitedgasket.fulcrum.Fulcrum.core.FulcrumResources;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class HttpUtils {
    public static final String TAG = "HttpUtils";
    static String url = "https://www.dropbox.com/s/asrd9c3i08v8v4y/aesthetica.zip?dl=0";

    public static void downloadIconPack() {
	try {
	    Properties prop = new Properties();
	    File f = FulcrumResources.getCfg("dropbox.properties");
	    InputStream in = new FileInputStream(f);
	    prop.load(in);
	    
	    DbxAppInfo appInfo = new DbxAppInfo(prop.getProperty("key"), prop.getProperty("secret"));

	        DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",
	            Locale.getDefault().toString());
	        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

	        // Have the user sign in and authorize your app.
	        String authorizeUrl = webAuth.start();
	        System.out.println("1. Go to: " + authorizeUrl);
	        System.out.println("2. Click \"Allow\" (you might have to log in first)");
	        System.out.println("3. Copy the authorization code.");
	        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

	        // This will fail if the user enters an invalid authorization code.
	        DbxAuthFinish authFinish = webAuth.finish(code);
	        String accessToken = authFinish.accessToken;

	        DbxClient client = new DbxClient(config, accessToken);

	        System.out.println("Linked account: " + client.getAccountInfo().displayName);

	        DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
	        System.out.println("Files in the root path:");
	        for (DbxEntry child : listing.children) {
	            System.out.println("	" + child.name + ": " + child.toString());
	        }

	        FileOutputStream outputStream = new FileOutputStream("fulcrum.txt");
	        try {
	            DbxEntry.File downloadedFile = client.getFile("/Fulcrum/resources/fulcrum.txt", null,
	                outputStream);
	            System.out.println("Metadata: " + downloadedFile.toString());
	        } finally {
	            outputStream.close();
	        }
	} catch (IOException | DbxException e) {
	    
	}
    }


    public static void main(String[] args) {
	downloadIconPack();
    }
}
