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
public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String senhaUsuario;
    private String dataCadastroUsuario;
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the senhaUsuario
     */
    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    /**
     * @param senhaUsuario the senhaUsuario to set
     */
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    /**
     * @return the dataCadastroUsuario
     */
    public String getDataCadastroUsuario() {
        return dataCadastroUsuario;
    }

    /**
     * @param dataCadastroUsuario the dataCadastroUsuario to set
     */
    public void setDataCadastroUsuario(String dataCadastroUsuario) {
        this.dataCadastroUsuario = dataCadastroUsuario;
    }
    
    public void buscarTodos(){
        String sql = "SELECT * FROM Usuario ORDER BY nomeUsuario";
        conn = new ConexaoBD().getConnection();
        
        
    }
    
    public void cadastrarUsuario(Usuario user){
        String sql = "INSERT INTO Usuario(nomeUsuario,senhaUsuario) VALUES(?, ?)";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getNomeUsuario());
            pstm.setString(2, user.getSenhaUsuario());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Dados cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário! " + e);
        }  
        
    }
    
    public boolean verificarLogin(String login, String senha){
        boolean aut = false;
        String sql = "SELECT nomeUsuario, senhaUsuario FROM Usuario WHERE nomeUsuario = ? AND senhaUsuario = ?";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, login);
            pstm.setString(2, senha);
            
            rs = pstm.executeQuery();     
            
            if(rs.next()){
                String loginB = rs.getString("nomeUsuario");
                String senhaB = rs.getString("senhaUsuario");
                
                aut = true;
            }
            
            pstm.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na verificação do usuário: "+e);
        }
        
        return aut;
    }
            
}
