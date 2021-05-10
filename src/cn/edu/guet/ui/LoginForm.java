package cn.edu.guet.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Apr 23 20:07:47 CST 2021
 */

/**
 * @author unknown
 */
public class LoginForm extends JFrame {
    public static void main(String[] args) {
        new LoginForm();
    }
    public LoginForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField("wsn");
        label2 = new JLabel();
        textField2 = new JTextField("wsn1234");
        button1 = new JButton();//登录按钮
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //拿到用户名和密码
                        String username=textField1.getText();//获取用户名
                        String password=textField2.getText();//获取密码

                        Connection conn=null;
                        String url="jdbc:oracle:thin:@47.113.217.47:1521:orcl";
                        Statement stmt=null;//SQL语句对象，拼SQL
                        String sql="SELECT * FROM shopusers WHERE username='"+username+"' AND password='"+password+"'";
                        System.out.println("即将执行的sql："+sql);
                        ResultSet rs=null;
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");//
                            conn= DriverManager.getConnection(url,"scott","tiger");
                            stmt=conn.createStatement();
                            rs=stmt.executeQuery(sql);
                            if(rs.next()){   //游标
                                System.out.println("登录成功");
                                //显示售货
                            }else{
                                System.out.println("登录失败");
                            }

                        } catch (ClassNotFoundException ee) {
                            ee.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        finally {
                            //释放资源：数据库连接很昂贵
                            try {
                                rs.close();
                                stmt.close();
                                conn.close();//关连接
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(120, 100, 65, 25);
        contentPane.add(textField1);
        textField1.setBounds(215, 90, 125, 40);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(120, 175, 55, 25);
        contentPane.add(textField2);
        textField2.setBounds(220, 170, 125, 40);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(125, 240), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(260, 240), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(470, 355));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭进程也关闭
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
