/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;
import model.Premio;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class Dados {

    private BufferedReader br = null;
    private String linha;
    private String nomeArquivo;

    public Dados(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void gravarPessoa(List<Pessoa> pessoas) {
        try {
            File file = new File(nomeArquivo);
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            JSONObject eJSON = new JSONObject();
            for (Pessoa p : pessoas) {
                eJSON.put("id", p.getId());
                eJSON.put("nome", p.getNome());
                eJSON.put("url", p.getUrl());
                bw.write(eJSON.toString() + "\n");
            }
            bw.close();
        } catch (Exception e) {

        }
    }

    public void gravarPremio(List<Premio> premios) {
        try {
            File file = new File(nomeArquivo);
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            JSONObject eJSON = new JSONObject();
            for (Premio p : premios) {
                eJSON.put("id", p.getId());
                eJSON.put("descricao", p.getDescricao());
                eJSON.put("observacao", p.getObservacao());
                bw.write(eJSON.toString() + "\n");
            }
            bw.close();
        } catch (Exception e) {

        }
    }

    public List<Pessoa> lerPessoa() {
        List<Pessoa> info = new ArrayList<>();
        Pessoa pessoaTmp;
        try {
            br = new BufferedReader(new FileReader(nomeArquivo));
            while ((linha = br.readLine()) != null) {
                JSONObject eJSON = new JSONObject(linha);
                pessoaTmp = new Pessoa();
                pessoaTmp.setId(eJSON.getInt("id"));
                pessoaTmp.setNome(eJSON.getString("nome"));
                pessoaTmp.setUrl(eJSON.getString("url"));

                info.add(pessoaTmp);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
            }
        }
        return info;
    }

    public List<Premio> lerPremio() {
        List<Premio> info = new ArrayList<>();
        Premio premioTmp;
        try {
            br = new BufferedReader(new FileReader(nomeArquivo));
            while ((linha = br.readLine()) != null) {
                JSONObject eJSON = new JSONObject(linha);
                premioTmp = new Premio();
                premioTmp.setId(eJSON.getInt("id"));
                premioTmp.setDescricao(eJSON.getString("descricao"));
                premioTmp.setObservacao(eJSON.getString("observacao"));
                info.add(premioTmp);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
            }
        }
        return info;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

}
