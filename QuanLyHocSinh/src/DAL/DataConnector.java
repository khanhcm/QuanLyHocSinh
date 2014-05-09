/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CaoMinh
 * DataConnector class
 * Connect to MySQL Database
 */
public class DataConnector {
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String urlConnection = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "";
    private static Connection connection = null;
      
    public Connection getConnection() {
        
        try {
            Class.forName(driverName).newInstance();    
            connection = DriverManager.getConnection(urlConnection, user, password);
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            out.println(e);
        } catch (SQLException ex) {
              Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
          }
        return connection;
    }
    
    public void disconnection() {
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
        
    public ResultSet ExecuteQuery(String nameSR) {
        Connection conn = getConnection();        
        String sql = "{call " + nameSR + "}";
        CallableStatement cs;
        ResultSet rs = null;
        try {
              cs = conn.prepareCall(sql);
              rs = cs.executeQuery();                    
        }
        catch (SQLException ex) {
              Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
          }
        return rs;
    }
    
    public ResultSet ExecuteQuery(String nameSR, int para, Object [] line) {
        Connection conn = getConnection();        
        String sql = "{call " + nameSR + "}";
        CallableStatement cs;
        ResultSet rs = null;
        try {
              cs = conn.prepareCall(sql);
              for (int i = 1; i <= para; i++) {
                  cs.setObject(i, line[i]);
              }
              rs = cs.executeQuery();                    
        }
        catch (SQLException ex) {
              Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
          }
        return rs;
    }
    
    
    public CallableStatement getData(String nameSR, int para, Object [] line) {
        Connection conn = getConnection();
        String sql = "{call " + nameSR + "}";
        CallableStatement cs = null;        
        try {
              cs = conn.prepareCall(sql);  
              for (int i = 1; i <= para; i++) {
                  cs.setObject(i, line[i]);
              }
              cs.execute();
        }
        catch (SQLException ex) {
              Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
          }
        return cs;
    }
}
