package jdbc;


import charactor.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/22 11:41
 */
public class HeroORM {
    /**
     * 添加英雄
     *
     * @param h 当前英雄
     */
    public static void add(Hero2 h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String addHero2Sql = "INSERT INTO hero VALUES (NULL,?,?,?)";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement preparedStatement = c.prepareStatement(addHero2Sql)
        ) {
            preparedStatement.setString(1, h.name);
            preparedStatement.setFloat(2, h.hp);
            preparedStatement.setInt(3, h.damage);
            preparedStatement.execute();
            System.out.println("成功添加姓名为" + h.name + "的英雄");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除英雄
     *
     * @param h 当前英雄
     */
    public static void delete(Hero2 h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String deldeteHero2Sql = "DELETE FROM hero WHERE id = ?";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement preparedStatement = c.prepareStatement(deldeteHero2Sql)
        ) {
            preparedStatement.setInt(1, h.id);
            preparedStatement.execute();
            System.out.println("成功删除id为" + h.id + "的英雄");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改英雄
     *
     * @param h 当前英雄
     */
    public static void update(Hero2 h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String updateHeroSql = "UPDATE hero SET name = ? ,hp= ? ,damage = ? WHERE id=?";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement preparedStatement = c.prepareStatement(updateHeroSql)
        ) {
            preparedStatement.setString(1, h.name);
            preparedStatement.setFloat(2, h.hp);
            preparedStatement.setInt(3, h.damage);
            preparedStatement.setInt(4, h.id);
            preparedStatement.execute();
            System.out.println("修改成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取英雄
     *
     * @param id 传入搜索的id
     * @return 搜索出来的英雄
     */
    public static Hero2 get(int id) {
        Hero2 h = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String getHeroSql = "SELECT * FROM hero WHERE id = ?";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement preparedStatement = c.prepareStatement(getHeroSql)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                h = new Hero2(id, rs.getString(2), rs.getFloat(3), rs.getInt(4));
            }
            return h;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回所有的英雄
     *
     * @return 所有英雄的list
     */
    public static List<Hero2> list() {
        List<Hero2> hero2s = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String getHeroSql = "SELECT * FROM hero";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                PreparedStatement preparedStatement = c.prepareStatement(getHeroSql)
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Hero2 h = new Hero2(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
                hero2s.add(h);
            }
            return hero2s;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        List<Hero2> hero2s = list();
        System.out.println(hero2s.size());
        Hero2 hero21 = get(600);
        assert hero21 != null;
        System.out.println("取出id为101的数据，它的名字为" + hero21.name);
        delete(hero21);
        hero2s = list();
        System.out.println(hero2s.size());
    }

}
