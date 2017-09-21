/**
 * 
 */
package com.unitedgasket.fulcrum.Fulcrum.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class SHA512 {
    public static final String TAG = "SHA512";
    
    public static String encrypt(String message) {
	byte[] bytes = DigestUtils.sha512(message.getBytes());
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < bytes.length; i++) {
	    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	}
	return sb.toString();
    }
    
    public static String encrypt(char[] chars) {
	if (chars.length == 0) return null;
	String msg = "";
	for (char c : chars) {
	    msg += Character.toString(c);
	}
	return encrypt(msg);
    }
    
    public static void main(String[] args) {
	System.out.println(encrypt("alpine"));
    }
}
