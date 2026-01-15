import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SocialNetwork net = new SocialNetwork("MyNet");

        Profile p1 = new Profile("Darkhan", "123");
        Profile p2 = new Profile("Aikyn", "qwe");

        p2.addSubscriber();
        p2.addSubscriber();

        net.addProfile(p1);
        net.addProfile(p2);

        Post post1 = new Post(p1, "Hello!");
        post1.putLike();
        net.addPost(post1);

        System.out.println(net.findUser("Darkhan"));

        ArrayList<Post> popular = net.getPopularPosts(1);
        for (Post p : popular) {
            System.out.println(p);
        }

        System.out.println("Check equals: " + p1.equals(new Profile("Darkhan", "000")));
    }
}