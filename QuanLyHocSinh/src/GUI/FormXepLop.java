/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.*;
import DTO.*;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cong Ly Nguyen
 */
public class FormXepLop extends JInternalFrame {

    //khai bao Label va cac check box active cua no
    private JLabel lblLop_Trai;
    private JLabel lblthongbao;
    private JComboBox cbbLop_Trai;

    private JLabel lblTenNamHoc_Giua;
    private JCheckBox chbPhanLop_Giua;
    private JCheckBox chbChuyenLop_Giua;
    private JButton btnChuyen_Giua;
    private JButton btnChuyenNguocLai_Giua;
    private JTextField tfSiSoTrai;
    private JLabel SisoTrai;
    private JTextField tfSiSoPhai;
    private JLabel SisoPhai;
    private JLabel lblLop_Phai;
    private JComboBox cbbLop_Phai;

    private JComboBox cbbTennamHoc;

    private JTable tblTrai;
    private JTable tblPhai;

    private JPanel pChonLopKhoi_Trai;
    private JPanel pChonLopKhoi_Phai;
    private JPanel pGiua;
    private JScrollPane pTrai;
    private JScrollPane pPhai;

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    private HocSinhBLL hocsinhbll;
    private NamHocBLL namhocbll;
    private KhoiLopBLL khoilopbll;
    private LopBLL lopbll;
    private TinhTrangLopBLL tinhtranglopbll;
    private ChiTietLopBLL chitietlopbll;
    private HocKyBLL hockybll;
    private ThamSoBLL thamsobll;

    private OtherMethod method;
    private String[] columnsName = new String[]{
        "Mã Học Sinh", "Họ Và Tên", "Giới Tính"
    };

