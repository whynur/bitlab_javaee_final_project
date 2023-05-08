package kz.bitlab.javaee.final_project.db;


import kz.bitlab.javaee.final_project.model.Comments;
import kz.bitlab.javaee.final_project.model.Users;
import kz.bitlab.javaee.final_project.model.News;
import kz.bitlab.javaee.final_project.model.NewsCategories;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    public static final String url = "jdbc:postgresql://localhost:5433/bitlab_final";
    public static final String user = "postgres";
    public static final String password = "00000000";

    public static ArrayList<News> getNews() {
        ArrayList<News> news = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                PreparedStatement statement = conn.prepareStatement("" +
                        "SELECT n.id, n.post_date, n.category_id, n.title, n.content, nc.name " +
                        "FROM news n " +
                        "INNER JOIN news_categories nc ON nc.id = n.category_id " +
                        "ORDER BY n.post_date DESC ");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    News nev = new News();
                    nev.setId(resultSet.getLong("id"));
                    nev.setPostDate(resultSet.getTimestamp("post_date"));
                    nev.setTitle(resultSet.getString("title"));
                    nev.setContent(resultSet.getString("content"));
                    nev.setCategoryId(resultSet.getInt("category_id"));
                    news.add(nev);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
    public static ArrayList<NewsCategories> getAllCategory() {
        ArrayList<NewsCategories> news_categories = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * FROM public.news_categories");

                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    news_categories.add(new NewsCategories(id, name));
                }
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return news_categories;
    }
    public static Users getUser(String email) {
        Users usere = null;
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                PreparedStatement statement = conn.prepareStatement("" + "SELECT * FROM public.users WHERE email = ?");
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    usere = new Users();
                    usere.setId(resultSet.getLong("id"));
                    usere.setEmail(resultSet.getString("email"));
                    usere.setPassword(resultSet.getString("password"));
                    usere.setFullName(resultSet.getString("full_name"));
                    usere.setRoleId(resultSet.getInt("role_id"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return usere;
    }

    public static boolean addUser(Users usere){
        int rows = 0;
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)){
                PreparedStatement statement = conn.prepareStatement("" +
                        "INSERT INTO users (email, password, full_name, role_id) " +
                        "VALUES (?, ?, ?, ?)");
                statement.setString(1, usere.getEmail());
                statement.setString(2, usere.getPassword());
                statement.setString(3, usere.getFullName());
                statement.setInt(4, usere.getRoleId());
                rows = statement.executeUpdate();
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rows>0;
    }
    public static void editUser(Users newUser) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                Statement statement = conn.createStatement();
                String query = ("" +
                        "UPDATE public.users SET \n" +
                        "email = ?, password = ?, full_name = ?, role_id = ? \n" +
                        "WHERE id = ?;");
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, newUser.getEmail());
                preparedStmt.setString(2, newUser.getPassword());
                preparedStmt.setString(3, newUser.getFullName());
                preparedStmt.setInt(4, newUser.getRoleId());
                preparedStmt.setLong(5, newUser.getId());
                preparedStmt.executeUpdate();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static NewsCategories getCategory(int id) {
        NewsCategories categories = null;
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                PreparedStatement statement = conn.prepareStatement("" +
                        "SELECT * FROM news_categories WHERE id = ?");
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    categories = new NewsCategories();
                    categories.setName(resultSet.getString("name"));
                    categories.setId(resultSet.getLong("id"));
                }
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static News getNewsById(Long id) {
        News news = null;
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                PreparedStatement statement = conn.prepareStatement("" +
                        "SELECT * FROM news WHERE id = ?");
                statement.setLong(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    news = new News();
                    news.setId(resultSet.getLong("id"));
                    news.setPostDate(resultSet.getTimestamp("post_date"));
                    news.setTitle(resultSet.getString("title"));
                    news.setContent(resultSet.getString("content"));
                    news.setCategoryId(resultSet.getInt("category_id"));

                }

                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }



    public static void updateNews(News news) {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                PreparedStatement statement = conn.prepareStatement("" +
                        "UPDATE news SET title = ?, content = ?, category_id = ? " +
                        "WHERE id = ?");

                statement.setString(1, news.getTitle());
                statement.setString(2, news.getContent());
                statement.setInt(3, news.getCategoryId());
                statement.setLong(4, news.getId());

                statement.executeUpdate();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addNews(News news){
        int rows = 0;
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)){
                PreparedStatement statement = conn.prepareStatement("" +
                        "INSERT INTO news (post_date, category_id, title, content) " +
                        "VALUES (?, ?, ?, ?)");
                statement.setTimestamp(1, news.getPostDate());
                statement.setInt(2, news.getCategoryId());
                statement.setString(3, news.getTitle());
                statement.setString(4, news.getContent());
                rows = statement.executeUpdate();
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Comments> getComments(Long newsId) {

        ArrayList<Comments> comments = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                PreparedStatement statement = conn.prepareStatement("" +
                        "SELECT co.id, co.comment, co.post_date, co.user_id, co.news_id, u.full_name " +
                        "FROM comments co " +
                        "INNER JOIN users u ON u.id = co.user_id " +
                        "WHERE co.news_id = ? " +
                        "ORDER BY co.post_date DESC");

                statement.setLong(1, newsId);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    Comments comment = new Comments();
                    comment.setId(resultSet.getLong("id"));
                    comment.setComment(resultSet.getString("comment"));
                    comment.setPostDate(resultSet.getTimestamp("post_date"));
                    Users user = new Users();
                    user.setId(resultSet.getLong("user_id"));
                    user.setFullName(resultSet.getString("full_name"));
                    comment.setUsers(user);

                    News news = new News();
                    news.setId(resultSet.getLong("news_id"));
                    comment.setNews(news);

                    comments.add(comment);
                }
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public static void addComment(Comments comment) {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                PreparedStatement statement = conn.prepareStatement("" +
                        "INSERT INTO comments (comment, user_id, news_id, post_date) " +
                        "VALUES (?, ?, ?, NOW())");

                statement.setString(1, comment.getComment());
                statement.setLong(2, comment.getUsers().getId());
                statement.setLong(3, comment.getNews().getId());

                statement.executeUpdate();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
