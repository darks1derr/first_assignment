public class Profile {

    private String login;
    private String password;
    private int subscriptions;
    private int subscribers;

    public Profile(String login, String password) {
        this.login = login;
        this.password = password;
        this.subscriptions = 0;
        this.subscribers = 0;
    }

    public void showProfileInfo() {
        System.out.println("Username: " + login);
        System.out.println("Subscriptions: " + subscriptions);
        System.out.println("Subscribers: " + subscribers);
    }

    public int getSubscriptionsCount() {
        return subscriptions;
    }

    public int getSubscribersCount() {
        return subscribers;
    }

    public void followSomeone() {
        subscriptions++;
    }

    public void unfollowSomeone() {
        if (subscriptions > 0) {
            subscriptions--;
        }
    }

    public void addSubscriber() {
        subscribers++;
    }

    public void removeSubscriber() {
        if (subscribers > 0) {
            subscribers--;
        }
    }
}
