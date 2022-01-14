package ua.ithillel;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection got");
            Statement stmt = con.createStatement();
            String sql = "SELECT id, name as qwerty, salary FROM employee ORDER BY name";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                        rs.getLong("id") + "\t" +
                                rs.getString(2) + "\t" +
                                rs.getInt("salary") + "\t"
//                                rs.getLong("department_id") + "\t" +
//                                rs.getLong("chief_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
