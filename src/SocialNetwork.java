import java.util.ArrayList;

public class SocialNetwork {
    private String appName;
    public ArrayList<Profile> profiles = new ArrayList<>();
    public ArrayList<Post> posts = new ArrayList<>();

    public SocialNetwork(String appName) {
        this.appName = appName;
    }

    public void addProfile(Profile p) {
        profiles.add(p);
    }

    public void addPost(Post p) {
        posts.add(p);
    }

    public Profile findUser(String name) {
        for (Profile p : profiles) {
            if (p.getLogin().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Post> getPopularPosts(int minLikes) {
        ArrayList<Post> result = new ArrayList<>();
        for (Post p : posts) {
            if (p.getLikes() >= minLikes) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "App: " + appName + " (Users: " + profiles.size() + ")";
    }
}