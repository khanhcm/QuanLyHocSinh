/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.MonHocDAL;
import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class MonHocBLL {
     MonHocDAL monhocdal;
    
    public MonHocBLL()
    {
        monhocdal = new MonHocDAL();
    }
    
    public ResultSet layMonHocTheoNam(String tenNamHoc){
        return monhocdal.layMonHocTheoNam(tenNamHoc);
    }
}
