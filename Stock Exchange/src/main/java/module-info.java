module ru.ssau.tk.stockexchange {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.desktop;


    opens ru.ssau.tk.stockexchange to javafx.fxml;
    exports ru.ssau.tk.stockexchange;
}