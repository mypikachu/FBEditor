package de.FBEditor.utils.upnp;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
//import java.net.InetAddress;

public class MyAuthenticator extends Authenticator {

	private String mUsername = "";
	private String mPassword = "";
	
	// 01.08.2015
	public MyAuthenticator(String username, String password) {
		mUsername = username;
		mPassword = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
//		    String promptString = getRequestingPrompt();
//		    System.out.println(promptString);
//		    String hostname = getRequestingHost();
//		    System.out.println(hostname);
//		    InetAddress ipaddr = getRequestingSite();
//		    System.out.println(ipaddr);
//		    int port = getRequestingPort();
//		    System.out.println(port);

//		    String username = "name";
//		    String password = "password";

		    return new PasswordAuthentication(mUsername, mPassword.toCharArray());
		  }
}
