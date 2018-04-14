//public static class Post {
//
//  public String author;
//  public String title;
//
//  public Post(String author, String title) {
//    // ...
//  }
//
//}
//
//// Get a reference to our posts
//final FirebaseDatabase database = FirebaseDatabase.getInstance();
//DatabaseReference ref = database.getReference("server/saving-data/fireblog/posts");
//]
//// Attach a listener to read the data at our posts reference
//ref.addValueEventListener(new ValueEventListener() {
//  @Override
//  public void onDataChange(DataSnapshot dataSnapshot) {
//    Post post = dataSnapshot.getValue(Post.class);
//    System.out.println(post);
//  }
//
//  @Override
//  public void onCancelled(DatabaseError databaseError) {
//    System.out.println("The read failed: " + databaseError.getCode());
//  }
//  
//  ref.addChildEventListener(new ChildEventListener() {
//	  @Override
//	  public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//	    Post newPost = dataSnapshot.getValue(Post.class);
//	    System.out.println("Author: " + newPost.author);
//	    System.out.println("Title: " + newPost.title);
//	    System.out.println("Previous Post ID: " + prevChildKey);
//	  }
//
//	  @Override
//	  public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}
//
//	  @Override
//	  public void onChildRemoved(DataSnapshot dataSnapshot) {}
//
//	  @Override
//	  public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}
//
//	  @Override
//	  public void onCancelled(DatabaseError databaseError) {}
//	}
//})