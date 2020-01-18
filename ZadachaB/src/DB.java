import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private final static String url = "jdbc:postgresql://localhost:5432/";
    private final static String user = "postgres";
    private final static String password = "232312dk";


    public static Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected successfully");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            return conn;
        }
    public void insertNews(News news){
        String SQL = "insert into news(title,text, time_pub) values (?,?, now())";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getText());
            statement.executeUpdate();
            System.out.println("Successfully inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteNews(int id){
        String SQL = "delete from news where id = ?";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Successfully deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateNews(String title, String text, int id){
        String SQL = "update news set title = ?, text = ? where id = ?";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, title);
            statement.setString(2, text);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Successfully updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<News> getNews() {
        List <News> newsDB = new ArrayList<>();
        String SQL = "select title, text from news";
        try (Connection conn = DB.connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    News news = new News();
                    news.setText(rs.getString("TEXT"));
                    news.setTitle(rs.getString("TITLE"));
                    newsDB.add(news);
            } return newsDB;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void printNews(){
        System.out.println(getNews());
    }
}
