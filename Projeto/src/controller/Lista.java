/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ConexaoBD;

/**
 *
 * @author julio
 */
public class Lista {
    private int idLista;
    private String nomeLista;
    
    private String pesquisa;

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    /**
     * @return the idLista
     */
    public int getIdLista() {
        return idLista;
    }

    /**
     * @param idLista the idLista to set
     */
    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    /**
     * @return the nomeLista
     */
    public String getNomeLista() {
        return nomeLista;
    }

    /**
     * @param nomeLista the nomeLista to set
     */
    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }
    
    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    public Lista buscarLista(Lista lst){
        String sql = "SELECT * FROM Lista WHERE nomeLista LIKE '%"+ lst.getPesquisa() +"%'";
        conn = new ConexaoBD().getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();
            lst.setIdLista(rs.getInt("idLista"));
            lst.setNomeLista(rs.getString("nomeLista"));            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar listas! ERRO: " +e);
        }
        return lst;
    }
    
    public void criarLista(Lista lst){
        String sql = "INSERT INTO Lista(nomeLista) VALUES(?)";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, lst.getNomeLista());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Lista criada com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar lista. ERRO: " +e);
        }        
    }
    
    public void excluirLista(Lista lst){
        String sql = "DELETE FROM Lista WHERE idLista = ?";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, lst.getIdLista());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Lista excluida com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir lista. ERRO: " +e);
        }
    }
    
    public void editarLista(Lista lst){
        String sql = "UPDATE Lista SET nomeLista = ? WHERE idLista = ?";
        conn = new ConexaoBD().getConnection();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, lst.getNomeLista());
            pstm.setInt(2, lst.getIdLista());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null,"Lista editada com sucesso!");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao editar lista. ERRO: "+e);
        }
    }    
}
