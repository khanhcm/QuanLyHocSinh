/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.ResultSet;

/**
 *
 * @author Cong Ly Nguyen
 */
public class NamHocDAL {
    
    DataConnector dc;
    public NamHocDAL()
    {
        dc = new DataConnector();
    }
    public ResultSet LayDanhSachNamHoc()
    {
        return dc.ExecuteQuery("laydanhsachnamhoc");
    }
}
