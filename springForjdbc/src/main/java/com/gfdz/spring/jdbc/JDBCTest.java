package com.gfdz.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * Created by Administrator on 2015/9/29.
 */
public class JDBCTest {

    private ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource= (DataSource) ctx.getBean("dataSource");
        jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
        System.out.println(dataSource.getConnection());
    }
    /**
     * 执行INSERT，UPDATE，DELETE
     */
    @Test
    public void testUpdate(){
        String sql="UPDATE USER u SET u.'name'=415464 WHERE u.id=?";
        jdbcTemplate.execute(sql);
    }
}
