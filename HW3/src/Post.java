import java.util.HashSet;

public class Post {
    private String content;
    private HashSet<String> likes;

    public Post(String content) {
        this.content = content;
        this.likes = new HashSet<>();
    }

    public String getContent() { return content; }
    public HashSet<String> getLikes() { return likes; }

    public void like(String username) {
        likes.add(username);
    }

    public int getLikeCount() {
        return likes.size();
    }
}