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
public class ChiTietLopDAL {
    
    DataConnector dc;
    public ChiTietLopDAL()
    {
        dc = new DataConnector();
    }
    
    public ResultSet ThemHocSinhVaoLop(ChiTietLopDTO chitietlopdto)
    {
        int parameter = 5;
        Object[] value = new Object[parameter];
        value[0]    = chitietlopdto.getMaChiTietLop();
        value[1]    = chitietlopdto.getTBHK1();
        value[2]    = chitietlopdto.getTBHK2();
        value[3]    = chitietlopdto.getMaHS();
        value[4]    = chitietlopdto.getMaTTL();
        return dc.ExecuteQuery("ThemChiTietLop(?,?,?,?,?)", parameter, value);
    }
    
    public ResultSet LayMaChiTietCuoi()
    {
        return dc.ExecuteQuery("laymachitietcuoi");
    }
    
    public ResultSet XoaChiTietLop(ChiTietLopDTO chitietlopdto)
    {
        int parameter = 2;
        Object[] value = new Object[parameter];
        value[0]    = chitietlopdto.getMaHS();
        value[1]    = chitietlopdto.getMaTTL();
        return dc.ExecuteQuery("xoachitietlop(?,?)", parameter, value);
    }
    
    public ResultSet LayMaChiTietLop(ChiTietLopDTO chitietlopdto)
    {
        int parameter = 2;
        Object[] value = new Object[parameter];
        value[0]    = chitietlopdto.getMaHS();
        value[1]    = chitietlopdto.getMaTTL();
        return dc.ExecuteQuery("laymachitietlop(?,?)", parameter, value);
    }
    
    public ResultSet SuaMaLop(ChiTietLopDTO chitietlopdto)
    {
        int parameter = 2;
        Object[] value = new Object[parameter];
        value[0]    = chitietlopdto.getMaChiTietLop();
        value[1]    = chitietlopdto.getMaTTL();
        return dc.ExecuteQuery("suamalop(?,?)", parameter, value);
       
    }
}
