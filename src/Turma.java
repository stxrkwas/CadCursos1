
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Malu Passo Silva
 */
import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.SQLException;

public class Turma extends javax.swing.JFrame {

    Conexao con_cliente;
    
    public Turma() {
        
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executaSQL("select * from turma order by IdTurma"); 
        
        initComponents();
        
        turma.setAutoCreateRowSorter(true);
        preencherTabela();
        posicionarRegistro();
    }
    
    public void preencherTabela(){
        
        turma.getColumnModel().getColumn(0).setPreferredWidth(70);
        turma.getColumnModel().getColumn(1).setPreferredWidth(70);
        turma.getColumnModel().getColumn(2).setPreferredWidth(70);
        turma.getColumnModel().getColumn(3).setPreferredWidth(70);
        
        DefaultTableModel modelo = (DefaultTableModel) turma.getModel();
        modelo.setNumRows(0);
        
        try{
            
            con_cliente.resultset.beforeFirst();
            
            while(con_cliente.resultset.next()){
                
                modelo.addRow(new Object[]{
                    
                    con_cliente.resultset.getString("IdTurma"), con_cliente.resultset.getString("QtdAlunos"), con_cliente.resultset.getString("IdProfessor"),
                    con_cliente.resultset.getString("IdAluno"), con_cliente.resultset.getString("IdCurso")
                        
                });
                       
            }
              
        }
          
        catch(SQLException erro){
                
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n" + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);    
                
        }   
            
    }
    
    public void posicionarRegistro(){
        
        try{
            
            con_cliente.resultset.first();
            mostrar_Dados();
            
        }
        
        catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void mostrar_Dados(){
        
        try{
            
            txtCod.setText(con_cliente.resultset.getString("IdTurma"));
            txtQtd.setText(con_cliente.resultset.getString("QtdAlunos"));
            txtProf.setText(con_cliente.resultset.getString("IdProfessor"));
            txtAl.setText(con_cliente.resultset.getString("IdAluno"));
            txtCurso.setText(con_cliente.resultset.getString("IdCurso"));
            
        }
        
        catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Não localizou dados: "+erro, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        back_btn = new javax.swing.JLabel();
        title_lbl = new javax.swing.JLabel();
        img_lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        qtd_lbl = new javax.swing.JLabel();
        idprof_lbl = new javax.swing.JLabel();
        id_alunolbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        turma = new javax.swing.JTable();
        txtCod = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();
        txtProf = new javax.swing.JTextField();
        txtAl = new javax.swing.JTextField();
        txtCurso = new javax.swing.JTextField();
        PrimeiroRegistro = new javax.swing.JLabel();
        VoltarUmRegistro = new javax.swing.JLabel();
        ProximoRegistro = new javax.swing.JLabel();
        UltimoRegistro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        back_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fasticon-Essential-Toolbar-Undo.32.png"))); // NOI18N
        back_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_btnMouseClicked(evt);
            }
        });

        title_lbl.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        title_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_lbl.setText("Turma");

        img_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chalkboard.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel1.setText("Código:");

        qtd_lbl.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        qtd_lbl.setText("Quantidade de alunos:");

        idprof_lbl.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        idprof_lbl.setText("ID do professor:");

        id_alunolbl.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        id_alunolbl.setText("ID do aluno:");

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel2.setText("ID do curso:");

        turma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Qtd. de alunos", "ID do professor", "ID do aluno", "ID do curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(turma);
        if (turma.getColumnModel().getColumnCount() > 0) {
            turma.getColumnModel().getColumn(0).setResizable(false);
            turma.getColumnModel().getColumn(1).setResizable(false);
            turma.getColumnModel().getColumn(2).setResizable(false);
            turma.getColumnModel().getColumn(3).setResizable(false);
            turma.getColumnModel().getColumn(4).setResizable(false);
        }

        txtCod.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        txtQtd.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        txtProf.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        txtAl.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        txtCurso.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        PrimeiroRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Player-rew.48.png"))); // NOI18N
        PrimeiroRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrimeiroRegistroMouseClicked(evt);
            }
        });

        VoltarUmRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VoltarUmRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Player-back.48.png"))); // NOI18N
        VoltarUmRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoltarUmRegistroMouseClicked(evt);
            }
        });

        ProximoRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProximoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Player-fordward.48.png"))); // NOI18N
        ProximoRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProximoRegistroMouseClicked(evt);
            }
        });

        UltimoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Player-ff.48.png"))); // NOI18N
        UltimoRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UltimoRegistroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(img_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(qtd_lbl)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtQtd))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(idprof_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtProf))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(id_alunolbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtAl)
                                                    .addComponent(txtCurso)))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(PrimeiroRegistro)
                                        .addGap(18, 18, 18)
                                        .addComponent(VoltarUmRegistro)
                                        .addGap(18, 18, 18)
                                        .addComponent(ProximoRegistro)
                                        .addGap(18, 18, 18)
                                        .addComponent(UltimoRegistro)))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addComponent(title_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title_lbl)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(qtd_lbl)
                                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idprof_lbl)
                                    .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(id_alunolbl)
                                    .addComponent(txtAl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(img_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrimeiroRegistro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProximoRegistro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UltimoRegistro, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(VoltarUmRegistro)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseClicked
        
        //Abrir a tela do curso e fechar a tela de menu.
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_back_btnMouseClicked

    private void PrimeiroRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrimeiroRegistroMouseClicked
        
        try{
            con_cliente.resultset.first();
            mostrar_Dados();
        }
        
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_PrimeiroRegistroMouseClicked

    private void ProximoRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProximoRegistroMouseClicked
        
        try{
            con_cliente.resultset.next();
            mostrar_Dados();
        }
        
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o próximo registro: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_ProximoRegistroMouseClicked

    private void UltimoRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UltimoRegistroMouseClicked
        
        try{
            con_cliente.resultset.last();
            mostrar_Dados();
        }
        
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o último registro: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_UltimoRegistroMouseClicked

    private void VoltarUmRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoltarUmRegistroMouseClicked
        
        try{
            con_cliente.resultset.previous();
            mostrar_Dados();
        }
        
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro anterior: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_VoltarUmRegistroMouseClicked

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
            java.util.logging.Logger.getLogger(Turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Turma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PrimeiroRegistro;
    private javax.swing.JLabel ProximoRegistro;
    private javax.swing.JLabel UltimoRegistro;
    private javax.swing.JLabel VoltarUmRegistro;
    private javax.swing.JLabel back_btn;
    private javax.swing.JLabel id_alunolbl;
    private javax.swing.JLabel idprof_lbl;
    private javax.swing.JLabel img_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel qtd_lbl;
    private javax.swing.JLabel title_lbl;
    private javax.swing.JTable turma;
    private javax.swing.JTextField txtAl;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtProf;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}
