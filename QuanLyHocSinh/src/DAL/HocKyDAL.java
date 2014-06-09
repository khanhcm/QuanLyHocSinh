/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class HocKyDAL {
    private DataConnector con;
    
    public HocKyDAL(){
        con = new DataConnector();
    }
    
    public ResultSet layDanhSachHocKy(String tenNamHoc){
        int parameter = 1;
        Object[] value = new Object[parameter];
        value[0] = tenNamHoc;
        return con.ExecuteQuery("getHocKyFromNamHoc(?)", parameter, value);
    }
}
