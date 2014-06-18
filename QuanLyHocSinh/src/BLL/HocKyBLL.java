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
 * @author Cong Ly Nguyen
 */
public class HocKyBLL {
    HocKyDAL hocky;

    public HocKyBLL() {
        hocky = new HocKyDAL();
    }
    
    public ResultSet layHocKyTuNamHoc(String tenNamHoc){
        return hocky.layHocKyTuNamHoc(tenNamHoc);
    }
    
}
