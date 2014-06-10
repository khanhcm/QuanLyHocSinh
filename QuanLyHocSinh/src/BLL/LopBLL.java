/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.LopDAL;
import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class LopBLL {
     LopDAL lopdal;
    
    public LopBLL()
    {
        lopdal = new LopDAL();
    }
    public ResultSet LayDanhSachTatCaLop()
    {
        return lopdal.LayDanhSachTatCaLop();
    }
    public ResultSet LayDanhSachLopTheoNam(String tenNamHoc)
    {
        return lopdal.LayDanhSachLopTheoNam(tenNamHoc);
    }
}
