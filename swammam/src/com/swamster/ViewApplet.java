package com.swamster;

import java.applet.Applet;
import java.applet.AppletContext;
import java.net.MalformedURLException;
import java.net.URL;



public class ViewApplet extends Applet {
	
	public void init() {
		try {
			URL url = new URL("https://console.firebase.google.com/u/0/project/swamsteras/database/swamsteras/data");
		
			AppletContext context = getAppletContext();
			context.showDocument(url);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
