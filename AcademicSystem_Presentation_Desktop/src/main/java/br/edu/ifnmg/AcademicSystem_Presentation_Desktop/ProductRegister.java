/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.AcademicSystem_Presentation_Desktop;

import br.edu.ifnmg.AcademicSystem_LogicaAplicacao.Product;
import br.edu.ifnmg.AcademicSystem_LogicaAplicacao.ProductRepository;
import br.edu.ifnmg.AcademicSystem_LogicaAplicacao.RepositoryFactory;
import br.edu.ifnmg.AcademicSystem_LogicaAplicacao.Unit;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ProductRegister extends javax.swing.JInternalFrame {
    
    ProductRepository repository = RepositoryFactory.getProductRepository();
    private Product product;
    /**
     * Creates new form ProductRegister
     */
    public ProductRegister() {
        product = new Product();
        initComponents();
    }

    public void getComponent(){
        product.setName(this.txtName.getText());
        product.setDescription(this.txtDescription.getText());
        
        DecimalFormat nf = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));// Locale, é o local, para saber como é a formatação BR
        nf.setParseBigDecimal(true);//Essa parte está configurando para traduzir para BigDecimal
        BigDecimal valorA;
        BigDecimal valorB;
        try {
            //Está chamando a função parse e traduzir para um BigDecimal
            valorA = (BigDecimal) nf.parse(this.txtPurchasePrice.getText()); 
            valorB = (BigDecimal) nf.parse(this.txtSalePrice.getText()); 
            product.setPurchace_price(valorA);
            product.setSale_price(valorB);
            //O ParseException é para quando não se é possível traduzir em um número
        } catch (ParseException ex) {
            Logger.getLogger(PlanRegister.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Purchase price or sale price error!","Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        product.setPurchasereason(Integer.valueOf(this.txtPurchaseReason.getText()));
        product.setSalereason(Integer.valueOf(this.txtSaleReason.getText()));
        
        Unit uni = Unit.valueOf(this.cbbPurchaseUnit.getSelectedItem().toString());
        product.setUnitpurchase(uni);
        product.setUnitsale(Unit.valueOf(this.cbbSaleUnit.getSelectedItem().toString()));
        
        if(this.cbbStatus.getSelectedItem().toString().equals("Activate")){
            product.setStatus(1);
        }else{
            product.setStatus(0);
        }
        
    }
    
    public void setNull(){
        this.txtDescription.setText("");
        this.txtName.setText("");
        this.txtPurchaseReason.setText("");
        this.txtSaleReason.setText("");
        this.txtPurchasePrice.setText("");
        this.txtSalePrice.setText("");
        this.cbbPurchaseUnit.setSelectedIndex(0);
        this.cbbSaleUnit.setSelectedIndex(0);
        this.cbbStatus.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnSale = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPurchasePrice = new javax.swing.JFormattedTextField();
        txtSalePrice = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPurchaseReason = new javax.swing.JTextField();
        txtSaleReason = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbPurchaseUnit = new javax.swing.JComboBox<>();
        cbbSaleUnit = new javax.swing.JComboBox<>();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Product Register");

        jLabel1.setText("Name:");

        jLabel3.setText("Description:");

        jLabel4.setText("Purchase Price:");

        jLabel5.setText("Sale Price:");

        jLabel6.setText("0,0");

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activate", "Deactivate" }));

        jLabel7.setText("Status:");

        btnSale.setText("Save");
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        jLabel8.setText("Purchase Reason:");

        txtPurchasePrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        txtSalePrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabel9.setText("Sale Reason:");

        jLabel10.setText("Purchase Unit:");

        jLabel11.setText("Sale Price:");

        cbbPurchaseUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Box", "Unit", "Bale", "Outher" }));

        cbbSaleUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Box", "Unit", "Bale", "Outher" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescription))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPurchaseReason, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSaleReason)
                                    .addComponent(cbbSaleUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSale)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbPurchaseUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(cbbPurchaseUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSaleUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtPurchaseReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaleReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(50, 50, 50)
                .addComponent(btnSale)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        if(!this.txtName.getText().isEmpty() && !this.txtPurchasePrice.getText().isEmpty() && !this.txtSalePrice.getText().isEmpty() && !this.txtPurchaseReason.getText().isEmpty() && !this.txtSaleReason.getText().isEmpty()){
            if(JOptionPane.showConfirmDialog(this, "Really want to save?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                this.getComponent();
                if(repository.Save(product)){
                    JOptionPane.showMessageDialog(null, "The product is saved!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    if(JOptionPane.showConfirmDialog(this, "Do you want to create another client?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                        this.product = new Product();
                        this.setNull();
                    }else{
                        this.setVisible(false);
                    }
                }else{
                   JOptionPane.showMessageDialog(this, "Product is not saved!","Erro", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Operation canceled!","Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "The Name, Purchase Price, Sale Price, Purchase Reason and Sale Reason must be completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSale;
    private javax.swing.JComboBox<String> cbbPurchaseUnit;
    private javax.swing.JComboBox<String> cbbSaleUnit;
    private javax.swing.JComboBox<String> cbbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JFormattedTextField txtPurchasePrice;
    private javax.swing.JTextField txtPurchaseReason;
    private javax.swing.JFormattedTextField txtSalePrice;
    private javax.swing.JTextField txtSaleReason;
    // End of variables declaration//GEN-END:variables
}
