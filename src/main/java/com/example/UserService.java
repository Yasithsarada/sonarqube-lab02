package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db",
                "root", password);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE name = ?")) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // process result if needed
                }
            }
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        System.out.println("I am never called");
    }

    // EVEN WORSE: another SQL injection
    public void deleteUser(String username) throws java.sql.SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db",
            "root", password);
             PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {

            ps.setString(1, username);
            ps.executeUpdate();
        }
    }
}
