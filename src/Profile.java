import java.util.Objects;

public class Profile extends User {
    private String password;
    private int subscribers;

    public Profile(String login, String password) {
        super(login);
        this.password = password;
        this.subscribers = 0;
    }

    public void addSubscriber() {
        subscribers++;
    }

    public int getSubscribersCount() {
        return subscribers;
    }

    @Override
    public String toString() {
        return "User: " + login + " | Subs: " + subscribers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return login.equals(profile.login);
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}