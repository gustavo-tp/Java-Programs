package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Pessoa;
import model.Premio;
import utilit.Dados;

public class PrincipalController implements Initializable {

    /* 
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
     */

    public static List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
    public static List<Pessoa> lstPremiados = new ArrayList<Pessoa>();
    public static List<Pessoa> lstBloqueados = new ArrayList<Pessoa>();
    public static List<Premio> lstPremio = new ArrayList<Premio>();
    
    
    public static Dados dadosPessoa = new Dados(System.getProperty("user.home") + "/pessoa.json");
    public static Dados dadosBloqueado = new Dados(System.getProperty("user.home") + "/filtro.json");
    public static Dados dadosPremio = new Dados(System.getProperty("user.home") + "/premio.json");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        lstPessoa     = dadosPessoa.lerPessoa();
        lstBloqueados = dadosBloqueado.lerPessoa();
        lstPremio     = dadosPremio.lerPremio();
        
        
    }
}
