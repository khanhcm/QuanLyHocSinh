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
public class HocKyDAL {
    DataConnector dc;
    public HocKyDAL()
    {
        dc = new DataConnector();
    }
    public ResultSet layHocKyTuNamHoc(String tenNamHoc){
        int parameter = 1;
        Object[] value = new Object[parameter];
        value[0] = tenNamHoc;
        return dc.ExecuteQuery("LayHocKyTuNamHoc(?)", parameter, value);
    }
}
