/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.AcademicSystem_Presentation_Desktop;

import br.edu.ifnmg.AcademicSystem_LogicaAplicacao.RepositoryFactory;
import br.edu.ifnmg.AcademicSystem_LogicaAplicacao.User;
import br.edu.ifnmg.AcademicSystem_LogicaAplicacao.UserRepository;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class UserSelect extends javax.swing.JInternalFrame {
    
    User user = new User();
    UserRepository repository = RepositoryFactory.getUserRepository();
    /**
     * Creates new form UserSelect
     */
    public UserSelect() {
        initComponents();
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
        txtID = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnContinue1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Select User");
        setToolTipText("");

        jLabel3.setText("ID:");

        btnCancel.setText("Cancel");

        btnContinue1.setText("Continue");
        btnContinue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinue1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 307, Short.MAX_VALUE)
                        .addComponent(btnCancel)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(btnContinue1)
                    .addContainerGap(297, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(40, 40, 40))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(105, Short.MAX_VALUE)
                    .addComponent(btnContinue1)
                    .addGap(43, 43, 43)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinue1ActionPerformed
        
        if(!this.txtID.getText().isEmpty()){
            int value = 0;
            List<User> list = repository.Search(null);
        
            Long id = Long.valueOf(this.txtID.getText());
            for(User user: list){
                if(user.getId().equals(id)){
                   value = 1;
                   this.user = user;
                   break;
                }
            }
            if(value == 1){
                if(JOptionPane.showConfirmDialog(this, "This is Login" + user.getLogin() + ", with Name "+ user.getName() +"?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                    UserEdit screen = new UserEdit();
                    this.getParent().add(screen);
                    screen.setVisible(true);
                    screen.setUser(user);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(this, "Operation canceled!","Information", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "Id does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Have to fill in the fields!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.user = new User();
    }//GEN-LAST:event_btnContinue1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnContinue1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
