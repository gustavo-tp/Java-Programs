package view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Jogo;
import model.Time;
import utilit.Dados;

public class PrincipalController implements Initializable {

    // @FXML
    private Dados dados;
    private List<Time> lstPrinc = new ArrayList<Time>();

    @FXML
    public TableView<Time> tblVwTimes;

    @FXML
    private void btnImportaClick() {
        final Stage stage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escolha o seu arquivo Txt");
        fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.setInitialFileName("C:\\dados\\resultado.txt");

        dados = new Dados(String.valueOf(fileChooser.showOpenDialog(stage)));
        lstPrinc = dados.ler();

        tblVwTimes.setItems(FXCollections.observableList(lstPrinc));

    }
    
    @FXML
    private void btnSairClick() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        //dados = new Dados("G:\\jogo.txt");

        //lstPrinc = dados.ler();
        //tblVwTimes.setItems(FXCollections.observableList(lstPrinc)); 
    }
}
