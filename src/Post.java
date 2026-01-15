import java.util.Objects;

public class Post {
    private Profile author;
    private String text;
    private int likes;

    public Post(Profile author, String text) {
        this.author = author;
        this.text = text;
        this.likes = 0;
    }

    public void putLike() {
        likes++;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return author.getLogin() + ": " + text + " (" + likes + " likes)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return text.equals(post.text) && author.equals(post.author);
    }

    @Override
    public int hashCode() {
        return text.hashCode() + author.hashCode();
    }
}