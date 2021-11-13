package common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    private static BasicDataSource basicDataSource = new BasicDataSource();
    static
    {
        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("amirhossein");
        basicDataSource.setPassword("1234");
        basicDataSource.setMaxTotal(15);
    }

    public static Connection getConnection()throws Exception
    {
        return basicDataSource.getConnection();
    }
}
