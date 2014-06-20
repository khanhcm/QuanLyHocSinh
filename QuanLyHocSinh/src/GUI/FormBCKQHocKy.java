/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BLL.BaoCaoMonHocBLL;
import BLL.HocKyBLL;
import BLL.MonHocBLL;
import BLL.NamHocBLL;
import DTO.BaoCaoTongKetMonDTO;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author EvilZ
 */
public class FormBCKQHocKy  extends JInternalFrame{
     private JLabel lblNamhoc;
    private JLabel lblHocKy;
    private JLabel lblMonHoc;
    private JLabel lblKhoiLop;
    private JComboBox cbbNamhoc;
    private JComboBox cbbHocKy;
    private JComboBox cbbMonHoc;
    private JComboBox cbbKhoiLop;
    private JButton btnTaoBaoCao;
    private JDesktopPane paneReport;
    
    
    public FormBCKQHocKy(){
        super("Báo cáo kết quả học kỳ",true,true);
        initComponents();
    }

    private void initComponents() {
        lblNamhoc = new JLabel("Chọn năm học:");
        lblHocKy = new JLabel("Chọn học kỳ:");
        lblKhoiLop = new JLabel("Chọn khối lớp");
        cbbHocKy = new JComboBox();
        cbbNamhoc = new JComboBox();
        String[] khoi = {"10", "11", "12"};
        cbbKhoiLop = new JComboBox(khoi);
        btnTaoBaoCao = new JButton("Tạo báo cáo");
        paneReport = new JDesktopPane();
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(lblNamhoc);
        contentPane.add(cbbNamhoc);
        contentPane.add(lblHocKy);
        contentPane.add(cbbHocKy);
        contentPane.add(lblKhoiLop);
        contentPane.add(cbbKhoiLop);
        contentPane.add(btnTaoBaoCao);
        contentPane.add(paneReport);
        
        //Handling Control
        //cbbNamHoc
        NamHocBLL namhoc = new NamHocBLL();
        ResultSet rsNamHoc = namhoc.LayDanhSachNamHoc();
        try {
            OtherMethod.updateComboBox(cbbNamhoc, rsNamHoc);
        } catch (SQLException ex) {
            Logger.getLogger(FormBCKQMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cbbHocKy
        if(!"".equals(cbbNamhoc.getSelectedItem().toString())){
            HocKyBLL hocky = new HocKyBLL();
            ResultSet rsHocKy = hocky.layHocKyTuNamHoc(cbbNamhoc.getSelectedItem().toString());
            try {
                OtherMethod.updateComboBox(cbbHocKy, rsHocKy);
            } catch (SQLException ex) {
                Logger.getLogger(FormBCKQMonHoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //cbbMonHoc
        if(!"".equals(cbbNamhoc.getSelectedItem().toString())){
            MonHocBLL monhoc = new MonHocBLL();
            ResultSet rsMonHoc = monhoc.layMonHocTheoNam(cbbNamhoc.getSelectedItem().toString());
            try {
                OtherMethod.updateComboBox(cbbMonHoc, rsMonHoc);
            } catch (SQLException ex) {
                Logger.getLogger(FormBCKQMonHoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //btnTaoBaoCao
        btnTaoBaoCao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JasperReport jr = JasperCompileManager.compileReport("Report/rptTongKetMonHoc.jrxml");
                    InputStream reportStream = new FileInputStream("Report/rptTongKetMonHoc.jasper");
                    Map parameters = new HashMap();
                    Collection<BaoCaoTongKetMonDTO> data = new ArrayList<>();
                    BaoCaoMonHocBLL bcmh = new BaoCaoMonHocBLL();
                    ResultSet rsBaoCao = bcmh.layBaoCaoMonHoc(cbbNamhoc.getSelectedItem().toString(),
                            cbbHocKy.getSelectedItem().toString(),
                            cbbMonHoc.getSelectedItem().toString(),
                            cbbKhoiLop.getSelectedItem().toString());
                    while(rsBaoCao.next()){
                        BaoCaoTongKetMonDTO baocao = new BaoCaoTongKetMonDTO();
                        baocao.setTenLop(rsBaoCao.getString(1));
                        baocao.setSiSo(rsBaoCao.getInt(2));
                        baocao.setSoLuongDatMon(rsBaoCao.getFloat(3));
                        baocao.setTiLeDatMon(rsBaoCao.getFloat(4));
                        data.add(baocao);
                    }
                    JRDataSource datasource = new JRBeanCollectionDataSource(data, true);
                    parameters.put("paramNamHoc", cbbNamhoc.getSelectedItem().toString());
                    parameters.put("paramHocKy", cbbHocKy.getSelectedItem().toString());
                    parameters.put("paramKhoiLop", cbbKhoiLop.getSelectedItem().toString());
                    JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, datasource);
                    JasperViewer.viewReport(jasperPrint);
                } catch (JRException ex) {
                    Logger.getLogger(FormBCKQMonHoc.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(FormBCKQMonHoc.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FormBCKQMonHoc.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
        pack();
    }
}