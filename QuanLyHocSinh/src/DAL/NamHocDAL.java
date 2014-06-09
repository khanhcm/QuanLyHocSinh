/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import DTO.NamHocDTO;
import java.sql.ResultSet;

/**
 *
 * @author evilz
 */
public class NamHocDAL {
    private DataConnector con;
    
    public NamHocDAL(){
        con = new DataConnector();
    }
    
    public ResultSet LayDanhSachNamHoc()
    {
        return con.ExecuteQuery("laydanhsachnamhoc");
    }
}
