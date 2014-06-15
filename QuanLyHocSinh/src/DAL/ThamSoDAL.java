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
public class ThamSoDAL {
    DataConnector dc;
    
    public ThamSoDAL()
    {
        dc = new DataConnector();
    }
    
    public ResultSet LayThamSo(ThamSoDTO thamsodto)
    {
        int parameter = 1;
        Object[]value = new Object[parameter];
        value[0] = thamsodto.getTenThamSo();
        return dc.ExecuteQuery("laythamso(?)", parameter, value);
    }
}
