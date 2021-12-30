package ru.ssau.tk.stockexchange;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

import static ru.ssau.tk.stockexchange.DatabaseHandler.getDbConnection;


public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buyButton;

    @FXML
    private Button sellButton;

    @FXML
    private TableColumn<StocksPortfolio, Integer> buyPrice;

    @FXML
    private TableColumn<Stocks, String> name;

    @FXML
    private TextField nameField;

    @FXML
    private TextField numField;

    @FXML
    private TableColumn<StocksPortfolio, Integer> number;

    @FXML
    private TableColumn<StocksPortfolio, Integer> priceChange;

    @FXML
    private TableColumn<Stocks, String> TableStocksId;

    @FXML
    private TableColumn<Stocks, Integer> priceNow;

    @FXML
    private TableColumn<StocksPortfolio, String > stockName;

    @FXML
    private TableView<StocksPortfolio> stocksPortfolio;

    @FXML
    private TableView<Stocks> TableStocks;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ObservableList<Stocks> observableListt = Example.getList();

            /*DatabaseHandler handler = new DatabaseHandler();
            Stocks stocks = new Stocks();

            ResultSet rs = handler.getStocks();


            while (rs.next()) {
                observableList.add(new Stocks(rs.getString("Id"), rs.getString("Name"), rs.getString("PriceNow")));
            }*/
            TableStocksId.setCellValueFactory(new PropertyValueFactory<>("Id"));
            name.setCellValueFactory(new PropertyValueFactory< >("Name"));
            priceNow.setCellValueFactory(new PropertyValueFactory<>("PriceNow"));
            ObservableList<Stocks> observableList = DatabaseHandler.getStocks();
            TableStocks.setItems(observableListt);




        buyButton.setOnAction(event ->{

            String nameText = nameField.getText().trim();
            String numberText = numField.getText().trim();

            if(!nameText.equals("") && !number.equals("")) {
                try {
                   Add_stock(nameText, Integer.valueOf(numberText));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else System.out.println("Error");
            ObservableList<StocksPortfolio> observableList3 = Example.getList2();
            stockName.setCellValueFactory(new PropertyValueFactory<>("stockName"));
            buyPrice.setCellValueFactory(new PropertyValueFactory< >("BuyPrice"));
            number.setCellValueFactory(new PropertyValueFactory<>("number"));
            priceChange.setCellValueFactory(new PropertyValueFactory<>("PriceChange"));
            ObservableList<StocksPortfolio> observableList1 = (ObservableList<StocksPortfolio>) DatabaseHandler.getStocksPortfolio();
            stocksPortfolio.setItems(observableList1);

        });

        sellButton.setOnAction(event ->{

            String nameText = nameField.getText().trim();
            String numberText = numField.getText().trim();

            if(!nameText.equals("") && !number.equals("")) {
                try {
                    Delete_stock(nameText, Integer.valueOf(numberText));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else System.out.println("Error");
            ObservableList<StocksPortfolio> observableList3 = Example.getList2();
            stockName.setCellValueFactory(new PropertyValueFactory<>("stockName"));
            buyPrice.setCellValueFactory(new PropertyValueFactory< >("BuyPrice"));
            number.setCellValueFactory(new PropertyValueFactory<>("number"));
            priceChange.setCellValueFactory(new PropertyValueFactory<>("PriceChange"));
            ObservableList<StocksPortfolio> observableList1 = (ObservableList<StocksPortfolio>) DatabaseHandler.getStocksPortfolio();
            stocksPortfolio.setItems(observableList1);

        });
    }


    public void Add_stock (String nameText, Integer numberText) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        String sql = "INSERT INTO stocks_portfolio (idstocks_portfolio,stockName,buyPrice,number,priceChange) values (?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(1));
            pst.setString(2, nameText);
            pst.setString(3, String.valueOf(166));
            pst.setString(4, String.valueOf(numberText));
            pst.setString(5, String.valueOf(2));
            pst.execute();

            JOptionPane.showMessageDialog(null, "Stock Add succes");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Delete_stock (String nameText, Integer numberText) throws SQLException, ClassNotFoundException {
        Connection conn1 = getDbConnection();
        String sql = "DELETE FROM stocks_portfolio WHERE stockName=? ";
        try {
            PreparedStatement pst = conn1.prepareStatement(sql);
            pst.setString(1, nameText);
            //pst.setString(2, String.valueOf(numberText));
            pst.execute();

            JOptionPane.showMessageDialog(null, "Stock delete succes");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
  

    }



