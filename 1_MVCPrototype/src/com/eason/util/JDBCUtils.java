package com.eason.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid Data Source Pool Util
 */
public class JDBCUtils {

    //1.Member Variable: DataSource
    private static DataSource ds ;

    static{
        try {
                //1.Load config
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.get DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function: get DataSouce
     */

    public static DataSource getDataSource(){
        return  ds;
    }
    /**
     * Function: get Connections
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * Release resources
     */
    public static void close(Statement stmt,Connection conn){

       close(null,stmt,conn);
    }


    public static void close(ResultSet rs , Statement stmt, Connection conn){


        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();//return connection ...not close!
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
