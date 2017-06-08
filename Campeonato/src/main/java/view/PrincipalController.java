package view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Jogo;
import model.Time;
import utilit.Dados;

public class PrincipalController implements Initializable {

    // @FXML
    private Dados dados;
    private List<Time> lstPrinc = new ArrayList<Time>();
    private List<Jogo> listaTemp = new ArrayList<Jogo>();

    @FXML
    public TableView<Time> tblVwTimes;
    
    @FXML
    public TableView<Jogo> tblVwJogos;
    
    @FXML
    public Label lbNomeTime;
    
    @FXML
    public StackPane pnJogos;

    @FXML
    public RadioButton rdBtnDefalt;
    
    public Time timeSel;
    
    @FXML
    private void btnFecharClick() {
        pnJogos.setVisible(false);
        tblVwTimes.requestFocus();
    }   
    
    @FXML
    public void tblVwClick(Event event) {
        MouseEvent me = null;
        if (event.getEventType() == MOUSE_CLICKED) {
            me = (MouseEvent) event;
            if (me.getClickCount() == 2) {
                pnJogos.setVisible(true);
                timeSel = tblVwTimes.getSelectionModel().getSelectedItem();
                lbNomeTime.setText(timeSel.getNome());
                
                tblVwJogos.setItems(FXCollections.observableList(timeSel.getJogos()));
            }
        }       
        
    }
    
    @FXML
    public void btnFecharJogo() {
        pnJogos.setVisible(false);
        rdBtnDefalt.setSelected(true);
    }
    
    @FXML
    public void rdBtnTodos() {
        tblVwJogos.setItems(FXCollections.observableList(timeSel.getJogos()));
    }
    
    @FXML
    public void rdBtnVit() {
        listaTemp.clear();
        for (Jogo j : timeSel.getJogos()) {
            if (j.timeA.equals(timeSel.getNome())) {
                if(j.golA > j.getGolB())
                    listaTemp.add(j);
            } else 
                if(j.golA < j.getGolB())
                    listaTemp.add(j);
        }
        tblVwJogos.setItems(FXCollections.observableList(listaTemp));
    }
    
    @FXML
    public void rdBtnEmp() {
        listaTemp.clear();
        for (Jogo j : timeSel.getJogos()) {
            if(j.golA == j.getGolB())
                listaTemp.add(j);
        }
        tblVwJogos.setItems(FXCollections.observableList(listaTemp));
    }
    
    @FXML
    public void rdBtnDer() {
        listaTemp.clear();
        for (Jogo j : timeSel.getJogos()) {
            if (j.timeA.equals(timeSel.getNome())) {
                if(j.golA < j.getGolB())
                    listaTemp.add(j);
            } else
                if(j.golA > j.getGolB())
                    listaTemp.add(j);
        }
        tblVwJogos.setItems(FXCollections.observableList(listaTemp));
    }    

    @FXML
    private void btnAbrirClick() {
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
        pnJogos.setVisible(false);
    }
}
