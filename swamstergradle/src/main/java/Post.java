import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Post {

	public String author;
	public String title;

	public Post(String author, String title) {

		// Get a reference to our posts
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("server/saving-data/fireblog/posts");

		// Attach a listener to read the data at our posts reference
		ref.addValueEventListener(new ValueEventListener() {
			@Override 
			public void onDataChange(DataSnapshot dataSnapshot) {
				Post post = dataSnapshot.getValue(Post.class);
				System.out.println(post);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				System.out.println("The read failed: " + databaseError.getCode());
			}
		});
	}
}
