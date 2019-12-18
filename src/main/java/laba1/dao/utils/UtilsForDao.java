package laba1.dao.utils;

import laba1.model.Entity;

import java.sql.*;

public class UtilsForDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/databaseforuniversity";
    private static final String USER = "kontsevich";
    private static final String PASSWORD = "333498316";


    public static PreparedStatement getCreateStatement(String sql, String idFieldName) throws SQLException {
        return getConnection().prepareStatement(sql, new String[]{idFieldName});
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static PreparedStatement createStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    public static Integer genericDelete(Integer id, String sql) throws SQLException {
        PreparedStatement statement = createStatement(sql);
        statement.setInt(1, id);
        return statement.executeUpdate();
    }

    public static Entity saveAndExistsCheck(PreparedStatement statement, Entity entity) throws SQLException {
        if (statement.executeUpdate() > 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();

            boolean next = generatedKeys.next();

            int userId = next ? generatedKeys.getInt(1) : -1;

            if (userId != -1) {
                entity.setId(userId);
                return entity;
            }
        }
        return null;
    }
}
