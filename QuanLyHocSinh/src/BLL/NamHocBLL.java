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
public class NamHocBLL {
    NamHocDAL namhocdal;
    
    public NamHocBLL()
    {
        namhocdal = new NamHocDAL();
    }
    public ResultSet LayDanhSachNamHoc()
    {
        return namhocdal.LayDanhSachNamHoc();
    }
}
