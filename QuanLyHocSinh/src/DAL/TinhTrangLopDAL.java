/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.ResultSet;
import DTO.*;
/**
 *
 * @author Cong Ly Nguyen
 */
public class TinhTrangLopDAL {
    DataConnector dc;
    public TinhTrangLopDAL()
    {
        dc = new DataConnector();
    }
    public ResultSet LayMaTT(TinhTrangLopDTO tinhtranglopdto)
    {
        int parameter = 2;
        Object[] value = new Object[parameter];
        value[0] = tinhtranglopdto.getTenLop();
        value[1] = tinhtranglopdto.getTenNamHoc();
        return dc.ExecuteQuery("laymattlop(?,?)", parameter, value);
    }
}
