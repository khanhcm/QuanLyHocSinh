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
public class GiaoVienDAL {
    private DataConnector con;
    
    public GiaoVienDAL(){
        con = new DataConnector();
    }
    
    public ResultSet layGiaoVienTheoLop(String tenLop, String tenNamHoc){
        int parameter = 2;
        Object[] value = new Object[parameter];
        value[0] = tenLop;
        value[1] = tenNamHoc;
        return con.ExecuteQuery("LayGVCNTheoLop(?,?)", parameter, value);
    }
}
