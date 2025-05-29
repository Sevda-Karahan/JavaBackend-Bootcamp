import java.util.HashSet;
import java.util.LinkedList;

public class User {
    private String username;
    private String email;
    private int age;
    private Profile profile;
    private HashSet<User> friends;
    private LinkedList<Post> posts;

    // İç sınıf: Profile
    public class Profile {
        private String bio;
        private String profilePicturePath;

        public Profile(String bio, String profilePicturePath) {
            this.bio = bio;
            this.profilePicturePath = profilePicturePath;
        }

        public String getBio() { return bio; }
        public String getProfilePicturePath() { return profilePicturePath; }

        public void setBio(String bio) { this.bio = bio; }
        public void setProfilePicturePath(String path) { this.profilePicturePath = path; }
    }

    public User(String username, String email, int age, String bio, String profilePicturePath) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.profile = new Profile(bio, profilePicturePath);
        this.friends = new HashSet<>();
        this.posts = new LinkedList<>();
    }

    public String getUsername() { return username; }
    public HashSet<User> getFriends() { return friends; }
    public LinkedList<Post> getPosts() { return posts; }
    public Profile getProfile() { return profile; }
    public Integer getAge() { return age; }

    public void addFriend(User user) {
        if (user != this) {
            friends.add(user);
        }
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}