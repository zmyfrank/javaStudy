package jdbc;

import java.sql.*;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/22 14:41
 */
public class HeroDao implements DAO {
    public HeroDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
    }

    @Override
    public void add(Hero2 h) {
        String addSql = "INSERT INTO hero VALUES (NULL,?,?,?)";
        try (
                Connection c = getConnection();
                PreparedStatement p = c.prepareStatement(addSql)
        ) {
            p.setString(1,h.name);
            p.setFloat(2,h.hp);
            p.setInt(3,h.damage);
            p.execute();
            ResultSet rs = p.getGeneratedKeys();
            int id = -1;
            if (rs.next()){
               id =  rs.getInt(1);
            }
            System.out.println("新增了英雄名为"+h.name+"ID为"+id+"的数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero2 h) {

    }

    @Override
    public void delete(Hero2 h) {

    }

    @Override
    public Hero2 get(int id) {
        return null;
    }

    @Override
    public List<Hero2> list() {
        return null;
    }

    @Override
    public List<Hero2> list(int start, int count) {
        return null;
    }

    public static void main(String[] args) {
        HeroDao heroDao = new HeroDao();
        heroDao.add(new Hero2(2,"提莫小明兽",23f,200));
    }
}
