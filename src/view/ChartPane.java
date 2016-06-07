package view;

import Model.Word;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class ChartPane extends javax.swing.JPanel {

    private DefaultTableModel datos;
    
    public ChartPane() {
        initComponents();
        datos = (DefaultTableModel) jTable1.getModel();
        try {
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillTable() throws SQLException{
        String select=null;

        switch(jCBWordType.getSelectedIndex()){
            case 0:
                select="where ignoredWord=false";
                break;
            case 1:
                select="where ignoredWord=true";
                break;
            case 2:
                //to be null
                ;
                break;
        }

        //delete all the rows
        while(datos.getRowCount()>0)
            datos.removeRow(datos.getRowCount()-1);
//        int nRowCount=datos.getRowCount();
//        for(int i=0;i<nRowCount;i++)
//            
        
        for (Word w : Word.selectWhere(select)) {
            if(w!=null){
                Object object[]=new Object[]{w.getWord(),w.getMeaning(),w.getInsertionDate()};
            datos.addRow(object);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jCBWordType = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Word", "Meaing", "InsertionDate"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCBWordType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "IgnoreWords", "All" }));
        jCBWordType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBWordTypeItemStateChanged(evt);
            }
        });
        jCBWordType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBWordTypeActionPerformed(evt);
            }
        });
        jCBWordType.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jCBWordTypeHierarchyChanged(evt);
            }
        });
        jCBWordType.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCBWordTypePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBWordType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jCBWordType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(int i = 0;i<datos.getRowCount();i++){
            String nombre=(String)datos.getValueAt(i,1);
            if(!nombre.equals("")){
                try {
                    Word w= new Word((String)datos.getValueAt(i, 0), (String)datos.getValueAt(i, 1));
                    w.update();
                }
                catch (SQLException ex) {
                    Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCBWordTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBWordTypeActionPerformed
        ;
    }//GEN-LAST:event_jCBWordTypeActionPerformed

    private void jCBWordTypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCBWordTypePropertyChange
//        try {
//            fillTable();
//        } catch (SQLException ex) {
//            Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jCBWordTypePropertyChange

    private void jCBWordTypeHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jCBWordTypeHierarchyChanged

    }//GEN-LAST:event_jCBWordTypeHierarchyChanged

    private void jCBWordTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBWordTypeItemStateChanged
        try {
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCBWordTypeItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCBWordType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
