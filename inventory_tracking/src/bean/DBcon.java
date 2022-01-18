package bean;

import java.sql.*;

public class DBcon {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    private static final String DATABASE_URL =
            "jdbc:mysql://localhost:3306/inventory?useUnicode=true&characterEncoding=utf-8";

    private static final String DATABASE_USRE = "root";

    private static final String DATABASE_PASSWORD = "980416";
    public static Connection getConnction() {
        Connection dbConnection = null;
        try {
            Class.forName(DRIVER_CLASS);
            dbConnection = DriverManager.getConnection(DATABASE_URL,
                    DATABASE_USRE, DATABASE_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dbConnection;
    }
    public static void closeConnection(Connection dbConnection) {
        try {
            if (dbConnection != null && (!dbConnection.isClosed())) {
                dbConnection.close();
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }


    public static void closeResultSet(ResultSet res) {
        try {
            if (res != null) {
                res.close();
                res = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(PreparedStatement pStatement) {
        try {
            if (pStatement != null) {
                pStatement.close();
                pStatement = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}