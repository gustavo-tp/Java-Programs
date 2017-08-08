/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static config.Config.*;
import java.net.URL;
import java.security.Principal;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mbilo
 */
public class CRUDPessoaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private PessoaController controller;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField txtFldNome;

    @FXML
    private TextField txtFldUrl;

    @FXML
    private Button btnConfirma;

    @FXML
    private Label lbUrl;

    @FXML
    private void btnCancelaClick() {
        anchorPane.getScene().getWindow().hide();
    }

    @FXML
    private void btnConfirmaClick() {

        controller.pessoa.setNome(txtFldNome.getText());
        controller.pessoa.setUrl(txtFldUrl.getText());
        
        if (controller.acao == INCLUIR) {
            if (PrincipalController.lstPessoa.
                    indexOf(controller.pessoa) != -1) {
                txtFldUrl.requestFocus();
                lbUrl.setText("URL Media Social - deve ser única");
                return;
            }
        } else if (controller.acao == ALTERAR) {
            
        }

        switch (controller.acao) {
            case INCLUIR:
                controller.pessoa.setId(
                        PrincipalController.lstPessoa.get(
                                PrincipalController.lstPessoa.size() - 1).
                                getId() + 1);

                PrincipalController.lstPessoa.add(controller.pessoa);
                break;

            case EXCLUIR:
                PrincipalController.lstPessoa.remove(controller.pessoa);
                break;
        }

        controller.tblView.setItems(
                FXCollections.observableList(PrincipalController.lstPessoa));
        controller.tblView.refresh();
        controller.tblView.getSelectionModel().clearSelection();

        controller.tblView.getSelectionModel().select(controller.pessoa);
        anchorPane.getScene().getWindow().hide();
        PrincipalController.dadosPessoa.gravarPessoa(
                PrincipalController.lstPessoa);

    }

    public void setCadastroController(PessoaController controller) {

        this.controller = controller;
        txtFldNome.setText(controller.pessoa.getNome());
        txtFldUrl.setText(controller.pessoa.getUrl());
        txtFldNome.setDisable(controller.acao == EXCLUIR);
        txtFldUrl.setDisable(controller.acao == EXCLUIR);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
;

}
