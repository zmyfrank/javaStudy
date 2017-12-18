package jdbc;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
/**
 * @author: Frank
 * @Date: 2017/12/18 16:59
 */
public @interface JDBCConfig {
    String ip();
    int port()default 3306;
    String dataBase();
    String encoding();
    String loginName();
    String password();
}
