/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import DTO.BangDiemDTO;
import java.sql.CallableStatement;
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
    
    public ResultSet layBangDiemTuThongTin(BangDiemDTO bangdiem){
        int parameter = 4;
        Object[] value = new Object[parameter];
        value[0] = bangdiem.getTenNamHoc();
        value[1] = bangdiem.getTenHocKy();
        value[2] = bangdiem.getTenMonHoc();
        value[3] = bangdiem.getTenLop();
        return con.ExecuteQuery("LayBangDiemTuThongTin(?,?,?,?)",parameter,value);
    }
    
    public ResultSet capnhatBangDiem(BangDiemDTO bangdiem){
        int parameter = 12;
        Object[] value = new Object[parameter];
        value[0] = bangdiem.getTenNamHoc();
        value[1] = bangdiem.getTenHocKy();
        value[2] = bangdiem.getTenMonHoc();
        value[3] = bangdiem.getTenLop();
        value[4] = bangdiem.getMaHocSinh();
        value[5] = bangdiem.getDiem15Phut1();
        value[6] = bangdiem.getDiem15Phut2();
        value[7] = bangdiem.getDiem15Phut3();
        value[8] = bangdiem.getDiem1Tiet1();
        value[9] = bangdiem.getDiem1Tiet2();
        value[10] = bangdiem.getDiemThi();
        value[11] = bangdiem.getDiemTB();
        return con.ExecuteQuery("CapNhatBangDiem(?,?,?,?,?,?,?,?,?,?,?,?)", parameter, value);
    }
    
}
