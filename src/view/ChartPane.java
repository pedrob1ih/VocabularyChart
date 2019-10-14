package view;

import Objects.WordsGroup;
import java.sql.SQLException;
import javax.swing.JToolTip;
import javax.swing.table.DefaultTableModel;

public class ChartPane extends javax.swing.JPanel {

    private DefaultTableModel datos;
    //whatShow=0 -- notIgnore
    //whatShow=1 -- ignore
    //whatShow=2 -- all
    private int whatShow;
    
    public ChartPane() {
        initComponents();
        datos = (DefaultTableModel) jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
    }


    @Override
    public JToolTip createToolTip() {
        return super.createToolTip(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag); //To change body of generated methods, choose Tools | Templates.
        if(aFlag){
            try {
                filljCBWGroup();
                fillTable();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private void filljCBWGroup() throws SQLException{
        try{
            for (int i = 0; i < jCBWGroup.getSize().height; i++) {
                jCBWGroup.removeItemAt(i);
            }
        }
        catch(Exception e){;}
        
        
//        for (WordsGroup wG : WordsGroup.select("select * from wordsGroup order by name")) {
//            jCBWGroup.addItem(wG);
//        }            
    }

    private void fillTable() throws SQLException{
        //mirar lo del combo de irnored
        //mirar la tabla de vocabulario seleccionada
        
        String nGroup=jCBWGroup.getSelectedItem().toString();
        int idWordGroup=0;
//        for (WordsGroup w : WordsGroup.select("select * from wordsGroup where name='"+nGroup+"'")) {
//            idWordGroup=w.getId();
//        }
        String select=null;
        switch(jCBWordType.getSelectedIndex()){
            case 0:
                select="select * from words where ignoredWord=false and IDWORDGOUP="+idWordGroup+" order by word";
                whatShow=0;
                break;
            case 1:
                select="select * from words where ignoredWord=true and IDWORDGOUP="+idWordGroup+" order by word";
                whatShow=1;
                break;
            case 2:
                whatShow=2;
                //to be null
                ;
                break;
        }
        
        //wipe the table
        while(datos.getRowCount()>0)
            datos.removeRow(datos.getRowCount()-1);
        
//        String nameGroup=WordsGroup.select("select * from wordsGroup where id='"+idWordGroup+"' order by id").get(0).getName();
//        for (Word w : Word.selectWhere(select)) {
//            if(w!=null){
//                
//                Object object[]=new Object[]{nameGroup,w.getWord(),w.getMeaning(),w.getInsertionDate(),w.isIgnoredWord()};
//                datos.addRow(object);
//            }
//        }
//        filljCBWGroup();
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
        jBSave = new javax.swing.JButton();
        jCBWordType = new javax.swing.JComboBox();
        jCBWGroup = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(800, 494));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Group Name", "Word", "Meaing", "InsertionDate", "Ignored Word"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBSave.setText("Save");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        jCBWordType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "IgnoreWords", "All" }));
        jCBWordType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBWordTypeItemStateChanged(evt);
            }
        });

        jCBWGroup.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBWGroupItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCBWGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBWordType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBWordType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSave)
                    .addComponent(jCBWGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
//        try {
//            //whatShow=0 -- notIgnore
//            //whatShow=1 -- ignore
//            //whatShow=2 -- all
//            Word w;
//            switch(whatShow){
//                case 0:
//                    // the meaning have to be filled or the not ignore checked
//                    for(int i = 0;i<datos.getRowCount();i++){
//                        boolean ignored=(boolean)datos.getValueAt(i,4);
//                        String meaning=(String)datos.getValueAt(i,2);
//                        if(ignored || !meaning.equals("")){
//                            int idGroup=WordsGroup.select("select * from wordsGroup where name='"+(String)datos.getValueAt(i, 0)+"'").get(0).getId();
//                            w= new Word(idGroup, (String)datos.getValueAt(i, 1), (String)datos.getValueAt(i, 2),(Timestamp)datos.getValueAt(i, 3), (boolean)datos.getValueAt(i, 4));
//                            try {
//                                w.update();
//                            } catch (SQLException ex) {
//                                Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                        }
//                    }
//                    break;
//                case 1:
//                    // the notIgnore have to be unchecked
//                    for(int i = 0;i<datos.getRowCount();i++){
//                        boolean ignored=(boolean)datos.getValueAt(i,4);
//                        String meaning=(String)datos.getValueAt(i,2);
//                        if(ignored || !meaning.equals("")){
//                            int idGroup=WordsGroup.select("select * from wordsGroup where name='"+(String)datos.getValueAt(i, 0)+"'").get(0).getId();
//                            w= new Word(idGroup, (String)datos.getValueAt(i, 1), (String)datos.getValueAt(i, 2),(Timestamp)datos.getValueAt(i, 3), (boolean)datos.getValueAt(i, 4));
//                            try {
//                                w.update();
//                            } catch (SQLException ex) {
//                                Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                        }
//                    }
//                    break;
//                case 2:
//                    // save every thing
//                    for(int i = 0;i<datos.getRowCount();i++){
//                        int idGroup=WordsGroup.select("select * from wordsGroup where name='"+(String)datos.getValueAt(i, 0)+"'").get(0).getId();
//                        w= new Word(idGroup, (String)datos.getValueAt(i, 1), (String)datos.getValueAt(i, 2),(Timestamp)datos.getValueAt(i, 3), (boolean)datos.getValueAt(i, 4));
//                        try {
//                            w.update();
//                        } catch (SQLException ex) {
////                            Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                    break;
//            }
//            fillTable();
//        } catch (SQLException ex) {
////            Logger.getLogger(ChartPane.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jCBWordTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBWordTypeItemStateChanged
        try {
            fillTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jCBWordTypeItemStateChanged

    private void jCBWGroupItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBWGroupItemStateChanged
        try {
            fillTable();
        }
        catch (SQLException ex) {
            //ex.printStackTrace();
        }       
    }//GEN-LAST:event_jCBWGroupItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSave;
    private javax.swing.JComboBox jCBWGroup;
    private javax.swing.JComboBox jCBWordType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
