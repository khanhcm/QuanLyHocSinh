/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.BaoCaoMonHocDAL;
import java.sql.ResultSet;

/**
 *
 * @author EvilZ
 */
public class BaoCaoMonHocBLL {
    private BaoCaoMonHocDAL bcmh;
    
    public BaoCaoMonHocBLL(){
        bcmh = new BaoCaoMonHocDAL();
    }
    
    public ResultSet layBaoCaoMonHoc(String tenNamHoc, String tenHocKy, String tenMonHoc, String tenKhoiLop){
        return bcmh.layBaoCaoMonHoc(tenNamHoc, tenHocKy, tenMonHoc, tenKhoiLop);
    }
}
