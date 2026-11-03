/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Nitish
 */
public class CartFrame extends javax.swing.JFrame {
    
   
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CartFrame.class.getName());

    /**
     * Creates new form CartFrame
     */
    public CartFrame() {
        initComponents();
    }
    
     public CartFrame(java.util.ArrayList<Dashboard.CartItem> items){
        initComponents();
        
        setTitle("Shopping Cart");
        setSize(750, 550);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        
        //Main Panel
        javax.swing.JPanel mainPanel = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
        
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        //----------------------------HEADER
        javax.swing.JLabel title = new javax.swing.JLabel("SHOPPING CART");
        
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        mainPanel.add(title, java.awt.BorderLayout.NORTH);
        
        //------------------PRODUCT AREA-------------------------
        javax.swing.JPanel productPanel = new javax.swing.JPanel();
        
        productPanel.setLayout(new javax.swing.BoxLayout(productPanel, javax.swing.BoxLayout.Y_AXIS));
        if(items.isEmpty()){
            javax.swing.JLabel emptyLabel = new javax.swing.JLabel("Your cart is empty.");
            
            emptyLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            emptyLabel.setAlignmentX(javax.swing.JLabel.CENTER_ALIGNMENT);
            
            productPanel.add(emptyLabel);
            
        }
        else{
            for(Dashboard.CartItem item : items){
                javax.swing.JPanel row = new javax.swing.JPanel(new java.awt.GridLayout(1, 5, 10, 0));
                
                row.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                
                javax.swing.JLabel name = new javax.swing.JLabel(item.productName);
                javax.swing.JLabel price = new javax.swing.JLabel("Rs" + item.price);
                javax.swing.JLabel quantity = new javax.swing.JLabel("Qty:" + item.quantity);
                javax.swing.JLabel total = new javax.swing.JLabel("Rs" + item.getTotal());
                
                javax.swing.JButton remove = new javax.swing.JButton("Remove");
                row.add(name);
                row.add(price);
                row.add(quantity);
                row.add(total);
                row.add(remove);
                
                productPanel.add(row);
                
                //Remove Product
                remove.addActionListener(e -> {
                    items.remove(item);
                    dispose();
                    CartFrame newCart = new CartFrame(items);
                    
                    newCart.setVisible(true);
                });
            }
        }
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(productPanel);
        mainPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
        
        //----------BOTTOM AREA-------------------
        
        javax.swing.JPanel bottomPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
        double grandTotal = 0;
        
        for(Dashboard.CartItem item : items){
            grandTotal += item.getTotal();
        }
        final double finalGrandTotal = grandTotal;
        javax.swing.JLabel grandTotalLabel = new javax.swing.JLabel("Grand Total: Rs" + grandTotal);
        grandTotalLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        
        bottomPanel.add(grandTotalLabel, java.awt.BorderLayout.WEST);
        javax.swing.JButton checkoutButton = new javax.swing.JButton("CHECKOUT");
        
        checkoutButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        
        checkoutButton.addActionListener(e -> {
            if(items.isEmpty()){
                javax.swing.JOptionPane.showMessageDialog( this, "Your cart is empty!");
            }
                else{
                javax.swing.JOptionPane.showMessageDialog( this, "Order placed successfully!\n\n" + "Grand Total: Rs" + finalGrandTotal);
                items.clear();
                dispose();
            }
        });
        bottomPanel.add(checkoutButton, java.awt.BorderLayout.EAST);
        mainPanel.add(bottomPanel, java.awt.BorderLayout.SOUTH);
        getContentPane().setLayout( new java.awt.BorderLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);
        
       
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CartFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
