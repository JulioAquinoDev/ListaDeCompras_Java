package views;

import controller.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;
import model.ConexaoBD;
import model.Tabela;

public class TelaAdicionarProduto extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    String cmplSQL = "select p.idProduto, u.nomeUsuario, l.nomeLista,"+
        " cp.nomeProduto, cp.unidadeMedida, cp.quantidadeProduto" +
        " from Produto p" +
        " inner join Usuario u" +
        " on p.idUsuario = u.idUsuario" +
        " inner join Lista l" +
        " on p.idLista = l.idLista" +
        " inner join CadastrarProduto cp" +
        " on p.idProdutoCadastrado = cp.idProduto";
    
    public TelaAdicionarProduto() {
        initComponents();      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        cmbUsuario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbProduto = new javax.swing.JComboBox<>();
        cmbLista = new javax.swing.JComboBox<>();
        btnAtualizarTabela = new javax.swing.JButton();
        cmbLista2 = new javax.swing.JComboBox<>();

        btnNovo5.setText("Pesquisar");
        btnNovo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovo5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Adicionar Produto na Lista");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtID.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lista");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);

        cmbUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Usuario");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Produto");

        cmbProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        cmbLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cmbLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbListaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbListaMousePressed(evt);
            }
        });
        cmbLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaActionPerformed(evt);
            }
        });

        btnAtualizarTabela.setText("Atualizar Tabela");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });

        cmbLista2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbLista2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAtualizarTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbUsuario, javax.swing.GroupLayout.Alignment.TRAILING, 0, 338, Short.MAX_VALUE)
                            .addComponent(cmbProduto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addComponent(cmbLista, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnAtualizarTabela)
                    .addComponent(cmbLista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        txtID.setEditable(false);
        preencherComboProduto();
        preencherComboUsuario();
        preencherComboLista();
        preencherTabela(cmplSQL);
    }//GEN-LAST:event_formWindowOpened
    
    public void preencherComboProduto(){
        String sql = "SELECT * FROM CadastrarProduto ORDER BY nomeProduto";
        conn = new ConexaoBD().getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();            
            cmbProduto.removeAllItems();
            do{
                cmbProduto.addItem(rs.getString("nomeProduto"));
            }while(rs.next());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher produtos no combo. ERRO: " +e);
        }
    }
    
    public void preencherComboUsuario(){
        String sql = "SELECT * FROM Usuario ORDER BY nomeUsuario";
        conn = new ConexaoBD().getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();            
            cmbUsuario.removeAllItems();
            do{
                cmbUsuario.addItem(rs.getString("nomeUsuario"));
            }while(rs.next());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher usuários no combo. ERRO: " +e);
        }
    }
    
    public void preencherComboLista(){
        String sql = "SELECT * FROM Lista ORDER BY nomeLista";
        conn = new ConexaoBD().getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();            
            cmbLista.removeAllItems();
            cmbLista2.removeAllItems();
            do{
                cmbLista.addItem(rs.getString("nomeLista"));
                cmbLista2.addItem(rs.getString("nomeLista"));
            }while(rs.next());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher listas no combo. ERRO: " +e);
        }
    }
        
    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Usuário", "Lista", "Produto", "Un./Med.", "QTD"};
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.first();            
            do{
                dados.add(new Object[]{rs.getInt("idProduto"), rs.getString("nomeUsuario"), 
                    rs.getString("nomeLista"), rs.getString("nomeProduto"), 
                    rs.getString("unidadeMedida"), rs.getInt("quantidadeProduto")});
            }while(rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela. ERRO: " +e);
        }
        
        Tabela tbl = new Tabela(dados, Colunas);
        tblProduto.setModel(tbl);
        
        TableRowSorter sorter = new TableRowSorter(tbl);
        tblProduto.setRowSorter(sorter);
        
        tblProduto.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblProduto.getColumnModel().getColumn(0).setResizable(false);
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(97);
        tblProduto.getColumnModel().getColumn(1).setResizable(false);
        tblProduto.getColumnModel().getColumn(2).setPreferredWidth(98);
        tblProduto.getColumnModel().getColumn(2).setResizable(false);
        tblProduto.getColumnModel().getColumn(3).setPreferredWidth(123);
        tblProduto.getColumnModel().getColumn(3).setResizable(false);
        tblProduto.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblProduto.getColumnModel().getColumn(4).setResizable(false);
        tblProduto.getColumnModel().getColumn(5).setPreferredWidth(55);
        tblProduto.getColumnModel().getColumn(5).setResizable(false);
        tblProduto.getTableHeader().setReorderingAllowed(false);
        tblProduto.setAutoResizeMode(tblProduto.AUTO_RESIZE_OFF);
        tblProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(true);
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String lista = (String) cmbLista.getSelectedItem();
        String user = (String) cmbUsuario.getSelectedItem();
        String produto = (String) cmbProduto.getSelectedItem();
        
        Produto lst = new Produto();
        lst.setIdLista(lista);
        lst.setIdUsuario(user);
        lst.setIdProdutoCadastrado(produto);
        lst.inserirProduto(lst);
        
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        preencherTabela(cmplSQL);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String id = txtID.getText();
        String lista = (String) cmbLista.getSelectedItem();
        String user = (String) cmbUsuario.getSelectedItem();
        String produto = (String) cmbProduto.getSelectedItem();
        
        if(id.isEmpty() || lista.isEmpty() || user.isEmpty() || produto.isEmpty()){
            JOptionPane.showMessageDialog(null, "Busque e selecione o produto para editar.");
        }else{
            Produto p = new Produto();
            p.setIdProduto(Integer.parseInt(id));
            p.setIdLista(lista);
            p.setIdUsuario(user);
            p.setIdProdutoCadastrado(produto);
            p.editarProduto(p);
                    
            btnNovo.setEnabled(true);
            btnSalvar.setEnabled(false);
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnCancelar.setEnabled(false);
            
            txtID.setText("");

            preencherTabela(cmplSQL);
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String id = txtID.getText();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null, "Busque e selecione um produto.");
        }else{
            Produto p = new Produto();
            p.setIdProduto(Integer.parseInt(id));
            p.excluirProduto(p);
            
            txtID.setEnabled(false);
        
            btnNovo.setEnabled(true);
            btnSalvar.setEnabled(false);
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnCancelar.setEnabled(false);
            
            txtID.setText("");

            preencherTabela(cmplSQL);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtID.setEnabled(false);
        
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        preencherTabela(cmplSQL);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovo5ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnNovo5ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new TelaPrincipal().setVisible(true);
        dispose();        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cmbListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbListaMouseClicked
    }//GEN-LAST:event_cmbListaMouseClicked

    private void cmbListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaActionPerformed
    }//GEN-LAST:event_cmbListaActionPerformed

    private void cmbListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbListaMousePressed
    }//GEN-LAST:event_cmbListaMousePressed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        String lista = (String) cmbLista2.getSelectedItem();
        
        preencherTabela("select p.idProduto, u.nomeUsuario, l.nomeLista, cp.nomeProduto, cp.unidadeMedida, cp.quantidadeProduto" +
        " from Produto p" +
        " inner join Usuario u" +
        " on p.idUsuario = u.idUsuario" +
        " inner join Lista l" +
        " on p.idLista = l.idLista" +
        " inner join CadastrarProduto cp" +
        " on p.idProdutoCadastrado = cp.idProduto"+
        " where l.nomeLista = '"+ lista +"'");
        
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        // TODO add your handling code here:
        String id = ""+ tblProduto.getValueAt(tblProduto.getSelectedRow(), 0);
        String usuario = ""+ tblProduto.getValueAt(tblProduto.getSelectedRow(), 1);
        String lista = ""+ tblProduto.getValueAt(tblProduto.getSelectedRow(), 2);
        String produto = ""+ tblProduto.getValueAt(tblProduto.getSelectedRow(), 3);
        
        txtID.setText(id);
        cmbUsuario.setSelectedItem(usuario);
        cmbLista.setSelectedItem(lista);
        cmbProduto.setSelectedItem(produto);
        
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(true);
        
        txtID.setEnabled(true);      
        
    }//GEN-LAST:event_tblProdutoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnNovo5;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbLista;
    private javax.swing.JComboBox<String> cmbLista2;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JComboBox<String> cmbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
