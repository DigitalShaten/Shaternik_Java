package java_core_final_project.repository;

import java_core_final_project.model.Account;
import java_core_final_project.util.DatabaseConfig;

import java.sql.*;

public class AccountRepository {

    public Account getAccountByNumber(String accountNumber) {
        String sql = "SELECT * FROM accounts WHERE account_number = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Account(
                        rs.getString("account_number"),
                        rs.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении счета: " + e.getMessage());
        }
        return null;
    }

    public void updateAccount(Account account) {
        String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, account.getBalance());
            pstmt.setString(2, account.getAccountNumber());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении баланса: " + e.getMessage());
        }
    }
}