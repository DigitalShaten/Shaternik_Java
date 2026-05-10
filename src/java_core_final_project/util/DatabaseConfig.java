package java_core_final_project.util;

import java.sql.*;

public class DatabaseConfig {
    private static final String URL = "jdbc:h2:./bank_db";
    private static final String USER = "Nikita_Shaternik";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (" +
                    "account_number VARCHAR(11) PRIMARY KEY, " +
                    "balance DOUBLE)");

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM accounts");
            if (rs.next() && rs.getInt(1) == 0) {
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('12345-12345', 1000.0)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('54321-54321', 500.0)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('11111-11111', 2500.0)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('22222-22222', 2500.0)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('33333-33333', 50.0)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('44444-44444', 10000.0)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('55555-55555', 300.0)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('66666-66666', 1500.0)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('77777-77777', 800.5)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('88888-88888', 320.5)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('99999-99999', 450.53)");
                stmt.execute("INSERT INTO accounts (account_number, balance) VALUES ('10101-10101', 1200.1)");
                System.out.println("Начальные аккаунты успешно добавлены в БД.");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка инициализации БД: " + e.getMessage());
        }
    }
}