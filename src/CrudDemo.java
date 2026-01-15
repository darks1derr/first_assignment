import java.sql.*;
import java.util.ArrayList;

public class CrudDemo {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:postgresql://localhost:5432/socialnet";
        String user = "postgres";
        String password = "123";

        Class.forName("org.postgresql.Driver");

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("CONNECTED!");

        int profileId = addProfile(conn, "UserTest", "123", 0);
        int postId = addPost(conn, profileId, "Hello from DB!", 0);

        System.out.println("PROFILES:");
        ArrayList<String> profiles = getProfiles(conn);
        for (String s : profiles) {
            System.out.println(s);
        }

        System.out.println("POSTS with likes >= 0:");
        ArrayList<String> posts = getPopularPosts(conn, 0);
        for (String s : posts) {
            System.out.println(s);
        }

        updatePostLikes(conn, postId, 3);

        System.out.println("POSTS with likes >= 1:");
        ArrayList<String> posts2 = getPopularPosts(conn, 1);
        for (String s : posts2) {
            System.out.println(s);
        }

        deletePost(conn, postId);

        System.out.println("POSTS after delete:");
        ArrayList<String> posts3 = getPopularPosts(conn, 0);
        for (String s : posts3) {
            System.out.println(s);
        }

        conn.close();
    }

    public static int addProfile(Connection conn, String login, String pass, int subs) throws SQLException {
        String sql = "INSERT INTO profiles(login, password, subscribers) VALUES (?, ?, ?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, pass);
        ps.setInt(3, subs);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int id = rs.getInt("id");
        rs.close();
        ps.close();
        return id;
    }

    public static int addPost(Connection conn, int authorId, String text, int likes) throws SQLException {
        String sql = "INSERT INTO posts(author_id, text, likes) VALUES (?, ?, ?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, authorId);
        ps.setString(2, text);
        ps.setInt(3, likes);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int id = rs.getInt("id");
        rs.close();
        ps.close();
        return id;
    }

    public static ArrayList<String> getProfiles(Connection conn) throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT id, login, subscribers FROM profiles ORDER BY id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String login = rs.getString("login");
            int subs = rs.getInt("subscribers");
            list.add(id + " " + login + " subs=" + subs);
        }
        rs.close();
        ps.close();
        return list;
    }

    public static ArrayList<String> getPopularPosts(Connection conn, int minLikes) throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT p.id, pr.login, p.text, p.likes " +
                "FROM posts p JOIN profiles pr ON pr.id = p.author_id " +
                "WHERE p.likes >= ? ORDER BY p.id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, minLikes);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String login = rs.getString("login");
            String text = rs.getString("text");
            int likes = rs.getInt("likes");
            list.add(id + " " + login + ": " + text + " likes=" + likes);
        }
        rs.close();
        ps.close();
        return list;
    }

    public static void updatePostLikes(Connection conn, int postId, int newLikes) throws SQLException {
        String sql = "UPDATE posts SET likes = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, newLikes);
        ps.setInt(2, postId);
        ps.executeUpdate();
        ps.close();
    }

    public static void deletePost(Connection conn, int postId) throws SQLException {
        String sql = "DELETE FROM posts WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, postId);
        ps.executeUpdate();
        ps.close();
    }
}
