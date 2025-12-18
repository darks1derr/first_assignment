public class Main {
    public static void main(String[] args) {

        Profile user1 = new Profile("Darkhan", "pass123");
        Profile user2 = new Profile("Aikyn", "qwerty");

        System.out.println("Users:");
        user1.showProfileInfo();
        user2.showProfileInfo();
        System.out.println("---------------------");

        user1.followSomeone();
        user2.addSubscriber();
        user1.showProfileInfo();
        user2.showProfileInfo();
        System.out.println("---------------------");

        Post post1 = new Post("Darkhan", "Everybody come on");
        Post post2 = new Post("Aikyn", "Just my universe");

        post1.putLike();
        post1.putLike();
        post2.putLike();
        post2.putDislike();

        System.out.println("Posts:");
        post1.readThePost();
        System.out.println("---------------------");
        post2.readThePost();
    }
}
