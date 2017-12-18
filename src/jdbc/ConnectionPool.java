package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/22 15:24
 */
public class ConnectionPool {
    List<Connection> connections = new ArrayList<>();
    int size;

    public ConnectionPool(int size) {
        this.size = size;
        init();
    }

    public void init() {
        //创建线程池
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < this.size; i++) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                connections.add(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection(){
        while (connections.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return connections.remove(0);
    }

    public synchronized void returnConnection(Connection c){
        connections.add(c);
        this.notifyAll();
    }

    public static void main(String[] args) {

    }
}
