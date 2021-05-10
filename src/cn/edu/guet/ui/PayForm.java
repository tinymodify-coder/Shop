/*
 * Created by JFormDesigner on Sun May 09 17:01:25 CST 2021
 */

package cn.edu.guet.ui;

import cn.edu.guet.pay.Main;
import cn.edu.guet.util.ShowQRCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 * @author 1
 */
public class PayForm extends JFrame {
    public static void main(String[] args) {
        new PayForm();
    }
    public PayForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        textField4 = new JTextField();
        textField5 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u603b\u989d\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 12f));
        contentPane.add(label1);
        label1.setBounds(45, 10, 80, 45);

        //---- label2 ----
        label2.setText("\u4f18\u60e0\u91d1\u989d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 12f));
        contentPane.add(label2);
        label2.setBounds(30, 55, 135, 50);

        //---- label3 ----
        label3.setText("\u5e94\u4ed8\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 12f));
        contentPane.add(label3);
        label3.setBounds(45, 105, 85, 40);
        contentPane.add(textField1);
        textField1.setBounds(165, 15, 230, 35);
        contentPane.add(textField2);
        textField2.setBounds(165, 65, 230, 35);
        contentPane.add(textField3);
        textField3.setBounds(165, 115, 230, 35);

        //---- button1 ----
        button1.setText("\u73b0\u91d1\u652f\u4ed8");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 10f));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(10, 290), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u4ed8\u6b3e\u7801\u652f\u4ed8");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 10f));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(150, 290), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u626b\u7801\u652f\u4ed8");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 10f));
        contentPane.add(button3);
        button3.setBounds(320, 290, 110, 35);

        //---- label4 ----
        label4.setText("\u5b9e\u4ed8\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 12f));
        contentPane.add(label4);
        label4.setBounds(45, 160, 85, 40);

        //---- label5 ----
        label5.setText("\u627e\u96f6\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 12f));
        contentPane.add(label5);
        label5.setBounds(45, 210, 85, 40);
        contentPane.add(textField4);
        textField4.setBounds(165, 165, 230, 35);
        contentPane.add(textField5);
        textField5.setBounds(165, 215, 230, 35);

        contentPane.setPreferredSize(new Dimension(465, 385));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        button2.addActionListener(   //付款码支付
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Thread t1=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        Main main = new Main();
                                        main.test_trade_precreate();
                                        //按时间顺序显示D盘下的所有png的图片
                                        //在t1线程中把最后一个图片路径拿到，然后作为参数传入
                                        java.util.List<File> qrCodeList= ShowQRCode.getFileSort("D:/Shop/二维码/");
                                        System.out.println("最后一个图片的路径："+qrCodeList.get(qrCodeList.size() - 1).getAbsolutePath());
                                        PayCodeForm=new PayCodeForm(qrCodeList.get(qrCodeList.size()-1).getAbsolutePath()/*图片路径*/);
                                    }
                                }
                        );
                        Thread t2=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        //等待二维码生成后，才能调用下面的类去显示二维码
                                        PayCodeForm.setVisible(true);
                                    }
                                }
                        );
                        t1.start();
                        try {
                            t1.join();//必须等t1执行完毕
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        t2.start();
                    }
                }
        );

        button3.addActionListener(     //扫码支付
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String authCode=textField1.getText();//拿到付款条码
                        textField1.setText("");
                        Main main = new Main();
                        main.test_trade(authCode);
                    }
                }
        );


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭进程也关闭


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField4;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    PayCodeForm PayCodeForm=null;
}
