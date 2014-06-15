/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DTO.*;
import DAL.*;
import java.sql.ResultSet;
/**
 *
 * @author Cong Ly Nguyen
 */
public class ChiTietLopBLL {
    
    ChiTietLopDAL chitietlopdal;
    
    public ChiTietLopBLL()
    {
        chitietlopdal = new ChiTietLopDAL();
    }
    public ResultSet ThemHocSinhVaoLop(ChiTietLopDTO chitietlopdto)
    {
        return chitietlopdal.ThemHocSinhVaoLop(chitietlopdto);
    }
    
    public ResultSet LayMaChiTietCuoi()
    {
        return chitietlopdal.LayMaChiTietCuoi();
    }
    
    public ResultSet XoaChiTietLop(ChiTietLopDTO chitietlopdto)
    {
        return chitietlopdal.XoaChiTietLop(chitietlopdto);
    }
    public ResultSet LayMaChiTietLop(ChiTietLopDTO chitietlopdto)
    {
        return chitietlopdal.LayMaChiTietLop(chitietlopdto);
    }
    
    public ResultSet SuaMaLop(ChiTietLopDTO chitietlopdto)
    {
        return chitietlopdal.SuaMaLop(chitietlopdto);
    }
}
