/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static config.Config.ALTERAR;
import static config.Config.EXCLUIR;
import static config.Config.INCLUIR;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import model.Pessoa;
import org.json.JSONArray;
import org.json.JSONObject;
import utilit.NossoPopOver;
import static view.PrincipalController.lstPessoa;

/**
 * FXML Controller class
 *
 * @author idomar
 */
public class PessoaController implements Initializable {

    public char acao;
    public Pessoa pessoa;

    @FXML
    public TableView<Pessoa> tblView;

    @FXML
    private MaterialDesignIconView btnIncluir;
    @FXML
    private MaterialDesignIconView btnAlterar;
    @FXML
    private MaterialDesignIconView btnDeletar;

    @FXML
    private MaterialDesignIconView btnBloquear;

    @FXML
    private MenuItem menuAlterar;

    @FXML
    private MenuItem menuDeletar;

    @FXML
    private MenuItem menuBloquear;

    @FXML
    private HBox hBxProgresso;

    @FXML
    private Label lbTempo;

    @FXML
    private void acIncluir() {
        acao = INCLUIR;
        pessoa = new Pessoa();
        showCRUD();
    }
    
    @FXML
    private void acExcluir() {
        acao = EXCLUIR;
        pessoa = tblView.getSelectionModel().getSelectedItem();
        showCRUD();
    }
    
    @FXML
    private void acAlterar() {
        acao = ALTERAR;
        pessoa = tblView.getSelectionModel().getSelectedItem();
        showCRUD();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Platform.runLater(() -> {
            tblView.setItems(FXCollections.observableList(lstPessoa));
            tblView.requestFocus();
            tblView.getSelectionModel().selectFirst();
        });

    }

    private void showCRUD() {
        String scena = "/fxml/CRUDPessoa.fxml";
        NossoPopOver popOver = null;
        switch (acao) {
            case INCLUIR:
                popOver = new NossoPopOver(scena, 
                                "Incluir Pessoa", null);
                break;
            case ALTERAR:
                popOver = new NossoPopOver(scena, 
                                "Alterar Pessoa", null);
                break;
            case EXCLUIR:
                popOver = new NossoPopOver(scena, 
                                "Excluir Pessoa", null);
                break;
        }
        CRUDPessoaController controller = 
                      popOver.getLoader().getController();
        controller.setCadastroController(this);
    }

}
