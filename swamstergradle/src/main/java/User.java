import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User {

  public String date_of_birth;
  public String full_name;
  public String nickname;

  public User(String dateOfBirth, String fullName) {
    // ...
  }

  public User(String dateOfBirth, String fullName, String nickname) {
    // ...
  }

  public static void main(String[] args) {
  final FirebaseDatabase database = FirebaseDatabase.getInstance();
  DatabaseReference ref = database.getReference("server/saving-data/fireblog");
  
DatabaseReference usersRef = ref.child("users");

Map<String, User> users = new HashMap<>();
users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));
users.put("gracehop", new User("December 9, 1906", "Grace Hopper"));

usersRef.setValueAsync(users);
}
}