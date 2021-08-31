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
public class CadastrarProduto {
    
    private int idProduto;
    private int quantidadeProduto;
    private String nomeProduto;
    private String unidadeMedida;
    private String dataCadastroProduto;
    
    private String pesquisa;
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

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
     * @return the quantidadeProduto
     */
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the unidadeMedida
     */
    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     * @param unidadeMedida the unidadeMedida to set
     */
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    /**
     * @return the dataCadastroProduto
     */
    public String getDataCadastroProduto() {
        return dataCadastroProduto;
    }

    /**
     * @param dataCadastroProduto the dataCadastroProduto to set
     */
    public void setDataCadastroProduto(String dataCadastroProduto) {
        this.dataCadastroProduto = dataCadastroProduto;
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
    
    
    
    public void  excluirProduto(CadastrarProduto cp){
        String sql = "DELETE FROM CadastrarProduto WHERE idProduto = ?";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cp.getIdProduto());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto. ERRO: "+ e);
        }
    }
    
    public void editarProduto(CadastrarProduto cp){
        String sql = "UPDATE CadastrarProduto"
                +" SET nomeProduto = ?, quantidadeProduto = ?, unidadeMedida = ?"
                +" WHERE idProduto = ?";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cp.getNomeProduto());
            pstm.setInt(2, cp.getQuantidadeProduto());
            pstm.setString(3, cp.getUnidadeMedida());
            pstm.setInt(4, cp.getIdProduto());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Dados editado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto. EROO: " +e);
        }
    }
    
    public CadastrarProduto buscarProoduto(CadastrarProduto cp){
        String sql = "SELECT * FROM CadastrarProduto WHERE nomeProduto LIKE '%"+ cp.getPesquisa() +"%'";
        conn = new ConexaoBD().getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();
            cp.setIdProduto(rs.getInt("idProduto"));
            cp.setNomeProduto(rs.getString("nomeProduto"));
            cp.setQuantidadeProduto(rs.getInt("quantidadeProduto"));
            cp.setUnidadeMedida(rs.getString("unidadeMedida"));                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produto. ERRO: " +e);
        }
        return cp;    
    }   
    
    public void inserirProduto(CadastrarProduto cp){
        String sql = "INSERT INTO CadastrarProduto(nomeProduto, quantidadeProduto, unidadeMedida) VALUES(?, ?, ?)";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cp.getNomeProduto());
            pstm.setInt(2, cp.getQuantidadeProduto());
            pstm.setString(3, cp.getUnidadeMedida());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Dados cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto. ERRO: " + e);
        }
    }

    
}
