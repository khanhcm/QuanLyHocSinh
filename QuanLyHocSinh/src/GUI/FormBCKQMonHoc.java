/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BLL.HocKyBLL;
import BLL.MonHocBLL;
import BLL.NamHocBLL;
import DAL.DataConnector;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author EvilZ
 */
public class FormBCKQMonHoc extends JInternalFrame{
    private JLabel lblNamhoc;
    private JLabel lblHocKy;
    private JLabel lblMonHoc;
    private JComboBox cbbNamhoc;
    private JComboBox cbbHocKy;
    private JComboBox cbbMonHoc;
    private JButton btnTaoBaoCao;
    private JPanel panelReport;
    
    
     public FormBCKQMonHoc() {
        super("Báo cáo kết quả môn học",true,true);
        initComponents();
    }

    private void initComponents() {
        lblNamhoc = new JLabel("Chọn năm học:");
        lblHocKy = new JLabel("Chọn học kỳ:");
        lblMonHoc = new JLabel("Chọn môn học:");
        cbbHocKy = new JComboBox();
        cbbNamhoc = new JComboBox();
        cbbMonHoc = new JComboBox();
        btnTaoBaoCao = new JButton("Tạo báo cáo");
        panelReport = new JPanel();
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(lblNamhoc);
        contentPane.add(cbbNamhoc);
        contentPane.add(lblHocKy);
        contentPane.add(cbbHocKy);
        contentPane.add(lblMonHoc);
        contentPane.add(cbbMonHoc);
        contentPane.add(btnTaoBaoCao);
        contentPane.add(panelReport);
        
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
                    MonHocBLL monhoc = new MonHocBLL();
                    
                } catch (JRException ex) {
                    Logger.getLogger(FormBCKQMonHoc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pack();
        
        
    }
}
