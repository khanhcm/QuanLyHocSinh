/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.BangDiemDAL;
import DTO.BangDiemDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author EvilZ
 */
public class BangDiemBLL {
    BangDiemDAL bangdiem;

    public BangDiemBLL() {
        bangdiem = new BangDiemDAL();
    }
    
    public ResultSet layBangDiemTuThongTin(BangDiemDTO bangdiemdto){
        return bangdiem.layBangDiemTuThongTin(bangdiemdto);
    }
    
    public ResultSet capnhatBangDiem(BangDiemDTO bangdiemdto){
        return bangdiem.capnhatBangDiem(bangdiemdto);
    }
}
