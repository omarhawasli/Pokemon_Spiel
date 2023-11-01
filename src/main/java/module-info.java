module com.example.pokemon_spiel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pokemon_spiel to javafx.fxml;
    exports com.example.pokemon_spiel;
}