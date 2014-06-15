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
    public ResultSet LayDanhSachLopTheoNam(LopDTO lopdto)
    {
        return lopdal.LayDanhSachLopTheoNam(lopdto);
    }
   
    public ResultSet LaySiSo(LopDTO lopdto)
    {
        return lopdal.LaySiSo(lopdto);
    }
    
    public ResultSet GiamSiSo(LopDTO lopdto)
    {
        return lopdal.GiamSiSo(lopdto);
    }
    
    public ResultSet TangSiSo(LopDTO lopdto)
    {
        return lopdal.TangSiSo(lopdto);
    }
    
    public ResultSet LayMaLop(LopDTO lopdto)
    {
        return lopdal.LayMaLop(lopdto);
        
    }
}
