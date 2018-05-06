import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.logging.Log;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main {

	public static void main(String[] args) throws IOException {

		
	
		// Fetch the service account key JSON file contents
		FileInputStream serviceAccount = new FileInputStream("/swamstergradle/swamsteras-firebase-adminsdk-k34gn-241c2a7188.json");

		// Initialize the app with a service account, granting admin privileges
		FirebaseOptions options = new FirebaseOptions.Builder()
		    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		    .setDatabaseUrl("https://<swamsteras>.firebaseio.com//")
		    .build();
		FirebaseApp.initializeApp(options);
//		
//		GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream("/swamstergradle/swamsteras-firebase-adminsdk-k34gn-241c2a7188.json"))
//			    .createScoped(Collections.singleton(SQLAdminScopes.SQLSERVICE_ADMIN));
		
		
		
		
		
		
//
//		// As an admin, the app has access to read and write all data, regardless of Security Rules
//		final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("server\test");
//		
//		DatabaseReference pusher= ref.push();
//		pusher.setValue("help");
//
//		ref.addListenerForSingleValueEvent(new ValueEventListener() {
//		  @Override
//		  public void onDataChange(DataSnapshot dataSnapshot) {
//		    Object document = dataSnapshot.getValue();
//		    System.out.println(document);
//		  }
//
//		  @Override
//		  public void onCancelled(DatabaseError error) {
//			  System.out.println("The read failed: " + error.getCode());
//		  }
//		});
		
		
	

			// Get a reference to our posts
			final FirebaseDatabase database = FirebaseDatabase.getInstance();
			DatabaseReference ref = database.getReference("swamsteras/server/test");
			
			DatabaseReference pushto = ref.push();
			User users = new User("June 23, 1912", "Alan Turing");
			
			pushto.setValueAsync(users);
			
			// Attach a listener to read the data at our posts reference
			ref.addValueEventListener(new ValueEventListener() {
				@Override 
				public void onDataChange(DataSnapshot dataSnapshot) {
					Main post = dataSnapshot.getValue(Main.class);
					System.out.println(post);
				}

				@Override
				public void onCancelled(DatabaseError databaseError) {
					System.out.println("The read failed: " + databaseError.getCode());
				}
			});
		}
		
	
	
	
		
	
	}


