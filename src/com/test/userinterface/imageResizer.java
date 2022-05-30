/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.userinterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Ahsan
 */
public class imageResizer extends javax.swing.JFrame {

    /**
     * Creates new form imageResizer
     */
    int imgLblInitialHeight ;
    Dimension windowDimension ;
    boolean isApprove;
    String filePath;
    
    public imageResizer() {
        initComponents();
        windowDimension = getToolkit().getScreenSize();
        imgLblInitialHeight = imgLabel.getHeight();
        isApprove = false;
        filePath = "";
        //ImageIcon i = new ImageIcon(getClass().getResource("/com/test/images/saved.png"));
        //imgLabel.setIcon(i);
        
//        createNewImg("PPaper","Paper","png","blue");
//        createNewImg("PPaperInverted","PaperInverted","png","blue");
//        createNewImg("RRock","Rock","png","blue");
//        createNewImg("RRockInverted","RockInverted","png","blue");
//        createNewImg("SScissor","Scissor","png","blue");
//        createNewImg("SScissorInverted","ScissorInverted","png","blue");
    }

    void createNewImg(String fileName, String nameOfNewFile,String extension, String backGroundColor, Component canvas){
                ImageIcon i;
                Image im;
                i = new ImageIcon(getClass().getResource("/images/%s.%s".formatted(fileName,extension)));
                im = i.getImage();
                //im = im.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
                //i = new ImageIcon(im);
                
                //im = i.getImage();
                
                try {
                    
                    BufferedImage bim = new BufferedImage
                    (im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
                    //bim.setRGB(20, 20, 1);
                    //bim.c
                    
                    int imgWidth = im.getWidth(null);
        int imgHeight = im.getHeight(null);
         
        double imgAspect = (double) imgHeight / imgWidth;
 
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
         
        double canvasAspect = (double) canvasHeight / canvasWidth;
 
        int x1 = 0; // top left X position
        int y1 = 0; // top left Y position
        int x2 = 0; // bottom right X position
        int y2 = 0; // bottom right Y position
         
        if (imgWidth < canvasWidth && imgHeight < canvasHeight) {
            // the image is smaller than the canvas
            x1 = (canvasWidth - imgWidth)  / 2;
            y1 = (canvasHeight - imgHeight) / 2;
            x2 = imgWidth + x1;
            y2 = imgHeight + y1;
             
        } else {
            if (canvasAspect > imgAspect) {
                y1 = canvasHeight;
                // keep image aspect ratio
                canvasHeight = (int) (canvasWidth * imgAspect);
                y1 = (y1 - canvasHeight) / 2;
            } else {
                x1 = canvasWidth;
                // keep image aspect ratio
                canvasWidth = (int) (canvasHeight / imgAspect);
                x1 = (x1 - canvasWidth) / 2;
            }
            x2 = canvasWidth + x1;
            y2 = canvasHeight + y1;
        }
                    
                    
                    Graphics bg = bim.getGraphics();
                    //bg.dr
                    //bg.drawIm
                    bg.drawImage(im, x1, y1, x2, y2, 0, 0, imgWidth, imgHeight,Color.BLUE , null);
                    //bg.drawImage(im, 0, 0,Color.BLUE, null);
                    bg.setColor(Color.red);
                    bg.dispose();
                    
                    // retrieve image
                    BufferedImage bi = bim;
                    File outputfile = new File("%s.%s".formatted(nameOfNewFile,extension));
                    ImageIO.write(bi, "png", outputfile);
                } catch (IOException ioe) {

                }
    }
    
    void createResizedImg(String fileName, String nameOfNewFile,String extension, String backGroundColor, Component canvas){
    
        File inputFile = new File(("/images/%s.%s".formatted(fileName,extension)));
        BufferedImage inputImage;
        try {
            
            inputImage = ImageIO.read(inputFile);
            
            int scaledWidth = imgLabel.getWidth(); 
        int scaledHeight = imgLabel.getHeight();
        
        
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        //String formatName = outputImagePath.substring(outputImagePath
          //      .lastIndexOf(".") + 1);
 
        // writes to output file
        File outputfile = new File("%s.%s".formatted(nameOfNewFile,extension));
        ImageIO.write(outputImage, "png", outputfile);
            
        } catch (IOException ex) {
            Logger.getLogger(imageResizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jColorChooser1 = new javax.swing.JColorChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        imgLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        widthField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        heightField = new javax.swing.JTextField();
        rotateBtn = new javax.swing.JButton();
        chooseColorBtn1 = new javax.swing.JButton();
        chooseImageBtn = new javax.swing.JButton();
        chooseColorBtn = new javax.swing.JButton();
        resizeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imgLabel.setBackground(new java.awt.Color(0, 0, 250));
        imgLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        imgLabel.setOpaque(true);
        imgLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                imgLabelMouseDragged(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("WIDTH");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        widthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widthFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 131;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 0);
        jPanel1.add(widthField, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("HEIGHT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 15, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        heightField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 10);
        jPanel1.add(heightField, gridBagConstraints);

        rotateBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rotateBtn.setText("ROTATE");
        rotateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotateBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel1.add(rotateBtn, gridBagConstraints);

        chooseColorBtn1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chooseColorBtn1.setText("FLIP");
        chooseColorBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseColorBtn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 154;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 10);
        jPanel1.add(chooseColorBtn1, gridBagConstraints);

        chooseImageBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chooseImageBtn.setText("SELECT IMAGE");
        chooseImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel1.add(chooseImageBtn, gridBagConstraints);

        chooseColorBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chooseColorBtn.setText("SELECT Color");
        chooseColorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseColorBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 106;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 10);
        jPanel1.add(chooseColorBtn, gridBagConstraints);

        resizeBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resizeBtn.setText("RESIZE");
        resizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resizeBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 323;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 1, 10);
        jPanel1.add(resizeBtn, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseColorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseColorBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseColorBtnActionPerformed

    private void chooseImageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImageBtnActionPerformed
        
        if(jFileChooser1.showOpenDialog(null) == jFileChooser1.APPROVE_OPTION){
            filePath = jFileChooser1.getSelectedFile().getAbsolutePath();
            isApprove = true;
            imgLabel.setIcon(new ImageIcon(filePath));
        }
        
    }//GEN-LAST:event_chooseImageBtnActionPerformed

    private void rotateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotateBtnActionPerformed

    private void chooseColorBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseColorBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseColorBtn1ActionPerformed

    private void widthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_widthFieldActionPerformed

    private void resizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resizeBtnActionPerformed
        // TODO add your handling code here:

//        ImageIcon i;
//        Image im;
//        i = new ImageIcon(filePath);
//        im = i.getImage();
//        im = im.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
//        i = new ImageIcon(im);
//
//        im = i.getImage();
//
//        try {
//
//            BufferedImage bim = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
//            //bim.setRGB(20, 20, 1);
//            //bim.c
//            Graphics bg = bim.getGraphics();
//            bg.drawImage(im, 0, 0, Color.BLUE, null);
//            bg.setColor(Color.red);
//            bg.dispose();
//
//            // retrieve image
//            BufferedImage bi = bim;
//            File outputfile = new File("ABC.png");
//            ImageIO.write(bi, "png", outputfile);
//        } catch (IOException ioe) {
//
//        }

        File inputFile = new File(filePath);
        BufferedImage inputImage;
        try {
            
            inputImage = ImageIO.read(inputFile);
            
            int scaledWidth = imgLabel.getWidth(); 
            int scaledHeight = imgLabel.getHeight();
        
        
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        //String formatName = outputImagePath.substring(outputImagePath
          //      .lastIndexOf(".") + 1);
 
        // writes to output file
        File outputfile = new File("%s.%s".formatted(nameOfNewFile,extension));
        ImageIO.write(outputImage, "png", outputfile);
            
        } catch (IOException ex) {
            Logger.getLogger(imageResizer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResampleOp resizeOp = new ResampleOp();
resizeOp.setFilter(ResampleFilters.getLanczos3Filter());
BufferedImage scaledImage = resizeOp.filter(imageToScale, null);
    }//GEN-LAST:event_resizeBtnActionPerformed

    private void imgLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgLabelMouseDragged
        // TODO add your handling code here:
        Point point = (Point)evt.getPoint();
        System.out.println("X = " + point.getX());
        System.out.println("Y = " + point.getY());
        
        Dimension d = new Dimension((int)point.getX(), (int)point.getY());
        double labelFrameHorizontalGap = this.getWidth()  - d.getWidth();
        double labelFrameVerticalGap = Math.abs(d.getHeight() - imgLblInitialHeight) ;
        double labelFrameVerticalGap1 = this.getHeight() - imgLblInitialHeight;
        System.out.println("labelFrameVerticalGap " + labelFrameVerticalGap);
        
        if( labelFrameHorizontalGap < 20.0){
            
            this.setSize(this.getWidth() + 20, this.getHeight());
        }
        
        if( d.getHeight() > imgLblInitialHeight){
            System.out.println("hi");
            this.setSize(this.getWidth(), this.getHeight() + (int)labelFrameVerticalGap);
            d = new Dimension((int)d.getWidth(), (int)labelFrameVerticalGap1);
        }
        imgLabel.setSize(d);
        System.out.println("height " + imgLabel.getHeight());
        
        
        //imgLabel.repaint();
    }//GEN-LAST:event_imgLabelMouseDragged

    private void heightFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heightFieldActionPerformed

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
            java.util.logging.Logger.getLogger(imageResizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(imageResizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(imageResizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(imageResizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new imageResizer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseColorBtn;
    private javax.swing.JButton chooseColorBtn1;
    private javax.swing.JButton chooseImageBtn;
    private javax.swing.JTextField heightField;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton resizeBtn;
    private javax.swing.JButton rotateBtn;
    private javax.swing.JTextField widthField;
    // End of variables declaration//GEN-END:variables
}
