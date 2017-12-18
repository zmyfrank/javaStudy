package jdbc;

import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/22 14:38
 */
public interface DAO {
    //添加
    public void add(Hero2 h);
    //修改
    public void update(Hero2 h);
    //删除
    public void delete(Hero2 h);
    //获取
    public Hero2 get(int id);
    //获取所有
    public List<Hero2> list();
    //分页查询
    public List<Hero2> list(int start,int count);
}
