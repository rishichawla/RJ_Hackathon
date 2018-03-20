
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Profile extends javax.swing.JFrame {
public static Connection c = null;
public static Statement s = null;
public static ResultSet rs = null;
public static String path;
public void connect()
{
    try
    {
        Class.forName("java.sql.DriverManager");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackathon","root","admin");
        s = c.createStatement();
    }
    catch (Exception e)
    {
            JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
public ImageIcon ResizeImage(String imgPath)
{
    ImageIcon MyImage=new ImageIcon(imgPath);
    Image img=MyImage.getImage();
    Image newImage=img.getScaledInstance(jLabel5.getWidth(),jLabel5.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon image=new ImageIcon(newImage);
    return image;
}
    /**
     * Creates new form Profile
     */
    public Profile() {
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
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Name:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 100, 35, 14);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Age:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 189, 24, 14);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Mobile No.:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 278, 62, 14);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Email ID:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 367, 51, 14);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setText("Change Password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(268, 431, 125, 23);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(884, 132, 200, 200);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back-arrow-hi (1).jpeg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(1051, 11, 50, 50);

        jButton5.setText("View Transaction Summary");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(923, 381, 161, 50);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(726, 100, 152, 14);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(737, 189, 141, 14);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(726, 278, 152, 14);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(337, 367, 383, 14);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sahara Desert, Morocco.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 1180, 560);

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try
{
    connect();
    String pass = JOptionPane.showInputDialog(rootPane, "Enter New Password", "Change Password", QUESTION_MESSAGE);
    String q = "Update user_credentials set password = '"+pass+"' where id = '"+Login_Page.ID+"';";
    s.executeUpdate(q);
}
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
try
{
    connect();
    String q = "Select Name, Age, Mobile, Email, picture from user_info where id = '"+Login_Page.ID+"';";
    rs = s.executeQuery(q);
    if (rs.next())
    {
        jLabel6.setText(rs.getString("Name"));
        jLabel7.setText(Integer.toString(rs.getInt("Age")));
        jLabel8.setText(rs.getString("Mobile"));
        jLabel9.setText(rs.getString("Email"));
        byte[] img = rs.getBytes("picture");
        ImageIcon MyImage = new ImageIcon(img);
        Image ima = MyImage.getImage();
        Image newImage = ima.getScaledInstance(jLabel5.getWidth(),jLabel5.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(newImage);
        jLabel5.setIcon(image);
    }
}
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    }//GEN-LAST:event_formComponentShown

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
new Dashboard().setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
new Transactions().setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
