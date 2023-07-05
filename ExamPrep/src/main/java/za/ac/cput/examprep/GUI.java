
package za.ac.cput.examprep;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
GUI.java
This is the GUI class with functionality
Author: Hanno Visser Immelman (221074414)
 */
public class GUI extends JFrame implements ActionListener, ItemListener {
    
    private JLabel lblTitle, lblModelNum, lblCarName, lblManufacturer, lblEngineHP, lblIcon;
    private JTextField txtModelNum, txtCarName, txtEngineHP;
    private JComboBox cmbManufacturer, cmbModelNum;
    private JPanel panelNorth, panelCenter, panelSouth;
    private JButton btnInsert, btnUpdate, btnDelete, btnRefresh, btnExit;
    
    public GUI() {
        lblTitle = new JLabel("CARS");
        lblModelNum = new JLabel("Model number:");
        lblCarName = new JLabel("Car name:");
        lblManufacturer = new JLabel("Manufacturer:");
        lblEngineHP = new JLabel("Engine HP:");
        
        txtModelNum = new JTextField();
        txtCarName = new JTextField();
        txtEngineHP = new JTextField();
        
        cmbManufacturer = new JComboBox();
//Hardcoding items to combobox       
        String[] cars = {"Mercedes", "Toyota", "Nissan", "Izuzu", "Huandai"};
        for (int i = 0; i < cars.length; i++) {
            cmbManufacturer.addItem(cars[i]);
        }
        
        cmbModelNum = new JComboBox();
//Retrieving items for combobox from Database
        cmbModelNum.addItem("Insert Mode");
        DAO select = new DAO();
        for (int i = 0; i < select.populate().size(); i++) {
            cmbModelNum.addItem(select.populate().get(i));
        }
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        
        btnInsert = new JButton("Insert");
        
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");
        btnRefresh = new JButton("Refresh");
        btnExit = new JButton("Exit");
        //  ImageIcon img = new ImageIcon("Car.png");
        //lblIcon = new JLabel(img);

    }
    
    public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(4, 2));
        panelSouth.setLayout(new FlowLayout());

        // panelNorth.add(lblIcon);
        panelNorth.add(lblTitle);
        
        panelCenter.add(lblModelNum);
        panelCenter.add(txtModelNum);
        panelCenter.add(lblCarName);
        panelCenter.add(txtCarName);
        panelCenter.add(lblManufacturer);
        panelCenter.add(cmbManufacturer);
        panelCenter.add(lblEngineHP);
        panelCenter.add(txtEngineHP);
        
        panelSouth.add(btnInsert);
        panelSouth.add(btnUpdate);
        panelSouth.add(btnDelete);
        panelSouth.add(btnRefresh);
        panelSouth.add(cmbModelNum);
        panelSouth.add(btnExit);
        
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnExit.addActionListener(this);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        
        cmbModelNum.addItemListener(this);
        
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
//Refresh and reset form   
    public void refresh() {
        
        cmbModelNum.removeAllItems();
        cmbModelNum.addItem("Insert Mode");
        DAO select = new DAO();
        for (int i = 0; i < select.populate().size(); i++) {
            cmbModelNum.addItem(select.populate().get(i));
        }
        txtCarName.setText("");
        txtEngineHP.setText("");
        txtModelNum.setText("");
        cmbManufacturer.setSelectedIndex(0);
        cmbModelNum.setSelectedIndex(0);
    }
//Action listeners    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsert) {
            Car car = new Car(txtModelNum.getText(),
                    txtCarName.getText(),
                    cmbManufacturer.getSelectedItem().toString(),
                    txtEngineHP.getText());
            DAO insert = new DAO();
            insert.InsertCar(car.getItems());
            JOptionPane.showMessageDialog(this, "Items was inserted into database");
            
        } else if (e.getSource() == btnUpdate) {
            Car car2 = new Car(txtModelNum.getText(),
                    txtCarName.getText(),
                    cmbManufacturer.getSelectedItem().toString(),
                    txtEngineHP.getText());
            DAO update = new DAO();
            update.UpdateDB(car2.getItems(), cmbModelNum.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this, "Items was Updated");
        } else if (e.getSource() == btnDelete) {
            DAO delete = new DAO();
            delete.DeleteDB(cmbModelNum.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this, "Items was Deleted");
        } else if (e.getSource() == btnRefresh) {
            refresh();
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
//Item listeners    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cmbModelNum) {
            if (cmbModelNum.getSelectedIndex() == 0) {
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
            } else {
                btnDelete.setEnabled(true);
                btnUpdate.setEnabled(true);
                DAO items = new DAO();
                ArrayList listItems = new ArrayList();
                listItems.addAll(items.SelectedItems(cmbModelNum.getSelectedItem().toString()));
                txtModelNum.setText(listItems.get(0).toString());
                txtCarName.setText(listItems.get(1).toString());
                txtEngineHP.setText(listItems.get(3).toString());
                cmbManufacturer.setSelectedItem(listItems.get(2));
            }
        }
    }
}
