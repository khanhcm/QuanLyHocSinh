/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.HocKyDAL;
import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class HocKyBLL {
    
    HocKyDAL hocKyDAL;

    public HocKyBLL() {
        hocKyDAL = new HocKyDAL();
    }
    
    public ResultSet layDanhSachHocKy(String tenNamHoc){
        return hocKyDAL.layDanhSachHocKy(tenNamHoc);
    }
    
    
}
