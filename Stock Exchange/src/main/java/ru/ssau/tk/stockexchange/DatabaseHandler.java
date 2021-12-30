package ru.ssau.tk.stockexchange;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.ssau.tk.stockexchange.Const.*;

public class DatabaseHandler extends Configs {

    static Connection dbConnection;
    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName + "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    // Метод добавления новых пользователей в таблицу
    public  void signUpUser(User user){

        String insert = "INSERT INTO " + USER_TABLE + "(" +
                USERS_FIRSTNAME + "," + USERS_LASTNAME + "," +
                USERS_USERNAME +  "," + USERS_PASSWORD + ")" +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Метод получения данных пользователя из таблицы
    public ResultSet getUser(User user){

        ResultSet resultSet = null;

        String select = "SELECT * FROM users WHERE username=? AND password=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public static ObservableList<Stocks> getStocks(){

        ObservableList<Stocks> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = getDbConnection().prepareStatement("select * from stocks");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Stocks(Integer.parseInt(rs.getString("Id")), rs.getString("Name"), Integer.parseInt(rs.getString("PriceNow"))));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static List<StocksPortfolio> getStocksPortfolio(){

        ObservableList<StocksPortfolio> list1 = FXCollections.observableArrayList();
        try {
            PreparedStatement ps1 = getDbConnection().prepareStatement("select * from stocks_portfolio");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()){
                list1.add(new StocksPortfolio(rs1.getString("stockName"),Integer.parseInt(rs1.getString("buyPrice")), Integer.parseInt(rs1.getString("number")), Integer.parseInt(rs1.getString("PriceChange"))));
            }
        } catch (Exception e) {
        }
        return list1;
    }
}


