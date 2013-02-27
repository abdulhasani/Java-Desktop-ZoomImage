/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.program;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import san.jmat.render.combo.ComboZoomIn;
import san.jmat.render.combo.ComboZoomOut;
import san.jmat.render.panel.PanelGambar;

/**
 *
 * @author joker
 */
public class Program extends javax.swing.JFrame {

    /**
     * Creates new form Program
     */
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("JMat", "jpg", "png");
    private JFileChooser fileChooser = new JFileChooser();
    private File Directorio = fileChooser.getCurrentDirectory();
    private DefaultComboBoxModel model;
    private Boolean deteksiGambar = false;
    private PanelGambar panelGambar;

    public Program() {
        initComponents();
        model = new DefaultComboBoxModel();
        setSize(600, 400);
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelDasar1 = new san.jmat.render.panel.PanelDasar();
        panelPapan1 = new san.jmat.render.panel.PanelPapan();
        jPanel1 = new javax.swing.JPanel();
        open1 = new san.jmat.render.button.Open();
        rdPerbesar = new javax.swing.JRadioButton();
        rdPerkecil = new javax.swing.JRadioButton();
        comboZoom = new javax.swing.JComboBox();
        reset1 = new san.jmat.render.button.Reset();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDasar1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelPapan1Layout = new javax.swing.GroupLayout(panelPapan1);
        panelPapan1.setLayout(panelPapan1Layout);
        panelPapan1Layout.setHorizontalGroup(
            panelPapan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelPapan1Layout.setVerticalGroup(
            panelPapan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        panelDasar1.add(panelPapan1, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);

        open1.setToolTipText("Open Gambar");
        open1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open1ActionPerformed(evt);
            }
        });
        jPanel1.add(open1);

        buttonGroup1.add(rdPerbesar);
        rdPerbesar.setText("Perbesar");
        rdPerbesar.setToolTipText("");
        rdPerbesar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdPerbesarItemStateChanged(evt);
            }
        });
        jPanel1.add(rdPerbesar);

        buttonGroup1.add(rdPerkecil);
        rdPerkecil.setText("Perkecil");
        rdPerkecil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdPerkecilItemStateChanged(evt);
            }
        });
        jPanel1.add(rdPerkecil);

        comboZoom.setToolTipText("Pilih Ukuran");
        comboZoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboZoomItemStateChanged(evt);
            }
        });
        jPanel1.add(comboZoom);

        reset1.setToolTipText("Reset Gambar");
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });
        jPanel1.add(reset1);

        panelDasar1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelDasar1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdPerbesarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdPerbesarItemStateChanged
        // TODO add your handling code here:
        model.removeAllElements();
        model.addElement("Perbesar");
        model.addElement("100");
        model.addElement("75");
        model.addElement("50");
        model.addElement("25");
        comboZoom.setModel(model);
        comboZoom.setRenderer(new ComboZoomIn());
        
        
    }//GEN-LAST:event_rdPerbesarItemStateChanged
    
    private void rdPerkecilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdPerkecilItemStateChanged
        // TODO add your handling code here:
        model.removeAllElements();
        model.addElement("Perkecil");
        model.addElement("100");
        model.addElement("75");
        model.addElement("50");
        model.addElement("25");
        comboZoom.setModel(model);
        comboZoom.setRenderer(new ComboZoomOut());
        
    }//GEN-LAST:event_rdPerkecilItemStateChanged
    
    private void open1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open1ActionPerformed
        // TODO add your handling code here:
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(Directorio);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            deteksiGambar = true;
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            try {
                panelGambar = new PanelGambar();
                
                panelGambar.setBufferedImage(ImageIO.read(fileChooser.getSelectedFile()));
                this.panelPapan1.removeAll();
                this.panelPapan1.add(panelGambar);
                this.panelPapan1.repaint();
                this.Directorio = fileChooser.getCurrentDirectory();
                setTitle("File Name = " + fileChooser.getName(Directorio));
            } catch (IOException ex) {
                System.out.println("error: " + ex);
            }
        }
    }//GEN-LAST:event_open1ActionPerformed
    
    private void comboZoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboZoomItemStateChanged
        // TODO add your handling code here:
        try{
        if (rdPerbesar.isSelected()) {
            String selectedItem = (String) model.getSelectedItem();
            panelGambar.zoomIn(Integer.parseInt(selectedItem));
        } else {
            String selectedItem = (String) model.getSelectedItem();
            panelGambar.zoomOut(Integer.parseInt(selectedItem));
        }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_comboZoomItemStateChanged

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        // TODO add your handling code here:
        panelGambar.reset();
    }//GEN-LAST:event_reset1ActionPerformed

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
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Program().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboZoom;
    private javax.swing.JPanel jPanel1;
    private san.jmat.render.button.Open open1;
    private san.jmat.render.panel.PanelDasar panelDasar1;
    private san.jmat.render.panel.PanelPapan panelPapan1;
    private javax.swing.JRadioButton rdPerbesar;
    private javax.swing.JRadioButton rdPerkecil;
    private san.jmat.render.button.Reset reset1;
    // End of variables declaration//GEN-END:variables
}
