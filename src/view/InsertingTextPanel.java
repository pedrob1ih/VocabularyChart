package view;

import Model.MakeVocabulary;
import Objects.Word;
import Objects.WordsGroup;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InsertingTextPanel extends javax.swing.JPanel {

    /**
     * Creates new form InsertingText
     */
    public InsertingTextPanel() {
        initComponents();
        SimpleDateFormat sDateFormat= new SimpleDateFormat("dd/MM/yyyy");
        jTFNameGroup.setText((sDateFormat.format(Calendar.getInstance().getTime()))+" - ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSPImput = new javax.swing.JScrollPane();
        jTAImput = new javax.swing.JTextArea();
        jBCreate = new javax.swing.JButton();
        JBCopy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAOutput = new javax.swing.JTextArea();
        jTFNameGroup = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(800, 494));

        jTAImput.setColumns(20);
        jTAImput.setRows(5);
        jSPImput.setViewportView(jTAImput);

        jBCreate.setText("Create List");
        jBCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCreateActionPerformed(evt);
            }
        });

        JBCopy.setText("Copy List");
        JBCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCopyActionPerformed(evt);
            }
        });

        jTAOutput.setColumns(20);
        jTAOutput.setRows(5);
        jScrollPane2.setViewportView(jTAOutput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jSPImput)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNameGroup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCreate)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPImput, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBCopy)
                        .addComponent(jBCreate))
                    .addComponent(jTFNameGroup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCopyActionPerformed
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection data = new StringSelection(this.jTAOutput.getText());
        clipboard.setContents(data, data);
    }//GEN-LAST:event_JBCopyActionPerformed

    private void jBCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCreateActionPerformed
        try {
            ArrayList list=MakeVocabulary.makeVocabulary(jTAImput.getText());
            String listaPalabras="";
            Random r= new Random();
            WordsGroup wG=null;
            int idWordGroup=0;
            while(wG==null || wG.exist()){
                idWordGroup=r.nextInt(999999999);
                wG= new WordsGroup(idWordGroup, jTFNameGroup.getText());
            }
            wG.insert();
            
            for (Object list1 : list) {
                try {
                    Word w= new Word(idWordGroup,(String) list1);
                    listaPalabras+="\n"+w.getWord()+" = ";
                    if(!w.exist()){
                        w.insert();
                        System.out.println("palabra "+(String)list1+" insertada");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(InsertingTextPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jTAOutput.setText(listaPalabras);
        } catch (SQLException ex) {
            Logger.getLogger(InsertingTextPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBCreateActionPerformed

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag); //To change body of generated methods, choose Tools | Templates.
        if(aFlag){
            jTAImput.setText("");
            jTAOutput.setText("");
            jTFNameGroup.setText("");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCopy;
    private javax.swing.JButton jBCreate;
    private javax.swing.JScrollPane jSPImput;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAImput;
    private javax.swing.JTextArea jTAOutput;
    private javax.swing.JTextField jTFNameGroup;
    // End of variables declaration//GEN-END:variables
}
