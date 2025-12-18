public class Post {

    private String user;
    private String text;
    private int likes;

    public Post(String user, String text) {
        this.user = user;
        this.text = text;
        this.likes = 0;
    }

    public void readThePost() {
        System.out.println("User: " + user);
        System.out.println("Post: " + text);
        System.out.println("Likes: " + likes);
    }

    public String getPostText() {
        return text;
    }

    public int getLikeCount() {
        return likes;
    }

    public void putLike() {
        likes++;
    }

    public void putDislike() {
        if (likes > 0) {
            likes--;
        }
    }
}
