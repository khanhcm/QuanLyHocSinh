/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class MonHocDAL {
    private DataConnector con;
    
    public MonHocDAL(){
        con = new DataConnector();
    }
    
    public ResultSet layMonHocTheoNam(String tenNamHoc){
        int parameter = 1;
        Object[] value = new Object[parameter];
        value[0] = tenNamHoc;
        return con.ExecuteQuery("LayMonHocTheoNamHoc(?)", parameter, value);
    }
    
    public Connection getConnection(){
        return con.getConnection();
    }
}
