package univs.edu.telas;

import javax.swing.JOptionPane;
import univs.edu.usuario.Usuario;
import univs.edu.usuario.UsuarioDAO;
import univs.edu.usuario.UsuarioTableModel;

public class PesquisaUsuario extends javax.swing.JFrame {

    Usuario usuario = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();

    public PesquisaUsuario() {
        initComponents();
        atualizarTabela();
    }

    public void atualizarTabela() {
        UsuarioTableModel tm = new UsuarioTableModel(dao.pesquisar());
        tabelaUsuario.setModel(tm);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaUsuario);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btPesquisar.setText("Editar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVoltar)
                        .addGap(89, 89, 89)
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVoltar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btPesquisar)
                        .addComponent(btExcluir)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linha = tabelaUsuario.getSelectedRow();
        if (linha != -1) {
            int id = (int) tabelaUsuario.getValueAt(linha, 0);
            usuario = dao.pesquisar(id);
            dao.excluir(usuario);
            atualizarTabela();
            JOptionPane.showMessageDialog(null, "Usuário Excluído!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        TelaUsuario tela = new TelaUsuario();
        tela.setVisible(true);
        dispose();

    }//GEN-LAST:event_btVoltarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        int linha = tabelaUsuario.getSelectedRow();
        if (linha != -1) {
            int id = (int) tabelaUsuario.getValueAt(linha, 0);
            usuario = dao.pesquisar(id);
            TelaUsuario tela = new TelaUsuario();
            tela.carregarUsuario(usuario);
            tela.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }

    }//GEN-LAST:event_btPesquisarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUsuario;
    // End of variables declaration//GEN-END:variables
}
