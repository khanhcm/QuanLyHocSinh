/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import java.sql.ResultSet;
import DTO.*;
import DAL.*;
/**
 *
 * @author Cong Ly Nguyen
 */
public class TinhTrangLopBLL {
    TinhTrangLopDAL tinhtranglopdal;
    public TinhTrangLopBLL()
    {
        tinhtranglopdal = new TinhTrangLopDAL();
    }
    public ResultSet LayMaTT(TinhTrangLopDTO tinhtranglopdto)
    {
        return tinhtranglopdal.LayMaTT(tinhtranglopdto);
    }
}
