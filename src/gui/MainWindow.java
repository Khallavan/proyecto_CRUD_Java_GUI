package gui;

import javax.swing.*;

public class MainWindow extends JFrame {
    private JButton btnAddItems;
    private JButton btnConsultTable;
    private JButton btnModifyItems;
    private JLabel lblMainWindow;

    public MainWindow() {
        initComponents();
        setTitle("Inventario");
    }

    public void initComponents() {
        btnAddItems = new JButton();
        btnModifyItems = new JButton();
        btnConsultTable = new JButton();
        lblMainWindow = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnAddItems.setText("Agregar Productos Nuevos");
        btnAddItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemsActionPerformed(evt);
            }
        });

        btnModifyItems.setText("Modificar Productos");
        btnModifyItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyItemsActionPerformed(evt);
            }
        });

        btnConsultTable.setText("Consultar Tabla");
        btnConsultTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultTableActionPerformed(evt);
            }
        });

        lblMainWindow.setText("INVENTARIO");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAddItems, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                        .addComponent(btnModifyItems, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnConsultTable, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(67, 67, 67))
                        .addGroup(GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addComponent(lblMainWindow).addGap(150, 150, 150)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(lblMainWindow, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddItems, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModifyItems, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultTable, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)));
        pack();
    }

    private void btnAddItemsActionPerformed(java.awt.event.ActionEvent evt) {
        AddNewItem addNewItem = new AddNewItem(this, true);
        addNewItem.setTitle("Agregar Productos");
        addNewItem.setVisible(true);
    }

    private void btnModifyItemsActionPerformed(java.awt.event.ActionEvent evt) {
        ModifyItems modifyItems = new ModifyItems(this, true);
        modifyItems.setTitle("Modificar Productos");
        modifyItems.setVisible(true);
    }

    private void btnConsultTableActionPerformed(java.awt.event.ActionEvent evt) {
        ConsultTable consultTable = new ConsultTable(this, true);
        consultTable.setTitle("Tabla de Datos");
        consultTable.setVisible(true);
    }
}
