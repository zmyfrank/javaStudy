package jdbc;

import java.sql.*;

/**
 * @author: Frank
 * @Date: 2017/11/22 9:53
 */
public class SearchByPage {
    public static void list(int start, int count){
        //将页数转换为起始数
        int page = start*count - count;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "admin");
                Statement s = c.createStatement()
        ) {
            String sql = "SELECT * FROM hero LIMIT "+start+","+count;
            boolean rsd = s.execute(sql);
            if (rsd){
                ResultSet rs = s.getResultSet();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    float hp = rs.getFloat("hp");
                    int damage = rs.getInt("damage");
                    System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        list(3,5);
    }
}
