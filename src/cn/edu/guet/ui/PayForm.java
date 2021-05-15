/*
 * Created by JFormDesigner on Sun May 09 17:01:25 CST 2021
 */

package cn.edu.guet.ui;

import cn.edu.guet.pay.Main;
import cn.edu.guet.util.ShowQRCode;
import com.sun.awt.AWTUtilities;

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
        label6 = new JLabel();
        label7 = new JLabel();
        textField6 = new JTextField();
        textField7 = new JTextField();
        label8 = new JLabel();
        textField8 = new JTextField();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 12));
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
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 12f));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(50, 375), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u4ed8\u6b3e\u7801\u652f\u4ed8");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 12f));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(250, 375), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u626b\u7801\u652f\u4ed8");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 12f));
        contentPane.add(button3);
        button3.setBounds(470, 375, 145, 35);

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

        //---- label6 ----
        label6.setText("\u5546\u54c1\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 12f));
        contentPane.add(label6);
        label6.setBounds(430, 15, 80, 45);

        //---- label7 ----
        label7.setText("\u6570\u91cf\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 12f));
        contentPane.add(label7);
        label7.setBounds(430, 65, 80, 45);
        contentPane.add(textField6);
        textField6.setBounds(495, 25, 230, 35);
        contentPane.add(textField7);
        textField7.setBounds(495, 65, 230, 35);

        //---- label8 ----
        label8.setText("\u6761\u5f62\u7801\uff1a");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 12f));
        contentPane.add(label8);
        label8.setBounds(415, 210, 115, 40);
        contentPane.add(textField8);
        textField8.setBounds(500, 215, 230, 35);

        contentPane.setPreferredSize(new Dimension(780, 505));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        //PayCodeForm.setUndecorated(true);//去边框（就是标题栏那个框框）
        //AWTUtilities.setWindowOpaque(PayCodeForm, false);//设置背景透明
        //button1.setBackground(Color.white);




        button1.addActionListener(//现金支付
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Thread t1=new Thread(
                                new Runnable(){
                                    @Override
                                    public void run() {
                                        String ze=textField1.getText();
                                        String yh=textField2.getText();
                                        float h=Float.parseFloat(ze) - Float.parseFloat(yh);
                                        String str1 = String.valueOf(h);
                                        textField3.setText(str1);
                                    }
                                }
                        );
                        Thread t2=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        String yf=textField3.getText();
                                        String sf=textField4.getText();
                                        float c=Float.parseFloat(sf) - Float.parseFloat(yf);
                                        textField5.setText(String.format("%.2f", c).toString());
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

        button2.addActionListener(   //付款码支付
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Thread t1=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        Main main = new Main();
                                        main.test_trade_precreate(textField3.getText());
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
                        Thread t3=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        Main main = new Main();
                                        java.util.List<File> qrCodeList = ShowQRCode.getFileSort("D:/Shop/二维码/");
                                        String addr = qrCodeList.get(qrCodeList.size() - 1).getAbsolutePath();
                                        String num = addr.substring(15, 49);
                                        System.out.println(num);
                                        while (true) {
                                            try {
                                                Thread.sleep(3000);
                                            } catch (InterruptedException exception) {
                                                exception.printStackTrace();
                                            }

                                            String result = main.test_trade_query(num);
                                            if (result == "success") {
                                                PayCodeForm.setVisible(false);
                                            }

                                        }
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
                        try {
                            t2.join();//必须等t2执行完毕
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        t3.start();
                    }
                }
        );

        button3.addActionListener(     //扫码支付
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String authCode=textField8.getText();//拿到付款条码
                        textField8.setText("");
                        textField4.setText(textField3.getText());
                        textField5.setText("0");
                        Main main = new Main();
                        main.test_trade(authCode,textField3.getText());
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
    private JLabel label6;
    private JLabel label7;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel label8;
    private JTextField textField8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    PayCodeForm PayCodeForm=null;
}
