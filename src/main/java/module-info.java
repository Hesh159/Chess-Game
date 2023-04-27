module com.hession.chessapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.hession.chessapp to javafx.fxml;
    exports com.hession.chessapp;
}