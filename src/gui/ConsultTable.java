package gui;

import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import modelVO.ItemVO;
import controllerBO.ItemBO;

public class ConsultTable extends JDialog {
    private DefaultTableModel modelTable;
    private JTable TDatos;
    private JButton btnConsult;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JLabel lblModelo;
    private JTextField txtModel;

    public ConsultTable(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modelTable = new DefaultTableModel();
        modelTable.addColumn("Nombre");
        modelTable.addColumn("Modelo");
        modelTable.addColumn("Cantidad");
        modelTable.addColumn("IVA");
        modelTable.addColumn("Valor Neto");
        modelTable.addColumn("Valor Bruto");
        TDatos.setModel(modelTable);
        List<ItemVO> items = new ItemBO().getItems();
        for(ItemVO item : items){
            String row[] = {item.getName(), item.getModel(), item.getQuantity() + "", item.getIva() + "", item.getNeto() + "", item.getBrute() + ""};
            modelTable.addRow(row);
        }
    }
    private void initComponents() {

        lblModelo = new JLabel();
        txtModel = new JTextField();
        jSeparator1 = new JSeparator();
        btnConsult = new JButton();
        jScrollPane1 = new JScrollPane();
        TDatos = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        lblModelo.setText("Ingresa el modelo:");


        btnConsult.setText("Consultar");
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });

        TDatos.setModel(new DefaultTableModel(
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
        jScrollPane1.setViewportView(TDatos);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblModelo)
                        .addGap(18, 18, 18)
                        .addComponent(txtModel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsult)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsult))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }
    

    protected void btnConsultActionPerformed(ActionEvent evt) {
        try {
            String model = txtModel.getText();
            modelTable.setRowCount(0);
            List<ItemVO> items = null;
            if(txtModel.getText() != null){
                items = new ArrayList<ItemVO>();
                items.add(new ItemBO().getItem(model));
            }
            for (ItemVO item : items) {
                String row[] = { item.getName(), item.getModel(), item.getQuantity() + "", item.getIva() + "",
                        item.getNeto() + "", item.getBrute() + "" };
                modelTable.addRow(row);                                                                                                                                                                 
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e);
        }
    }    
}
