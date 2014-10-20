package cdba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== RequestRepository.java ==========
 * <p/>
 * $Revision:  $<br/>
 * $Author:  $<br/>
 * $HeadURL:  $<br/>
 * $Id:  $
 * <p/>
 * 20.10.14 19:47: Original version (ilya)<br/>
 */
@Repository
public class SqlToTimeExecutor {

    @Autowired
    protected org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    public SqlExecResult executeQuery(String sql) {
        Date start = new Date();

        RowCountCallbackHandler rch = new RowCountCallbackHandler();
        jdbcTemplate.query(sql, rch);

        Date end = new Date();

        return new SqlExecResult(sql, end.getTime() - start.getTime(), rch.getRowCount());
    }
}
