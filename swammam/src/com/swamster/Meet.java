package com.swamster;
import java.util.ArrayList;

public class Meet {

	private ArrayList<Event> event;
	
	public Meet (ArrayList<Event> events) {
		event= events;
	}
	
	public void addEvent(Event eventadd) {
		event.add(eventadd);
	}
	
	
}
