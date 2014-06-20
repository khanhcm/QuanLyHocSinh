/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.ResultSet;

/**
 *
 * @author EvilZ
 */
public class BaoCaoMonHocDAL {
    private DataConnector con;
    
    public BaoCaoMonHocDAL(){
        con = new DataConnector();
    }
    
    public ResultSet layBaoCaoMonHoc(String tenNamHoc, String tenHocKy, String tenMonHoc, String tenKhoiLop){
        int parameter = 4;
        Object[] value = new Object[parameter];
        value[0] = tenNamHoc;
        value[1] = tenHocKy;
        value[2] = tenMonHoc;
        value[3] = tenKhoiLop;
        return con.ExecuteQuery("TaoBaoCaoMonHoc(?,?,?,?)",parameter,value);
    }
}
