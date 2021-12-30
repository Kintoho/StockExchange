package ru.ssau.tk.stockexchange;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Example {
    public static ObservableList<Stocks> getList() {
        return list;
    }

    static ObservableList<Stocks> list = FXCollections.observableArrayList(
            new Stocks(1, "BYND", 66 ),
            new Stocks(2, "BABA", 114),
            new Stocks(3, "SPCE", 14),
            new Stocks(4, "NET", 130),
            new Stocks(5, "NLMK", 3)
    );

    static ObservableList<StocksPortfolio> list2 = FXCollections.observableArrayList(
            new StocksPortfolio( "BYND",66, 3, 1 )
            //new StocksPortfolio( "BABA", 114, 5, 0)
           // new StocksPortfolio("SPCE", 14, 3, 0),
           // new StocksPortfolio( "NET", 130, 1, 0),
           // new StocksPortfolio( "NLMK", 3, 2, 0)
    );

    public static ObservableList<StocksPortfolio> getList2() {
        return list2;
    }
}
