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
public class LopDAL {
    DataConnector dc;
    public LopDAL()
    {
        dc = new DataConnector();
    }
    public ResultSet LayDanhSachTatCaLop()
    {
        return dc.ExecuteQuery("laydanhsachtatcalophoc");
    }
    
    public ResultSet LayDanhSachLopTheoNam(LopDTO lopdto)
    {
        int parameter = 1;
        Object[] value = new Object[parameter];
        value[0] = lopdto.getNamHoc();
        return dc.ExecuteQuery("laydanhsachlophoctheonam(?)", parameter, value);
    }
    
    public ResultSet LaySiSo(LopDTO lopdto)
    {
        int parameter = 2;
        Object[]value = new Object[parameter];
        
        value[0] = lopdto.getTenLop();
        value[1] = lopdto.getNamHoc();
        return dc.ExecuteQuery("laysiso(?,?)", parameter, value);
    }
    
    public ResultSet GiamSiSo(LopDTO lopdto)
    {
        int parameter = 1;
        Object[]value = new Object[parameter];
        value[0] = lopdto.getMaLop();
        return dc.ExecuteQuery("giamsiso(?)", parameter, value);
    }
    
    public ResultSet TangSiSo(LopDTO lopdto)
    {
        int parameter = 1;
        Object[]value = new Object[parameter];
        value[0] = lopdto.getMaLop();
        return dc.ExecuteQuery("tangsiso(?)", parameter, value);
    }
    
    public ResultSet LayMaLop(LopDTO lopdto)
    {
        int parameter = 2;
        Object[]value = new Object[parameter];
        value[0] = lopdto.getTenLop();
        value[1] = lopdto.getNamHoc();
        return dc.ExecuteQuery("LayMaLop(?,?)", parameter, value);
    }
}
