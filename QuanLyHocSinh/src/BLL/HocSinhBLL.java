/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;
import DAL.*;
import DTO.*;
import java.sql.ResultSet;

/**
 *
 * @author Cong Ly Nguyen
 */
public class HocSinhBLL {
    
    HocSinhDAL hocsinhdal;
    
    public HocSinhBLL()
    {
        hocsinhdal = new HocSinhDAL();
    }
    
    public ResultSet TraCuuHocSinh(HocSinhDTO hocsinhdto)
    {
        return hocsinhdal.TraCuuHocSinh(hocsinhdto);
    }
    
    public ResultSet TraCuuHocSinhChuaPhanLop(HocSinhDTO hocsinhdto)
    {
        return hocsinhdal.TraCuuHocSinhChuaPhanLop(hocsinhdto);
    }
            
    public ResultSet LayDanhSachHocSinhTrongLopTrongNam(HocSinhDTO hocsinhdto)
    {
        return hocsinhdal.LayDanhSachHocSinhTrongLopTrongNam(hocsinhdto);
    }
    
    public ResultSet LayDanhSachHocSinhChuaPhanLopTrongNam(HocSinhDTO hocsinhdto)
    {
        return hocsinhdal.LayDanhSachHocSinhChuaPhanLopTrongNam(hocsinhdto);
    }
}
