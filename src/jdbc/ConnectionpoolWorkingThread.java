package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: Frank
 * @Date: 2017/11/22 16:24
 */
public class ConnectionpoolWorkingThread extends Thread {
    private ConnectionPool cp;

    public ConnectionpoolWorkingThread(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public void run() {
        String sql = "INSERT INTO hero VALUES (NULL,?,?,?)";
        Connection c = cp.getConnection();
        try (
                PreparedStatement p = c.prepareStatement(sql)
        ) {
            //使用线程处理数据
            for (int i = 0; i < TestConnectionPool.insertTime; i++) {
                p.setString(1,"小提莫"+1);
                p.setFloat(2,200f);
                p.setInt(3,300);
                p.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //还回线程
        cp.returnConnection(c);
    }
}