    public FormXepLop() throws SQLException {
        super("Xếp Lớp Cho Học Sinh", true, true);
        initComponents();

        hocsinhbll = new HocSinhBLL();
        namhocbll = new NamHocBLL();
        khoilopbll = new KhoiLopBLL();
        lopbll = new LopBLL();
        tinhtranglopbll = new TinhTrangLopBLL();
        chitietlopbll = new ChiTietLopBLL();
        hockybll = new HocKyBLL();
        thamsobll = new ThamSoBLL();

        //xoa het doi tuong, add moi doi tuong vao
        cbbTennamHoc.removeAllItems();
        ResultSet rs = namhocbll.LayDanhSachNamHoc();
        method.updateComboBox(cbbTennamHoc, rs);

        //lay danh sach lop hoc trong nam chon
        LopDTO lopdto = new LopDTO();
        lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
        rs = lopbll.LayDanhSachLopTheoNam(lopdto);
        try {
            method.updateComboBox(cbbLop_Phai, rs);
        } catch (SQLException ex) {
            Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
        }

        //update table phai
        HocSinhDTO hocsinhdto = new HocSinhDTO();
        hocsinhdto.setLop(cbbLop_Phai.getSelectedItem().toString());
        hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
        rs = hocsinhbll.LayDanhSachHocSinhTrongLopTrongNam(hocsinhdto);
        method.updateTable(tblPhai, rs, columnsName);

        //update table trai
        hocsinhdto = new HocSinhDTO();
        hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
        rs = hocsinhbll.LayDanhSachHocSinhChuaPhanLopTrongNam(hocsinhdto);
        try {
            method.updateTable(tblTrai, rs, columnsName);
        } catch (SQLException ex) {
            Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cbbLop_Trai.setEnabled(false);
        SisoTrai.setEnabled(false);
        lblLop_Trai.setEnabled(false);
        tfSiSoTrai.setEnabled(false);
        //updateSiSo();
    }

    private void initComponents() {
        lblLop_Trai = new JLabel("Chọn Lớp:");
        lblLop_Phai = new JLabel("Chọn Lớp:");
        SisoTrai = new JLabel("Sỉ Số:");
        SisoPhai = new JLabel("Sỉ Số:");
        lblTenNamHoc_Giua = new JLabel("Tên Năm Học:");
        lblthongbao = new JLabel("");
        cbbLop_Trai = new JComboBox();
        chbPhanLop_Giua = new JCheckBox("Phân Lớp Học Sinh");
        chbChuyenLop_Giua = new JCheckBox("Chuyển Lớp Học Sinh");
        cbbLop_Phai = new JComboBox();
        cbbTennamHoc = new JComboBox();
        tfSiSoTrai = new JTextField();
        tfSiSoPhai = new JTextField();
        tfSiSoTrai.setEditable(false);
        tfSiSoPhai.setEditable(false);
        cbbLop_Phai.addActionListener(new ActionListener() {
            @Override
            //tao  su kien khi nhan vao combobox lop ben phai thi lay co so du lieu va add vao table
            public void actionPerformed(ActionEvent arg0) {
                HocSinhDTO hocsinhdto = new HocSinhDTO();
                tfSiSoTrai.setText("");
                tfSiSoPhai.setText("");
                if (cbbLop_Phai.getSelectedIndex() != -1) {
                    hocsinhdto.setLop(cbbLop_Phai.getSelectedItem().toString());
                    hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    ResultSet rs = hocsinhbll.LayDanhSachHocSinhTrongLopTrongNam(hocsinhdto);
                    try {
                        method.updateTable(tblPhai, rs, columnsName);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                updateSiSo();
            }
        });
        cbbLop_Trai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfSiSoTrai.setText("");
                tfSiSoPhai.setText("");
                if (cbbLop_Trai.isEnabled()&&cbbLop_Trai.getSelectedIndex()!=-1) {
                    HocSinhDTO hocsinhdto = new HocSinhDTO();
                    hocsinhdto.setLop(cbbLop_Trai.getSelectedItem().toString());
                    hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    ResultSet rs = hocsinhbll.LayDanhSachHocSinhTrongLopTrongNam(hocsinhdto);
                    try {
                        method.updateTable(tblTrai, rs, columnsName);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                updateSiSo();
            }

        });

        chbChuyenLop_Giua.setSelected(false);
        chbPhanLop_Giua.setSelected(true);
        cbbLop_Trai.setEnabled(false);
        btnChuyen_Giua = new JButton();
        btnChuyen_Giua.setText(">>>>");
        btnChuyen_Giua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ThamSoDTO thamsodto = new ThamSoDTO();
                thamsodto.setTenThamSo("SiSoToiDa");
                int sisotoida = method.getInt(thamsobll.LayThamSo(thamsodto));

                LopDTO lopdto = new LopDTO();
                if (cbbLop_Phai.getSelectedIndex() != -1
                        && cbbTennamHoc.getSelectedIndex() != -1) {
                    lopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                }
                int sisohientai = method.getInt(lopbll.LaySiSo(lopdto));
                if (sisohientai < sisotoida) {
                    int selectedRow = tblTrai.getSelectedRow();
                    Boolean trunglop = false;
                    if (chbChuyenLop_Giua.isSelected()
                            && cbbLop_Phai.getSelectedItem().toString().equals(cbbLop_Trai.getSelectedItem().toString())) {
                        trunglop = true;
                    }
                    if (!trunglop) {
                        if (selectedRow != -1) {
                            //neu row duoc chon thi bat dau thuc hien
                            Vector selectedRowData = new Vector();
                            for (int i = 0; i < tblTrai.getModel().getColumnCount(); i++) {
                                selectedRowData.addElement(tblTrai.getModel().getValueAt(selectedRow, i));
                            }
                            int tongsodong = 0;
                            ResultSet rs = chitietlopbll.LayMaChiTietCuoi();
                            try {
                                while (rs.next()) {
                                    String temp = rs.getString(1);
                                    tongsodong = Integer.parseInt(temp.substring(3)) + 1;
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            TinhTrangLopDTO tinhtranglopdto = new TinhTrangLopDTO();
                            tinhtranglopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                            tinhtranglopdto.setTenNamHoc(cbbTennamHoc.getSelectedItem().toString());
                            String MaTTL = "";
                            rs = tinhtranglopbll.LayMaTT(tinhtranglopdto);
                            try {
                                while (rs.next()) {
                                    MaTTL = rs.getString(1);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ChiTietLopDTO chitietlopdto = new ChiTietLopDTO();
                            chitietlopdto.setMaChiTietLop("CTL" + tongsodong);
                            chitietlopdto.setMaHS(selectedRowData.get(0).toString());// ma hs
                            chitietlopdto.setTBHK1(0);
                            chitietlopdto.setTBHK2(0);
                            chitietlopdto.setMaTTL(MaTTL);

                            if (chbPhanLop_Giua.isSelected()) {
                                lopdto = new LopDTO();
                                lopdto.setMaLop("");
                                if (cbbLop_Phai.getSelectedIndex() != -1
                                        && cbbTennamHoc.getSelectedIndex() != -1) {
                                    lopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                    lopdto.setMaLop(method.getString(lopbll.LayMaLop(lopdto)));
                                }

                                lopbll.TangSiSo(lopdto);
                                updateSiSo();
                                chitietlopbll.ThemHocSinhVaoLop(chitietlopdto);
                                lblthongbao.setText("Thêm Học Sinh Thành Công :D");
                            } else if (chbChuyenLop_Giua.isSelected()) {
                                tinhtranglopdto = new TinhTrangLopDTO();
                                tinhtranglopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                                tinhtranglopdto.setTenNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                String MaTTLTrai = "";
                                rs = tinhtranglopbll.LayMaTT(tinhtranglopdto);
                                try {
                                    while (rs.next()) {
                                        MaTTLTrai = rs.getString(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                String MaCTLop = "";
                                //lay lai ma tinh trang lop
                                tinhtranglopdto = new TinhTrangLopDTO();
                                tinhtranglopdto.setTenLop(cbbLop_Trai.getSelectedItem().toString());
                                tinhtranglopdto.setTenNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                MaTTL = "";
                                rs = tinhtranglopbll.LayMaTT(tinhtranglopdto);
                                try {
                                    while (rs.next()) {
                                        MaTTL = rs.getString(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                chitietlopdto.setMaTTL(MaTTL);
                                chitietlopdto.setMaHS(selectedRowData.get(0).toString());// ma hs

                                rs = chitietlopbll.LayMaChiTietLop(chitietlopdto);
                                try {
                                    while (rs.next()) {
                                        MaCTLop = rs.getString(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                lopdto = new LopDTO();
                                lopdto.setMaLop("");
                                if (cbbLop_Phai.getSelectedIndex() != -1
                                        && cbbTennamHoc.getSelectedIndex() != -1) {
                                    lopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                    lopdto.setMaLop(method.getString(lopbll.LayMaLop(lopdto)));
                                }
                                lopbll.TangSiSo(lopdto);
                                
                                if (cbbLop_Phai.getSelectedIndex() != -1
                                        && cbbTennamHoc.getSelectedIndex() != -1) {
                                    lopdto.setTenLop(cbbLop_Trai.getSelectedItem().toString());
                                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                    lopdto.setMaLop(method.getString(lopbll.LayMaLop(lopdto)));
                                }
                                lopbll.GiamSiSo(lopdto);
                                updateSiSo();
                                
                                chitietlopdto = new ChiTietLopDTO();
                                chitietlopdto.setMaChiTietLop(MaCTLop);
                                chitietlopdto.setMaTTL(MaTTLTrai);
                                chitietlopbll.SuaMaLop(chitietlopdto);
                                lblthongbao.setText("Chuyển Lớp Học Sinh Thành Công :D");
                            }
                            method.removeRow(tblTrai, selectedRow);
                            method.addRow(tblPhai, selectedRowData);
                            updateSiSo();
                        }
                    }
                   else
                        lblthongbao.setText("Trùng Lớp Rồi :(");
                }
                else
                    
                    lblthongbao.setText("Sỉ Số Lớn Hơn Quy Định :(");
            }
        });
        btnChuyenNguocLai_Giua = new JButton();
        btnChuyenNguocLai_Giua.setText("<<<<");
        btnChuyenNguocLai_Giua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThamSoDTO thamsodto = new ThamSoDTO();
                thamsodto.setTenThamSo("SiSoToiDa");
                int sisotoida = method.getInt(thamsobll.LayThamSo(thamsodto));

                LopDTO lopdto = new LopDTO();
                if (cbbLop_Phai.getSelectedIndex() != -1
                        && cbbTennamHoc.getSelectedIndex() != -1) {
                    lopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                }
                int sisohientai = method.getInt(lopbll.LaySiSo(lopdto));
                if (sisohientai < sisotoida) {
                    int selectedRow = tblPhai.getSelectedRow();
                    Boolean trunglop = false;
                    if (chbChuyenLop_Giua.isSelected()
                            && cbbLop_Phai.getSelectedItem().toString().equals(cbbLop_Trai.getSelectedItem().toString())) {
                        trunglop = true;
                    }
                    if (!trunglop) {
                        if (selectedRow != -1) {
                            //neu row duoc chon thi bat dau thuc hien
                            Vector selectedRowData = new Vector();
                            for (int i = 0; i < tblPhai.getModel().getColumnCount(); i++) {
                                selectedRowData.addElement(tblPhai.getModel().getValueAt(selectedRow, i));
                            }

                            //lay ma tinh trang lop
                            ResultSet rs = null;
                            TinhTrangLopDTO tinhtranglopdto = new TinhTrangLopDTO();
                            tinhtranglopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                            tinhtranglopdto.setTenNamHoc(cbbTennamHoc.getSelectedItem().toString());
                            String MaTTL = "";
                            rs = tinhtranglopbll.LayMaTT(tinhtranglopdto);
                            try {
                                while (rs.next()) {
                                    MaTTL = rs.getString(1);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String MaHS = selectedRowData.get(0).toString();
                            ChiTietLopDTO chitietlopdto = new ChiTietLopDTO();
                            chitietlopdto.setMaHS(MaHS);
                            chitietlopdto.setMaTTL(MaTTL);
                            if (chbPhanLop_Giua.isSelected()) {
                                lopdto = new LopDTO();
                                lopdto.setMaLop("");
                                if (cbbLop_Phai.getSelectedIndex() != -1
                                        && cbbTennamHoc.getSelectedIndex() != -1) {
                                    lopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                    lopdto.setMaLop(method.getString(lopbll.LayMaLop(lopdto)));
                                }

                                lopbll.GiamSiSo(lopdto);
                                updateSiSo();
                                chitietlopbll.XoaChiTietLop(chitietlopdto);
                                
                                lblthongbao.setText("Hủy Lớp Thành công :D");
                            } else if (chbChuyenLop_Giua.isSelected()) {
                                tinhtranglopdto.setTenLop(cbbLop_Trai.getSelectedItem().toString());
                                tinhtranglopdto.setTenNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                String MaTTLTrai = "";
                                rs = tinhtranglopbll.LayMaTT(tinhtranglopdto);
                                try {
                                    while (rs.next()) {
                                        MaTTLTrai = rs.getString(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                String MaCTLop = "";
                                rs = chitietlopbll.LayMaChiTietLop(chitietlopdto);
                                try {
                                    while (rs.next()) {
                                        MaCTLop = rs.getString(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                lopdto = new LopDTO();
                                lopdto.setMaLop("");
                                if (cbbLop_Phai.getSelectedIndex() != -1
                                        && cbbTennamHoc.getSelectedIndex() != -1) {
                                    lopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
                                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                    lopdto.setMaLop(method.getString(lopbll.LayMaLop(lopdto)));
                                }
                                lopbll.GiamSiSo(lopdto);
                                
                                if (cbbLop_Phai.getSelectedIndex() != -1
                                        && cbbTennamHoc.getSelectedIndex() != -1) {
                                    lopdto.setTenLop(cbbLop_Trai.getSelectedItem().toString());
                                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                                    lopdto.setMaLop(method.getString(lopbll.LayMaLop(lopdto)));
                                }
                                lopbll.TangSiSo(lopdto);
                                updateSiSo();
                                
                                
                                chitietlopdto = new ChiTietLopDTO();
                                chitietlopdto.setMaChiTietLop(MaCTLop);
                                chitietlopdto.setMaTTL(MaTTLTrai);
                                chitietlopbll.SuaMaLop(chitietlopdto);
                                lblthongbao.setText("Chuyển Lớp Thành công :D");
                            }
                            method.removeRow(tblPhai, selectedRow);
                            method.addRow(tblTrai, selectedRowData);
                            updateSiSo();
                        }
                    }
                    else
                        lblthongbao.setText("lớp bị trùng :(");
                }
                else
                    lblthongbao.setText("Sỉ Số quá quy định :(");
            }
        });

        cbbTennamHoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                method = new OtherMethod();
                if (tblTrai != null) {
                    method.clearTable(tblTrai, columnsName);
                }
                if (tblPhai != null) {
                    method.clearTable(tblPhai, columnsName);
                }
                tfSiSoTrai.setText("");
                tfSiSoPhai.setText("");
                ResultSet rs = null;
                //lay danh sach lop hoc trong nam chon
                LopDTO lopdto = new LopDTO();
                if (cbbTennamHoc.getSelectedIndex() != -1) 
                {
                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    rs = lopbll.LayDanhSachLopTheoNam(lopdto);
                    try {
                        method.updateComboBox(cbbLop_Phai, rs);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if (cbbTennamHoc.isEnabled() && 
                            chbChuyenLop_Giua.isSelected()) {
                        lopdto = new LopDTO();
                        lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                        rs = lopbll.LayDanhSachLopTheoNam(lopdto);
                        try {
                            method.updateComboBox(cbbLop_Trai, rs);
                        } catch (SQLException ex) {
                            Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                //update table phai
                HocSinhDTO hocsinhdto = new HocSinhDTO();
                if (cbbLop_Phai.getSelectedIndex() != -1) {
                    hocsinhdto.setLop(cbbLop_Phai.getSelectedItem().toString());
                    hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    rs = hocsinhbll.LayDanhSachHocSinhTrongLopTrongNam(hocsinhdto);
                    try {
                        method.updateTable(tblPhai, rs, columnsName);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                   

                //update table trai
                if (chbPhanLop_Giua.isSelected()) {
                    hocsinhdto = new HocSinhDTO();
                    hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    rs = hocsinhbll.LayDanhSachHocSinhChuaPhanLopTrongNam(hocsinhdto);
                    try {
                        method.updateTable(tblTrai, rs, columnsName);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    if (chbChuyenLop_Giua.isSelected()) {
                        if (cbbLop_Trai.getSelectedIndex() != -1) {
                            hocsinhdto = new HocSinhDTO();
                            hocsinhdto.setLop(cbbLop_Trai.getSelectedItem().toString());
                            hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                            rs = hocsinhbll.LayDanhSachHocSinhTrongLopTrongNam(hocsinhdto);
                            try {
                                method.updateTable(tblTrai, rs, columnsName);
                            } catch (SQLException ex) {
                                Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                updateSiSo();
            }
        });

        tblTrai = new JTable();
        tblPhai = new JTable();
        tblTrai.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                columnsName
        ));

        tblPhai.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                columnsName
        ));

        pChonLopKhoi_Trai = new JPanel();
        pChonLopKhoi_Phai = new JPanel();
        pGiua = new JPanel();
        pTrai = new JScrollPane(tblTrai);
        pPhai = new JScrollPane(tblPhai);

        chbChuyenLop_Giua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chbChuyenLop_Giua.isSelected()) {
                    chbPhanLop_Giua.setSelected(false);
                    //cbbKhoi_Trai.setEnabled(true);
                    cbbLop_Trai.setEnabled(true);
                     lblLop_Trai.setEnabled(true);
                    SisoTrai.setEnabled(true);
                    tfSiSoTrai.setEnabled(true);
                    //them item vao cbb lop
                    LopDTO lopdto = new LopDTO();
                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    ResultSet rs = lopbll.LayDanhSachLopTheoNam(lopdto);
                    try {
                        method.updateComboBox(cbbLop_Trai, rs);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (!chbChuyenLop_Giua.isSelected()) {
                    chbPhanLop_Giua.setSelected(true);
                    //cbbKhoi_Trai.setEnabled(false);
                    cbbLop_Trai.setEnabled(false);
                     lblLop_Trai.setEnabled(false);
                    SisoTrai.setEnabled(false);
                    tfSiSoTrai.setEnabled(false);
                    cbbLop_Trai.removeAllItems();

                    //cap nhat danh sach hoc sinh chua phan lop
                    HocSinhDTO hocsinhdto = new HocSinhDTO();
                    hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    ResultSet rs = hocsinhbll.LayDanhSachHocSinhChuaPhanLopTrongNam(hocsinhdto);
                    try {
                        method.updateTable(tblTrai, rs, columnsName);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        chbPhanLop_Giua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chbPhanLop_Giua.isSelected()) {
                    chbChuyenLop_Giua.setSelected(false);
                    cbbLop_Trai.setEnabled(false);
                    SisoTrai.setEnabled(false);
                    lblLop_Trai.setEnabled(false);
                    tfSiSoTrai.setEnabled(false);
                    cbbLop_Trai.removeAllItems();

                    //cap nhat danh sach chua phan lop
                    HocSinhDTO hocsinhdto = new HocSinhDTO();
                    hocsinhdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    ResultSet rs = hocsinhbll.LayDanhSachHocSinhChuaPhanLopTrongNam(hocsinhdto);
                    try {
                        method.updateTable(tblTrai, rs, columnsName);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (!chbPhanLop_Giua.isSelected()) {
                    //cbbKhoi_Trai.setEnabled(true);
                    cbbLop_Trai.setEnabled(true);
                    SisoTrai.setEnabled(true);
                     lblLop_Trai.setEnabled(true);
                     tfSiSoTrai.setEnabled(true);
                    chbChuyenLop_Giua.setSelected(true);
                    LopDTO lopdto = new LopDTO();
                    lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                    ResultSet rs = lopbll.LayDanhSachLopTheoNam(lopdto);
                    try {
                        method.updateComboBox(cbbLop_Trai, rs);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        //doDefaultCloseAction();
        GroupLayout layout = new GroupLayout(pChonLopKhoi_Trai);
        //Panel 1
        pChonLopKhoi_Trai.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(SisoTrai)
                        .addComponent(lblLop_Trai)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cbbLop_Trai)
                        .addComponent(tfSiSoTrai)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLop_Trai)
                        .addComponent(cbbLop_Trai)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SisoTrai)
                        .addComponent(tfSiSoTrai)
                )
        );

        //Panel 2
        layout = new GroupLayout(pGiua);
        pGiua.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblTenNamHoc_Giua)
                        .addComponent(cbbTennamHoc)
                        .addComponent(chbChuyenLop_Giua)
                        .addComponent(chbPhanLop_Giua)
                        .addComponent(btnChuyen_Giua)
                        .addComponent(btnChuyenNguocLai_Giua)
                        .addComponent(lblthongbao)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenNamHoc_Giua)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbTennamHoc)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(chbChuyenLop_Giua)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGap(30)
                        .addComponent(chbPhanLop_Giua)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGap(30)
                        .addComponent(btnChuyen_Giua)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnChuyenNguocLai_Giua)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblthongbao)
                )
        );

        //Panel 3
        layout = new GroupLayout(pChonLopKhoi_Phai);
        pChonLopKhoi_Phai.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblLop_Phai)
                        .addComponent(SisoPhai)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cbbLop_Phai)
                        .addComponent(tfSiSoPhai)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLop_Phai)
                        .addComponent(cbbLop_Phai)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SisoPhai)
                        .addComponent(tfSiSoPhai)
                )
        );

        Container contentPane = this.getContentPane();
        setForeground(java.awt.Color.LIGHT_GRAY);
        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        //Use GridBagLayout to manage panel Quản lý hồ sơ
        contentPane.setLayout(new GridBagLayout());

        pChonLopKhoi_Trai.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 100;
        gbc.ipady = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 5, 0, 0);
        contentPane.add(pChonLopKhoi_Trai, gbc);

        pGiua.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.ipadx = -100;
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        contentPane.add(pGiua, gbc);

        pChonLopKhoi_Phai.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.ipadx = 50;
        gbc.ipady = 0;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        contentPane.add(pChonLopKhoi_Phai, gbc);

        pTrai.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.ipadx = 0;
        gbc.ipady = 300;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        contentPane.add(pTrai, gbc);

        pPhai.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.ipadx = 0;
        gbc.ipady = 300;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        contentPane.add(pPhai, gbc);
        pack();
    }

    private void emptyField() {
        //cbbKhoi_Trai.removeAllItems();
        cbbLop_Trai.removeAllItems();
        // cbbKhoi_Phai.removeAllItems();
        cbbLop_Phai.removeAllItems();
    }

    private void uncheckAll() {

    }

    private void updateSiSo() {
        LopDTO lopdto = new LopDTO();
        if (SisoTrai.isEnabled()) {
            if (cbbTennamHoc.getSelectedIndex() != -1
                    && cbbLop_Trai.getSelectedIndex() != -1) {
                lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
                lopdto.setTenLop(cbbLop_Trai.getSelectedItem().toString());
                int siso = method.getInt(lopbll.LaySiSo(lopdto));
                tfSiSoTrai.setText(Integer.toString(siso));
            }
        }
        else
            tfSiSoTrai.setText("");
        if (cbbTennamHoc.getSelectedIndex() != -1
                && cbbLop_Phai.getSelectedIndex() != -1) {
            lopdto.setNamHoc(cbbTennamHoc.getSelectedItem().toString());
            lopdto.setTenLop(cbbLop_Phai.getSelectedItem().toString());
            int siso = method.getInt(lopbll.LaySiSo(lopdto));
            tfSiSoPhai.setText(Integer.toString(siso));
        }
    }
}
