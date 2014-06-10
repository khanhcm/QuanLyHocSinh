/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.GiaoVienDAL;
import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class GiaoVienBLL {
    GiaoVienDAL giaovien;

    public GiaoVienBLL() {
        giaovien = new GiaoVienDAL();
    }
    
    public ResultSet layGiaoVienTheoLop(String tenLop, String tenNamHoc){
        return giaovien.layGiaoVienTheoLop(tenLop, tenNamHoc);
    }
    
}
