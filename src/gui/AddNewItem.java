package gui;

import java.awt.event.ActionEvent;
import javax.swing.*;
import modelVO.ItemVO;
import controllerBO.ItemBO;

public class AddNewItem extends JDialog {
    private JButton btnAddToDB;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel lblCantidad;
    private JLabel lblNeto;
    private JTextField txtModel;
    private JTextField txtName;
    private JTextField txtNeto;
    private JTextField txtQuantity;

    public AddNewItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        lblCantidad = new JLabel();
        lblNeto = new JLabel();
        txtName = new JTextField();
        txtModel = new JTextField();
        txtQuantity = new JTextField();
        txtNeto = new JTextField();
        btnAddToDB = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Modelo:");

        lblCantidad.setText("Cantidad:");

        lblNeto.setText("Valor neto:");

        btnAddToDB.setText("Agregar");
        btnAddToDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToDBActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnAddToDB))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(0, 0,
                                                Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblCantidad).addComponent(jLabel1)
                                                        .addComponent(lblNeto))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72,
                                                        Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtModel, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.PREFERRED_SIZE, 180,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtName, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.PREFERRED_SIZE, 180,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtQuantity, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.PREFERRED_SIZE, 180,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtNeto, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.PREFERRED_SIZE, 180,
                                                                GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(16, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(
                        txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(
                        txtModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblCantidad)
                        .addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNeto).addComponent(
                        txtNeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18).addComponent(btnAddToDB).addContainerGap(22, Short.MAX_VALUE)));

        pack();
    }

    protected void btnAddToDBActionPerformed(ActionEvent evt) {
        try {
            float neto = Float.parseFloat(txtNeto.getText());
            float brute = neto * 1.19f;
            float iva = (brute * 0.19f) / 1.19f;
            ItemVO newItem = new ItemVO();
            newItem.setName(txtName.getText());
            newItem.setModel(txtModel.getText());
            newItem.setQuantity(Integer.parseInt(txtQuantity.getText()));
            newItem.setBrute(brute);
            newItem.setIva(iva);
            newItem.setNeto(neto);
            boolean result = new ItemBO().insertItems(newItem);
            clearTextPanels();
            String message = result ? "El producto fue registrado" : "El producto no fue registrado";
            JOptionPane.showMessageDialog(this, message);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e);
        }
    }

    private void clearTextPanels() {
        txtModel.setText(null);
        txtName.setText(null);
        txtNeto.setText(null);
        txtQuantity.setText(null);
    }

}
