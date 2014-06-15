/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author Cong Ly Nguyen
 */
public class LopDTO {
    
    private String _TenLop;
    private String _NamHoc;
    private String _MaLop;

    /**
     * @return the _NamHoc
     */
    public String getNamHoc() {
        return _NamHoc;
    }

    /**
     * @param _NamHoc the _NamHoc to set
     */
    public void setNamHoc(String _NamHoc) {
        this._NamHoc = _NamHoc;
    }
    
    /**
     * @return the _TenLop
     */
    public String getTenLop() {
        return _TenLop;
    }

    /**
     * @param _TenLop the _TenLop to set
     */
    public void setTenLop(String _TenLop) {
        this._TenLop = _TenLop;
    }

    /**
     * @return the _MaLop
     */
    public String getMaLop() {
        return _MaLop;
    }

    /**
     * @param _MaLop the _MaLop to set
     */
    public void setMaLop(String _MaLop) {
        this._MaLop = _MaLop;
    }
}
