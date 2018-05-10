package com.swamster;
import java.util.ArrayList;

public class EventID {

	private ArrayList<String> eventNames = new ArrayList<String>();
	
	public EventID (ArrayList<String> eventNames) {
		this.eventNames=eventNames;
	}
	
	@Override
	public String toString() {
		String output="";
		for(int x=0; x< eventNames.size(); x++) {
			output+= eventNames.get(x);
		}
		return output;
	}

   
    public void addNames(String eventName) {
        eventNames.add(eventName);
    }
	
}

