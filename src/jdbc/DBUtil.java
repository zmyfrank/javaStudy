package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: Frank
 * @Date: 2017/12/18 17:25
 */
@JDBCConfig(ip = "127.0.0.1", dataBase = "test", encoding = "UTF-8", loginName = "root", password = "admin")
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConection() throws SQLException {
        JDBCConfig jdbcConfig = DBUtil.class.getAnnotation(JDBCConfig.class);
        String ip = jdbcConfig.ip();
        int port = jdbcConfig.port();
        String database = jdbcConfig.dataBase();
        String encoding = jdbcConfig.encoding();
        String loginName = jdbcConfig.loginName();
        String password = jdbcConfig.password();
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        System.out.println(url);
        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConection();
        System.out.println(connection);
    }
}
