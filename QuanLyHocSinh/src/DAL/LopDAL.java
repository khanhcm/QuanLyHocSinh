/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class LopDAL {
    DataConnector con;
    public LopDAL()
    {
        con = new DataConnector();
    }
    public ResultSet LayDanhSachTatCaLop()
    {
        return con.ExecuteQuery("laydanhsachtatcalophoc");
    }
    
    public ResultSet LayDanhSachLopTheoNam(String tenNamHoc)
    {
        int parameter = 1;
        Object[] value = new Object[parameter];
        value[0] = tenNamHoc;
        return con.ExecuteQuery("laydanhsachlophoctheonam(?)", parameter, value);
    }
}
