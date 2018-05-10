package com.swamster;





import java.awt.image.BufferedImage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.json.JSONArray;

/**
 * Created by Shreya on 4/23/18.
 */

public class csvParse {
    public ArrayList<Event> events;
    public ArrayList<Swimmer> swimmers;
    private String source;
    private ArrayList<String> eventId;
    private Meet meet;
    private JSONArray json;

//    public csvParse(InputStream is) {
//        events = new ArrayList<Event>();
//        swimmers = new ArrayList<Swimmer>();
//        readSwimmerData(is);
//        readEventData(is);
//        events = getEvents();
//        swimmers = getSwimmers();
//    }
    
    public csvParse() {
        
    }
    
    public void csvParser(InputStream is) {
        
        swimmers = new ArrayList<Swimmer>();
        eventId = new ArrayList<String>();
        readData(is);
        events = new ArrayList<Event>();
        createEvents();
        JSONArray json = new JSONArray(Arrays.asList(events));
        this.json= json;
//        Meet meet = new Meet(events);
//        this.meet=meet;
        
//        readEventIDData(is);
        //events = getEvents();
//        swimmers = getSwimmers();
        
        
//        eventId = geteventId();
        
      
//        for (int x=0; x< events.size(); x++) {
//        	System.out.println(events.get(x).toString());
//        }
    }

    public void readData(InputStream is) {
        //Read the data from the file
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                //Split line by ","
                String[] fields = line.split(",");
               //Log.d("csvParseFieldLength", String.valueOf(fields.length));
                ArrayList<Race> races = new ArrayList<>();
                if (fields[9].equals(""))
                    break;
                else {
                    Swimmer s = new Swimmer(fields[0],fields[10], fields[9], Integer.parseInt(fields[8]), fields[7], races);
                    swimmers.add(s);
                    s.addRace(new Race(Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), 0, null, (fields[4] + " " + fields[5])));
                    
                    EventID e = new EventID(eventId);
                    String b = fields[12];
                    
                    
                    if (!b.equals(" ")) 
                    	e.addNames(b);
                  
                    
                    
                }
            }
        } catch (IOException ex) {
            //Log.d("csvParseSwim", "Error reading data from file on line " + line);
        }
    }

//    public void readEventIDData(InputStream is) {
//        //Read the data from the file
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        EventID e = new EventID(eventId);
//        String line = "";
//        try {
//            while ((line = reader.readLine()) != null) {
//            	
//               // Split line by ","
//                String[] field = line.split(",");
//                 
////                e.setEventName(fields[0]);
////                e.setEventTime(null);
////                e.setNames(s);
////                e.setRaces(r);
////                e.addRaces(new Race(Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), 0, null, (fields[4] + " " + fields[5])));
////                e.addNames((fields[4] + " " + fields[5]));
//               
//                
////                if (fields[12].equals(""))
////                    break;
////                else {
//                  String s = field[9];
////                  System.out.println("why");
//                	e.addNames(s);
//                	System.out.println(field[9]);
////                }
//                
//                
////                for (Swimmer swimmer : swimmers) {
////                    if (swimmer.getFirstName().equals(fields[4]) && swimmer.getLastName().equals(fields[5]))
////                        swimmer.addRace(new Race(Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), 0, null, (fields[4] + " " + fields[5])));
////                }
//            }
//        } catch (IOException ex) {
//           //Log.d("csvParseEvent", "Error reading data from file on line " + line);
//        }
//    }

    public void createEvents () {
    	
    	for(int x=0; x<eventId.size(); x++) {
    		events.add(new Event(eventId.get(x)));
    	}
    	
    	for(int x=0; x<swimmers.size(); x++) {
    		for (int y=0; y<events.size(); y++) {
    			if(swimmers.get(x).getEvent().equals(events.get(y).getEventName())) {
    				events.get(y).setSwimmer(swimmers.get(x));
    			}
    		}
    	}
    	
    	
    	
//    	ArrayList<Swimmer> miniswimmer =new ArrayList<Swimmer>();
//    	Event t = new Event(eventId.size());
    	
//    	for(int x=0; x<eventId.size(); x++) {
//    		events.add(t);
//    	}
    	
//    	for(int x=0; x<swimmers.size(); x++) {
//    		
//    		for (int y=0; y<eventId.size(); y++) {
//    			
//    			//System.out.println(swimmers.get(x).getEvent());
//    			
//    			if(swimmers.get(x).getEvent().equals(eventId.get(y))){
////    				t.setSwimmer(swimmers.get(x));
////    				t.setEventName(swimmers.get(x).getEvent());
//    				events.get(y).setSwimmer(swimmers.get(x));
//    				events.get(y).setEventName(swimmers.get(x).getEvent());
//    			}
//    			
//    		}
//    		
//    	}
    	
    }
    

    
    
    public String stuffToString(String s) {
        String string = s.replace("[", " ");
        string = string.replace("]", "");
        return string;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }
    
//    public ArrayList<String> geteventId() {
//        return eventId;
//    }
    
    public void load(String source)
    {
       try 
       {
          this.source = source;
//          BufferedReader file;
//          
//          file = InputStream.this.
//        		  (new File(source));

          File selected = new File(source);
          InputStream read = new FileInputStream(selected);
          csvParser(read);
               
       }
       catch (Exception ex)
       {
          this.source = null;
          ex.printStackTrace();
       }
    }      

    
    
    public void pick()
    {
       JFileChooser chooser = new JFileChooser(".");
       if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
       {
    	  String filepath = (chooser.getSelectedFile().getAbsolutePath());
    	  filepath = filepath.replace("\\", "\\\\");
    	  
          load(chooser.getSelectedFile().getAbsolutePath());
    	   
       }
    }   
    
    public Meet getMeet() {
    	return meet;
    }
    
    public JSONArray getJson() {
    	return json;
    }
    
    
}
