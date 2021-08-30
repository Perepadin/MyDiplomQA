package ru.netology.SQLunits;

import java.sql.*;

public class SqlUtils {
      public static Connection getConnection() throws SQLException {
        String dbUrl = System.getProperty("db.url");
        String login = System.getProperty("login");
        String password = System.getProperty("password");
        final Connection connection = DriverManager.getConnection(dbUrl, login, password);
        return connection;
    }

    public static String getPaymentId() throws SQLException {
        String payment_id = null;
        var idSQL = "SELECT payment_id FROM order_entity order by created desc limit 1;";
        try (var conn = getConnection();
             var statusStmt = conn.prepareStatement(idSQL)) {
            try (var rs = statusStmt.executeQuery()) {
                if (rs.next()) {
                    payment_id = rs.getString("payment_id");
                }
            }
        }
        return payment_id;
    }

    public static String getStatusForPayment(String paymentId) throws SQLException {
        String statusSQL = "SELECT status FROM payment_entity WHERE transaction_id =?; ";
        String status = null;
        try (var conn = getConnection();
             var statusStmt = conn.prepareStatement(statusSQL)) {
            statusStmt.setString(1, paymentId);
            try (var rs = statusStmt.executeQuery()) {
                if (rs.next()) {
                    status = rs.getString("status");
                }
            }
        }
        return status;
    }

    public static String getStatusForCredit(String paymentId) throws SQLException {
        String statusSQL = "SELECT status FROM credit_request_entity WHERE bank_id =?; ";
        String status = null;
        try (var conn = getConnection();
             var statusStmt = conn.prepareStatement(statusSQL)) {
            statusStmt.setString(1, paymentId);
            try (var rs = statusStmt.executeQuery()) {
                if (rs.next()) {
                    status = rs.getString("status");
                }
            }
        }
        return status;
    }
}