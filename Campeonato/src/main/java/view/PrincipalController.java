package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Dados;
import model.Jogo;
import model.Time;

public class PrincipalController implements Initializable {
    
    private Dados dados;
    private List<Time> lstPrinc = new ArrayList<Time> ();
    
    @FXML private TableView<Jogo>  tblVwCmp;
    @FXML private TableColumn<Jogo, String> tblClmnTime;
    @FXML private TableColumn<Jogo, Integer> tblClmnP, tblClmnV, tblClmnD, tblClmnE, tblClmnGP, tblClmnGC, tblClmnSD;
    
    @FXML
    private void btnImportarClick(ActionEvent event) {
        /*try {
            List<Jogo> lstJogo = new ArrayList<Jogo>();
        
            FileReader arq = new FileReader("F:\\jogo.txt");
            BufferedReader lerarq = new BufferedReader(arq);
            
            String partida[] = new String[4];            
            String linha = lerarq.readLine();
            
            partida = linha.split(",");                
            while (linha != null) {
                partida = linha.split(",");
                lstJogo.add(new Jogo(partida[0], partida[1], partida[2], partida[3]));
                linha = lerarq.readLine();                
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());            
        }
        
        for (Jogo j : lstJogo) {
            System.out.println("NomeTime1: " + j.getTimeA() + " GolsTimeA: " + j.getGolA() + " NomeTimeB: " + j.getTimeB() + " GolsTimeB: " + j.getGolB());
            //tblClmnTime.setCellValueFactory();            
        }*/
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
        dados = new Dados("G:\\jogo.txt");
        
        lstPrinc = dados.ler();        
    }    
}
