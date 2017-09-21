/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.account;

import com.unitedgasket.fulcrum.Fulcrum.settings.FulcrumSettings;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class FulcrumUserAccount {
    
    private String firstName, lastName, email, username;
    private FulcrumSettings settings;
    private boolean signedIn;
    private FulcrumProfile profile;
    
    public FulcrumUserAccount(String firstName, String lastName, String email, String username) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.username = username;
    }
    
    public String getUsername() {
	return username;
    }
    
    public void setUsername(String username) {
	this.username = username;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the settings
     */
    public FulcrumSettings getSettings() {
        return settings;
    }

    /**
     * @param settings the settings to set
     */
    public void setSettings(FulcrumSettings settings) {
        this.settings = settings;
    }

    /**
     * @return the signedIn
     */
    public boolean isSignedIn() {
	return signedIn;
    }

    /**
     * @param signedIn the signedIn to set
     */
    public void setSignedIn(boolean signedIn) {
	this.signedIn = signedIn;
    }

    /**
     * @return the profile
     */
    public FulcrumProfile getProfile() {
	return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(FulcrumProfile profile) {
	this.profile = profile;
    }
}
