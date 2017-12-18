package jdbc;

import charactor.Hero;

import java.sql.*;
import java.util.Scanner;

/**
 * @author: Frank
 * @Date: 2017/11/21 14:04
 */
public class TestJdbc {

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                Scanner s = new Scanner(System.in);
                Statement st = c.createStatement();
                Statement std = c.createStatement()
        ) {
            //关闭自动上传
            c.setAutoCommit(false);
            ResultSet rs = st.executeQuery("SELECT id FROM hero ORDER BY id ASC LIMIT 0,10");
            while (rs.next()){
                int id = rs.getInt(1);
                System.out.println("试图删除id为"+id+"的数据");
                std.execute("DELETE FROM hero WHERE id ="+id);
            }
            while (true){
                System.out.println("是否要删除这十条数据Y/N");
                String str = s.next();
                if ("Y".equals(str)){
                    c.commit();
                    System.out.println("提交删除");
                    break;
                }else if ("N".equals(str)){
                    System.out.println("放弃删除");
                    break;
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
