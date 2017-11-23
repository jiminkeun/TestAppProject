package mytest.syscore.daou.mytest.sqlmap;

/**
 * Created by daou on 2017-11-23.
 */

public class MemberDBSqlData {
    public static final String SQL_DB_CREATE_TABLE
            = "CREATE TABLE IF NOT EXIST MEMBER " +
            "(NO INTEGER, NAME TEXT, AGE INTEGER, SEX TEXT, BIRTHDAY TEXT, JOB TEXT, ADDR TEXT)";

    public static final String SQL_DB_INSERT_DATA
            = "INSERT INTO MEMBER (" +
                "NO, NAME, AGE, SEX, BIRTHDAY, JOB, ADD" +
            ") VALUES ( " +
                "?, ?, ?, ?, ?, ?, ?" +
            ")";

    public static final String SQL_DB_SELECT_ALL
            = "SELECT " +
                "NO, NAME, AGE, SEX, BIRTHDAY, JOB, ADDR " +
            "FROM MEMBER" +
            "ORDER BY NO";

    public static final String SQL_DB_DELETE_DATA
            = "DELETE FROM MEMBER " +
            "WHERE NO = ?";
}
