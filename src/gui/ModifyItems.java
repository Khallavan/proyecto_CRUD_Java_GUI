package gui;

import javax.swing.*;
import modelVO.ItemVO;
import controllerBO.ItemBO;

public class ModifyItems extends JDialog {
    
    public ModifyItems(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    private void initComponents() {

        lblInstruction = new JLabel();
        txtModel = new JTextField();
        lblNombre = new JLabel();
        jSeparator1 = new JSeparator();
        txtName = new JTextField();
        lblCantidad = new JLabel();
        txtQuantity = new JTextField();
        lblNeto = new JLabel();
        txtNeto = new JTextField();
        btnConsultPerItem = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        lblInstruction.setText("Ingresa el modelo del producto:");

        lblNombre.setText("Nombre:");

        lblCantidad.setText("Cantidad:");

        lblNeto.setText("Valor Neto:");

        btnConsultPerItem.setText("Buscar");
        btnConsultPerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultPerItemActionPerformed(evt);
            }
        });

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                        .createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup().addComponent(lblInstruction).addGap(18, 18, 18)
                                        .addComponent(txtModel, GroupLayout.PREFERRED_SIZE, 173,
                                                GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNombre).addComponent(lblCantidad)
                                                .addComponent(lblNeto))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtName).addComponent(txtQuantity).addComponent(txtNeto,
                                                        GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))))
                        .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConsultPerItem).addGap(18, 18, 18).addComponent(btnUpdate)
                                .addGap(18, 18, 18).addComponent(btnDelete).addGap(70, 70, 70)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblInstruction).addComponent(txtModel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombre).addComponent(txtName, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCantidad).addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNeto).addComponent(txtNeto, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnConsultPerItem).addComponent(btnDelete)
                                        .addComponent(btnUpdate))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    private void btnConsultPerItemActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String model = txtModel.getText();
            ItemVO itemfinded = new ItemBO().getItem(model);
            if(itemfinded != null){
                txtName.setText(itemfinded.getName());
                txtQuantity.setText(itemfinded.getQuantity() + "");
                txtNeto.setText(itemfinded.getNeto() + "");
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
                JOptionPane.showMessageDialog(this, "Ingrese modelo del producto");
            }
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String model = txtModel.getText();
            ItemVO itemFinded = new ItemBO().getItem(model);
            float neto = Float.parseFloat(txtNeto.getText());
            float brute = neto * 1.19f;
            float iva = (brute * 0.19f) / 1.19f;
            itemFinded.setBrute(brute);
            itemFinded.setIva(iva);
            itemFinded.setNeto(neto);
            itemFinded.setName(txtName.getText());
            itemFinded.setQuantity(Integer.parseInt(txtQuantity.getText()));
            boolean result = new ItemBO().updateItems(itemFinded);
            String message = result?"El producto fue actualizado":"El producto no fue actualizado";
            JOptionPane.showMessageDialog(this, message);
        } catch (Exception e) {  
            JOptionPane.showMessageDialog(this, "Error" + e);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String model = txtModel.getText();
            ItemVO item = new ItemBO().getItem(model);
            boolean result = new ItemBO().deleteItems(item);
            String message = result?"El producto fue Eliminado":"El producto no fue eliminado";
            JOptionPane.showMessageDialog(this, message);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e);
        }
    }
    private JButton btnConsultPerItem;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JSeparator jSeparator1;
    private JLabel lblCantidad;
    private JLabel lblInstruction;
    private JLabel lblNeto;
    private JLabel lblNombre;
    private JTextField txtModel;
    private JTextField txtName;
    private JTextField txtNeto;
    private JTextField txtQuantity;

}
