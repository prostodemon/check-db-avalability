package cdba;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== cdba.SqlExecResult.java ==========
 * <p/>
 * $Revision:  $<br/>
 * $Author:  $<br/>
 * $HeadURL:  $<br/>
 * $Id:  $
 * <p/>
 * 20.10.14 19:56: Original version (ilya)<br/>
 */
public class SqlExecResult {
    String sql;
    Long time;
    Integer rowCount;

    public SqlExecResult(String sql, Long time, Integer rowCount) {
        this.sql = sql;
        this.time = time;
        this.rowCount = rowCount;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public String toString() {
        return "SqlExecResult{" +
                "sql='" + sql + '\'' +
                ", time=" + time +
                ", rowCount=" + rowCount +
                "} " + super.toString();
    }
}
