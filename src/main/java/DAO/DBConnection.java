package DAO;

import java.sql.*;

public class DBConnection {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem:BankDB;DB_CLOSE_DELAY=-1";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static int DBInit() {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(
                    "DROP TABLE IF EXISTS CLIENTS, ACCNUMBERS, CARDNUMBERS;");

            statement.executeUpdate("create table CLIENTS " +
                    "(ID_CLIENT BIGINT auto_increment primary key, " +
                    "CLIENTNAME VARCHAR(20));");

            statement.executeUpdate("create table ACCNUMBERS " +
                    "(ID_ACCNUM BIGINT auto_increment primary key, " +
                    "ACCNUM VARCHAR(46), " +
                    "ACCBALANCE DECIMAL(15,2), " +
                    "CLIENT_ID BIGINT " +
                    "references CLIENTS (ID_CLIENT));");

            statement.executeUpdate("create table CARDNUMBERS " +
                    "(ID_CARDNUM BIGINT auto_increment primary key, " +
                    "CARDNUM VARCHAR(20), " +
                    "ACCNUM_ID BIGINT " +
                    "references ACCNUMBERS (ID_ACCNUM));");

            statement.executeUpdate("INSERT INTO CLIENTS (CLIENTNAME) VALUES ( 'Artem')," +
                    "('Igor'), ('Nikolai'), ('Vladimir'), ('Svetlana'), ('Elena'), ('Marketa'), ('Vladislav'), ('Karel');");

            statement.executeUpdate("INSERT INTO ACCNUMBERS (ACCNUM, CLIENT_ID, ACCBALANCE) VALUES " +
                    "( '1324 1234 42456 6323', 1, 0.25), ('1324 1234 42456 0976', 2, 1234.20), " +
                    "( '1324 9384 42456 2345', 3, 123456.70),( '1324 1234 42456 0348', 4, 100.00), " +
                    "( '1324 1234 42456 1252', 5, 200.00), " +
                    "( '1324 1234 42456 0357', 6, 300.00), " +
                    "( '1324 1234 42456 1234', 7, 3000000.00), " +
                    "( '1324 1234 42456 5322', 8, 23456.00), " +
                    "( '1324 1234 42456 1234', 9, 23456.80);");

            statement.executeUpdate("INSERT INTO CARDNUMBERS (CARDNUM, ACCNUM_ID) " +
                    "VALUES ( '4278 1242 2341 6323', 1), ('4278 1242 2341 0976', 2), " +
                    "( '4278 1242 2341 2345', 3),( '4278 1242 2341 0348', 4), " +
                    "( '4278 1242 2341 1252', 5), " +
                    "( '4278 1242 2341 0357', 6), " +
                    "( '4278 1242 2341 1234', 7), " +
                    "( '4278 1242 2341 5322', 8), " +
                    "( '4278 1242 2341 1234', 9);");

            return 0;

        }catch (SQLException e){
            e.printStackTrace();
            return 1;
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}