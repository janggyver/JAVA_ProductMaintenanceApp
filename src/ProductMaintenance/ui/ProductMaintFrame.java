/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductMaintenance.ui;
import ProductMaintenance.business.*;
import SwingValidator.SWingValidator;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author eric
 */
public class ProductMaintFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProductMaintFrame
     */
    //declare global variable for the form
    ProductDAO productDAO;
    ArrayList<Product> products;
    Product newProduct = null;
    boolean filling = false;
    
    /**
     * create new form ProductMaintenance Frame
     */
    public ProductMaintFrame() {
        initComponents();
        //fill the products combo box
        productDAO = DAOFactory.getProductDAO();
        products = productDAO.getProducts();
        this.fillComboBox(products);
        this.showProduct(this.getCurrentProduct());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productComboBox = new javax.swing.JComboBox<>();
        codeTextField = new javax.swing.JTextField();
        descriptionTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Display");

        jLabel1.setText("Select Product:");

        jLabel2.setText("Product Code:");

        jLabel3.setText("Description:");

        jLabel4.setText("Unit Price:");

        productComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productComboBoxItemStateChanged(evt);
            }
        });
        productComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productComboBoxActionPerformed(evt);
            }
        });

        codeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descriptionTextFieldFocusGained(evt);
            }
        });

        descriptionTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descriptionTextFieldFocusGained(evt);
            }
        });

        priceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descriptionTextFieldFocusGained(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("Accept");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        exitButton.setMnemonic('x');
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(addButton)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(productComboBox, 0, 348, Short.MAX_VALUE)
                        .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descriptionTextField))
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(exitButton)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(editButton)
                            .addGap(18, 18, 18)
                            .addComponent(deleteButton)
                            .addGap(34, 34, 34)
                            .addComponent(acceptButton)
                            .addGap(26, 26, 26)
                            .addComponent(cancelButton))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(acceptButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productComboBoxActionPerformed
        if(!filling){
            Product p = (Product)productDAO.getProduct(productComboBox.getSelectedItem().toString());
            this.showProduct(p);
        }
    }//GEN-LAST:event_productComboBoxActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        newProduct = new Product();
        this.clearField();
        this.setAddEditMode(true);
        this.setAddMode();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        this.setAddEditMode(true);
        this.setEditMode();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Product p = this.getProduct();
        productDAO.deleteProduct(p);
        products.remove(p);
        this.fillComboBox(products);
        this.selectdProduct(products.get(0));
        this.showProduct(products.get(0));
        this.productComboBox.requestFocusInWindow();
        
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if(newProduct != null){
            newProduct = null;
        }
        this.setDisplayMode();
        this.showProduct(this.getCurrentProduct());
        this.setAddEditMode(false);
        this.productComboBox.requestFocusInWindow();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void descriptionTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descriptionTextFieldFocusGained
        // TODO add your handling code here:
        if(evt.getComponent() instanceof JTextField){
            JTextField t = (JTextField)evt.getComponent();
            t.selectAll();
        }
    }//GEN-LAST:event_descriptionTextFieldFocusGained

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        if(isValidData()){
            if(newProduct != null){
                newProduct = this.getProduct();
                productDAO.addProduct(newProduct);
                products.add(newProduct);
                this.fillComboBox(products);
                this.selectdProduct(newProduct);
                newProduct = null;
            }
            else{
                Product cp = this.getCurrentProduct();
                Product p = this.getProduct();
                cp.setDescription(p.getDescription());
                cp.setPrice(p.getPrice());
                productDAO.updateProduct(cp);
                this.fillComboBox(products);
                this.selectdProduct(cp);
                this.showProduct(this.getCurrentProduct());
            }
            this.setDisplayMode();
            this.setAddEditMode(false);
            this.productComboBox.requestFocusInWindow();
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void productComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productComboBoxItemStateChanged
        // TODO add your handling code here:
        if(!filling){
            Product p = (Product)productDAO.getProduct(productComboBox.getSelectedItem().toString());
            this.showProduct(p);
        }
    }//GEN-LAST:event_productComboBoxItemStateChanged


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductMaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductMaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductMaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductMaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductMaintFrame frame = new ProductMaintFrame();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codeTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JComboBox<String> productComboBox;
    // End of variables declaration//GEN-END:variables

    private void fillComboBox(ArrayList<Product> a) {
        filling = true;
        productComboBox.removeAllItems();
        for(Product p : a){
            productComboBox.addItem(p.getDescription());
        }
        filling = false;
    }
    
    private void selectdProduct(Product p){
        productComboBox.setSelectedItem(p);
    }
    
    private Product getCurrentProduct(){
        if(productComboBox.getSelectedItem() != ""){
           for(Product p : products){
                if(p.getDescription().equals(productComboBox.getSelectedItem())){
                    return p;
                }
            }
                    //this.productDAO.getProduct(productComboBox.getSelectedItem().toString());
                    
                    //getProduct(productComboBox.getSelectedItem());           
        }
        else{
            return new Product();
        }
        return null;
    }
    
    private void showProduct(Product p){
        if(p != null){
        codeTextField.setText(p.getCode());
        descriptionTextField.setText(p.getDescription());
        priceTextField.setText(p.getFormattedPrice()); 
        }

    }
    
    private void clearField(){
        codeTextField.setText("");
        descriptionTextField.setText("");
        priceTextField.setText("");
    }
    
    //return a new Product object with the data in the text field
    private Product getProduct(){
        Product p = new Product();
        p.setCode(codeTextField.getText());
        p.setDescription(descriptionTextField.getText());
        p.setFormattedPrice(priceTextField.getText());
        return p;
    }
        
    private void setAddMode(){
        codeTextField.setEditable(true);
        codeTextField.setFocusable(true);
        descriptionTextField.setEditable(true);
        descriptionTextField.setFocusable(true);
        priceTextField.setEditable(true);
        priceTextField.setFocusable(true);
    }
    private void setEditMode(){
        descriptionTextField.setEditable(true);
        descriptionTextField.setFocusable(true);
        descriptionTextField.requestFocusInWindow();
        priceTextField.setEditable(true);
        priceTextField.setFocusable(true);
    }
    
    private void setDisplayMode(){
        codeTextField.setEditable(false);
        codeTextField.setFocusable(false);
        descriptionTextField.setEditable(false);
        descriptionTextField.setFocusable(false);
        priceTextField.setEditable(false);
        priceTextField.setFocusable(false);
    }
    private void setAddEditMode(boolean e){
        addButton.setEnabled(!e);
        editButton.setEnabled(!e);
        deleteButton.setEnabled(!e);
        productComboBox.setEnabled(!e);
        acceptButton.setEnabled(e);
        cancelButton.setEnabled(e);
    }
    
    private boolean isValidData(){
        SWingValidator sv = new SWingValidator();
        if(newProduct != null){
            return
                    sv.isPresent(this.codeTextField, "Product Code") &&
                    sv.isPresent(this.descriptionTextField, "Description") &&
                    sv.isPresent(this.priceTextField, "Unit Price") &&
                    sv.isDouble(this.priceTextField, "Unit Price");
        }
        else
        {
            return sv.isPresent(this.descriptionTextField, "Description") &&
                    sv.isPresent(this.priceTextField, "Unit Price") &&
                    sv.isDouble(this.priceTextField, "Unit Price");
        }
        
    }
}
