import java.io.FileInputStream;
import java.io.IOException;

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
//		FileInputStream serviceAccount = new FileInputStream("C:\\Users\\Aria\\eclipse\\java-oxygen\\eclipse\\jsonswamster");
//
//		FirebaseOptions options = new FirebaseOptions.Builder()
//		    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//		    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
//		    .build();
//
//		FirebaseApp.initializeApp(options);
		
		// Fetch the service account key JSON file contents
		FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccount.json");

		// Initialize the app with a service account, granting admin privileges
		FirebaseOptions options = new FirebaseOptions.Builder()
		    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		    .setDatabaseUrl("https://<databaseName>.firebaseio.com")
		    .build();
		FirebaseApp.initializeApp(options);

		// As an admin, the app has access to read and write all data, regardless of Security Rules
		DatabaseReference ref = FirebaseDatabase.getInstance()
		    .getReference("restricted_access/secret_document");
		ref.addListenerForSingleValueEvent(new ValueEventListener() {
		  @Override
		  public void onDataChange(DataSnapshot dataSnapshot) {
		    Object document = dataSnapshot.getValue();
		    System.out.println(document);
		  }

		  @Override
		  public void onCancelled(DatabaseError error) {
		  }
		});

	
	
	
	
		
	
	}

}
