####04-23

- 创建LoginForm
- 给登录按钮添加监听事件
- 创建user表

```sql
CREATE TABLE  shopusers(
    id NUMBER(10) PRIMARY KEY,
    username VARCHAR2(20),
    password VARCHAR2(100)--MD5加密
);
```

```sql
INSERT INTO shopusers VALUES (1800301303,'wsn','wsn1234');

SELECT COUNT(*) FROM shopusers WHERE username='wsn' and password='wsn1234';
```
```java
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
                        String sql="SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'";
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
```
- MD5加密
1、





