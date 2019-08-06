/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cliente.Cliente;
import cliente.Documento;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author User
 */
public class BuscarDocumentos extends javax.swing.JFrame {

    /**
     * Creates new form BuscarDocumentos
     */
    public static Documento docSelecionado;
    DefaultListModel modelo;
    List<Documento> docs;
    public static BuscarDocumentos buscarDocs;

    public BuscarDocumentos() throws IOException, ClassNotFoundException {
        initComponents();
        adicionarElementos();
    }

    public void adicionarElementos() throws IOException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        cliente.cliente(TelaInicial.ipAux, TelaInicial.portaAux);
        cliente.carregarListaDocumentos(Login.loginCPF);
        docs = Cliente.docs;
        listaDocs.removeAll();
        modelo = new DefaultListModel();
        if (!docs.isEmpty()) {
            for (int i = 0; i < docs.size(); i++) {
                modelo.addElement(docs.get(i).getId());
            }
        }
        listaDocs.setModel(modelo);
        cliente.sair();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaDocs = new javax.swing.JList<>();
        ver = new javax.swing.JButton();
        voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Documentos");
        setResizable(false);

        listaDocs.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaDocs);

        ver.setText("Ver");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });

        voltar.setText("<");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ver))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ver)
                    .addComponent(voltar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        docSelecionado = docs.get(listaDocs.getSelectedIndex());
        try {
            ExibirDocumento.exibirDoc = new ExibirDocumento();
            this.setVisible(false);
            ExibirDocumento.exibirDoc.setVisible(true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BuscarDocumentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_verActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaDocs;
    private javax.swing.JButton ver;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
