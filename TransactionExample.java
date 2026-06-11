import java.sql.*;

public class TransactionExample {

    public static void transfer(
            int fromAccount,
            int toAccount,
            double amount) {

        String debit =
                "UPDATE accounts SET balance = balance - ? WHERE id = ?";

        String credit =
                "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn =
                     DriverManager.getConnection(
                             "jdbc:mysql://localhost:3306/studentdb",
                             "root",
                             "password")) {

            conn.setAutoCommit(false);

            PreparedStatement debitStmt =
                    conn.prepareStatement(debit);

            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);

            debitStmt.executeUpdate();

            PreparedStatement creditStmt =
                    conn.prepareStatement(credit);

            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);

            creditStmt.executeUpdate();

            conn.commit();

            System.out.println("Transfer Successful");

        } catch (Exception e) {

            System.out.println("Transfer Failed");

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        transfer(1, 2, 1000);
    }
}