package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Jogo;
import model.Time;

public class PrincipalController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Time time1 = new Time("Curintia");
        Time time2 = new Time("Framenguis");
                
        Jogo jogo1 = new Jogo(time1.getNome(), "3", time2.getNome(), "2");
        System.out.println("NomeTime1: " + jogo1.getTimeA() + " GolsTimeA: " + jogo1.getGolA() + " NomeTimeB: " + jogo1.getTimeB() + " GolsTimeB: " + jogo1.getGolB());
    }    
}
