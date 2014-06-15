/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import DTO.*;
import java.sql.ResultSet;
/**
 *
 * @author Cong Ly Nguyen
 */
public class HocSinhDAL {
    
    DataConnector dc;
    public HocSinhDAL()
    {
        dc = new DataConnector();
    }
    
    public ResultSet TraCuuHocSinh(HocSinhDTO hocsinhdto)
    {
        int parameter = 6;
        Object[] value = new Object[parameter];
        value[0] = "%" + hocsinhdto.getMaHS() + "%";
        value[1] = "%" + hocsinhdto.getHoTenHS() + "%";
        value[2] = "%" + hocsinhdto.getLop() + "%";
        value[3] = "%" + hocsinhdto.getDiaChi() + "%";
        value[4] = "%" + hocsinhdto.getNgaySinh() + "%";
        value[5] = "%" + hocsinhdto.getNamHoc() + "%";
        return dc.ExecuteQuery("TraCuuHocSinh(?,?,?,?,?,?)", parameter, value);
    }
    
    public ResultSet TraCuuHocSinhChuaPhanLop(HocSinhDTO hocsinhdto)
    {
        int parameter = 4;
        Object[] value = new Object[parameter];
        value[0] = "%" + hocsinhdto.getMaHS() + "%";
        value[1] = "%" + hocsinhdto.getHoTenHS() + "%";
        value[2] = "%" + hocsinhdto.getDiaChi() + "%";
        value[3] = "%" + hocsinhdto.getNgaySinh() + "%";
        return dc.ExecuteQuery("TraCuuHocSinhChuaPhanLop(?,?,?,?)", parameter, value);
    }
    
    public ResultSet LayDanhSachHocSinhTrongLopTrongNam(HocSinhDTO hocsinhdto)
    {
        int parameter = 2;
        Object[] value = new Object[parameter];
        value[0]    = hocsinhdto.getLop();
        value[1]    = hocsinhdto.getNamHoc();
        return dc.ExecuteQuery("LayDanhSachHocSinhTrongLopTrongNam(?,?)", parameter, value);
    }
    
    public ResultSet LayDanhSachHocSinhChuaPhanLopTrongNam(HocSinhDTO hocsinhdto)
    {
        int parameter = 1;
        Object[] value = new Object[parameter];
        value[0] = hocsinhdto.getNamHoc();
        return dc.ExecuteQuery("LayDanhSachHocSinHChuaPhanLopTrongNam(?)", parameter, value);
    }
}
