/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import DTO.BangDiemDTO;
import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class BangDiemDAL {
    private DataConnector con;
    
    public BangDiemDAL(){
        con = new DataConnector();
    }
    
    public ResultSet layBangDiem(BangDiemDTO bangdiem){
        int parameter = 4;
        Object[] value = new Object[parameter];
        value[0] = bangdiem.getTenNamHoc();
        value[1] = bangdiem.getTenHocKy();
        value[2] = bangdiem.getTenMonHoc();
        value[3] = bangdiem.getTenLop();
        return con.ExecuteQuery("LayBangDiemTuThongTin(?,?,?,?)",parameter,value);
    }

}
