import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseBaglanti {

    static String username = "root";
    static String password = "12345";
    static String dbUrl = "jdbc:mysql://localhost:3306/email?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static Connection connection;
    static Statement statement;     //cümle,cümlecik // veritabanına gönderdiğimiz sql kodu
    static ResultSet resultSet;     // sonuç // döndürülen sonuç
    Scanner scanner = new Scanner(System.in);
    private int id;

    public boolean login(String email, String sifre) {

        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from worker");

            while (resultSet.next()) {

                if ((resultSet.getString("email").equals(email.toLowerCase()) && resultSet.getString("password").equals(sifre))) {
                    setId(resultSet.getInt("id"));
                    return true;
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return false;
    }

    public boolean addToDatabase(String sql_sorgu) {

        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            statement = connection.createStatement();
            statement.executeUpdate((sql_sorgu));
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        } finally {

        }
    }

    public boolean updatePassword(String password) {

        try {
            connection = DriverManager.getConnection(dbUrl, username, this.password);
            statement = connection.createStatement();
            statement.executeUpdate(("UPDATE worker SET password = '" + password + "' WHERE id = '" + getId() + "'"));
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

    }

    public boolean passwordTrueOrFalse(String password) {

        try {
            connection = DriverManager.getConnection(dbUrl, username, this.password);
            statement = connection.createStatement();
            statement.executeQuery(("SELECT * FROM worker where id = " + getId() + ""));

                if (resultSet.getString("password").equals(password)) {
                    return true;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


