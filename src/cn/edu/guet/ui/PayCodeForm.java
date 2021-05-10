/*
 * Created by JFormDesigner on Sun May 09 17:23:11 CST 2021
 */

package cn.edu.guet.ui;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class PayCodeForm extends JFrame {
    public PayCodeForm(String qrCodePath) {
        initComponents(qrCodePath);
    }

    private void initComponents(String qrCodePath) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        setBak(qrCodePath);
        JPanel jp = new JPanel(); // 创建个JPanel
        jp.setOpaque(false); // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
        setSize(540, 450);
        setVisible(false);
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(jp);

        contentPane.setPreferredSize(new Dimension(300, 310));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }
    public void setBak(String qrCodePath) {
        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon(qrCodePath);
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
