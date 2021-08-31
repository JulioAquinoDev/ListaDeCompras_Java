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
public class Produto {
    private int idProduto;
    private String idUsuario;
    private String idLista;
    private String idProdutoCadastrado;
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    int codUsuario;
    int codProduto;
    int codLista;
    
    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idLista
     */
    public String getIdLista() {
        return idLista;
    }

    /**
     * @param idLista the idLista to set
     */
    public void setIdLista(String idLista) {
        this.idLista = idLista;
    }

    /**
     * @return the idProdutoCadastrado
     */
    public String getIdProdutoCadastrado() {
        return idProdutoCadastrado;
    }

    /**
     * @param idProdutoCadastrado the idProdutoCadastrado to set
     */
    public void setIdProdutoCadastrado(String idProdutoCadastrado) {
        this.idProdutoCadastrado = idProdutoCadastrado;
    }
    
    public void buscarCodLista(String nome){
        String sql = "SELECT * FROM Lista WHERE nomeLista = '"+ nome +"'";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();
            codLista = rs.getInt("idLista");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ID da Lista. ERRO: " +e);
        }
    }
            
    public void buscarCodUsuario(String nome){
        String sql = "SELECT * FROM Usuario WHERE nomeUsuario = '"+nome+"'";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();
            codUsuario = rs.getInt("idUsuario");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ID do usuário." +e);
        }
    }
    
    public void buscarCodProduto(String nome){
        String sql = "SELECT * FROM CadastrarProduto WHERE nomeProduto = '"+nome+"'";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();
            codProduto = rs.getInt("idProduto");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ID doproduto." +e);
        }
    }
    
    public void inserirProduto(Produto lst){
        String sql = "INSERT INTO Produto(idLista, idUsuario, idProdutoCadastrado) VALUES(?, ?, ?)";
        buscarCodLista(lst.getIdLista());
        buscarCodUsuario(lst.getIdUsuario());
        buscarCodProduto(lst.getIdProdutoCadastrado());
        conn = new ConexaoBD().getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codLista);
            pstm.setInt(2, codUsuario);
            pstm.setInt(3, codProduto);
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Lista. ERRO: " +e);
        }
    }
    
    public void editarProduto(Produto p){
        String sql = "UPDATE Produto"
                +" SET idProdutoCadastrado = ?, idLista = ?, idUsuario = ?"
                +" WHERE idProduto = ?";
        buscarCodLista(p.getIdLista());
        buscarCodUsuario(p.getIdUsuario());
        buscarCodProduto(p.getIdProdutoCadastrado());
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codProduto);
            pstm.setInt(2, codLista);
            pstm.setInt(3, codUsuario);
            pstm.setInt(4, p.getIdProduto());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Dados editado da lista com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto da lista. EROO: " +e);
        }
    }
    
    public void excluirProduto(Produto p){
        String sql = "DELETE FROM Produto WHERE idProduto = ?";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, p.getIdProduto());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Produto excluido da lista com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto da lista. ERRO: "+ e);
        }
    }    
}
