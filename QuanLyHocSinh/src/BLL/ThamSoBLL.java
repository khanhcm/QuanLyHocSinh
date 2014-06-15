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
public class ThamSoBLL {
    ThamSoDAL thamsodal;
    public ThamSoBLL()
    {
        thamsodal = new ThamSoDAL();
    }
    
    public ResultSet LayThamSo(ThamSoDTO thamsodto)
    {
        return thamsodal.LayThamSo(thamsodto);
    }
    
}
