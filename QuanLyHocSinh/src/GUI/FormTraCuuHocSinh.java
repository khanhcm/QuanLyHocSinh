/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.*;
import DAL.*;
import DTO.*;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Cong Ly Nguyen
 */
public class FormTraCuuHocSinh extends JInternalFrame{
    //khai bao Label va cac check box active cua no
    private JCheckBox chbTraCuuHSChuaPhanLop;
    private JCheckBox chbTraCuuHSDaPhanLop;
    private JCheckBox chbTimTatCaCacNam;
    private JCheckBox chbMaHocSinh;
    private JCheckBox chbHoTen;
    private JCheckBox chbLopHoc;
    private JCheckBox chbDiaChi;
    private JCheckBox chbNamSinh;
    
    private JTextField tfdMaHocSinh; 
    private JTextField tfdHoTen; 
    private JTextField tfdDiaChi; 
    private JTextField tfdNamSinh;
    
    private JComboBox cbbLopHoc;
    private JComboBox cbbNamHoc;
    
    private JButton btnTimKiem;
    
    private JTable  tblKetQua;
    
    private JPanel          pThongTinTraCuu;
    private JPanel          pLuaChonLoaiTraCuu;
    private JPanel          pButton;
    private JScrollPane     pKetQua;
  
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    private  HocSinhBLL hocsinhbll;
    private  KhoiLopBLL khoilopbll;
    private  LopBLL lopbll;
    private  NamHocBLL namhocbll;
    
    DataConnector dt;
    String[] columnsName =  new String[]{
                    "Mã Học Sinh", "Họ Và Tên", "Tên Lớp", "Trung Bình Học Kỳ 1",
                    "Trung Bình Học Kỳ 2", "Năm Học", "Giáo Viên Chủ Nhiệm"
                };
   
    public FormTraCuuHocSinh() {
        super("Tra Cứu Học Sinh",true,true);
        initComponents();
        hocsinhbll = new HocSinhBLL();
        khoilopbll = new KhoiLopBLL();
        lopbll = new LopBLL();
        namhocbll = new NamHocBLL();
    }
    
    private void initComponents() {
        chbTraCuuHSChuaPhanLop  = new JCheckBox("Tra Cứu Học Sinh Chưa Phân Lớp");
        chbTraCuuHSDaPhanLop    = new JCheckBox("Tra Cứu Học Sinh Đã Phân Lớp");
        chbTimTatCaCacNam       = new JCheckBox("Tìm Tất Cả Các Năm: ");
        chbMaHocSinh            = new JCheckBox("Mã Học Sinh: ");
        chbHoTen                = new JCheckBox("Họ Tên: ");
        chbLopHoc               = new JCheckBox("Lớp Học: ");
        chbDiaChi               = new JCheckBox("Địa Chỉ: ");
        chbNamSinh              = new JCheckBox("Năm Sinh: ");

        
        tblKetQua = new JTable();
        tblKetQua.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                columnsName
        ));
        chbTraCuuHSDaPhanLop.setSelected(true);
        
        tfdMaHocSinh    = new JTextField(); 
        tfdHoTen        = new JTextField(); 
        tfdDiaChi       = new JTextField(); 
        tfdNamSinh      = new JTextField();
        tfdMaHocSinh.setEnabled(false);
        tfdHoTen.setEnabled(false);
        tfdDiaChi.setEnabled(false);
        tfdNamSinh.setEnabled(false);
                
        cbbLopHoc       = new JComboBox();
        cbbNamHoc       = new JComboBox();
        
        cbbLopHoc.setEnabled(false);
        cbbNamHoc.setEnabled(false);
        //tblKetQua = new JTable(5,7);
        // <editor-fold defaultstate="collapsed" desc="Add ChangeListener CheckBox ">
        chbTraCuuHSChuaPhanLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(chbTraCuuHSChuaPhanLop.isSelected())
                {
                    emptyField();
                    uncheckAll();
                    chbTraCuuHSDaPhanLop.setSelected(false);
                    chbLopHoc.setEnabled(false);
                    chbTimTatCaCacNam.setEnabled(false);
                }
                else
                    {
                          chbTraCuuHSDaPhanLop.setSelected(true);
                    }}
        });
        
        chbTraCuuHSDaPhanLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(chbTraCuuHSDaPhanLop.isSelected())
                { 
                    emptyField();
                    uncheckAll();
                    chbTraCuuHSChuaPhanLop.setSelected(false);
                    chbLopHoc.setEnabled(true);
                    chbTimTatCaCacNam.setEnabled(true);
                }
                else
                    {
                        chbTraCuuHSChuaPhanLop.setSelected(true);
                    }
            }
        });
        
        chbMaHocSinh.addActionListener(new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chbMaHocSinh.isSelected())
                    tfdMaHocSinh.setEnabled(true);
                else
                    if(!chbMaHocSinh.isSelected())
                    {
                         tfdMaHocSinh.setEnabled(false);
                         tfdMaHocSinh.setText("");
                    }
                
            }
        });
        
        chbHoTen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(chbHoTen.isSelected())
                    tfdHoTen.setEnabled(true);
                else
                    if(!chbHoTen.isSelected())
                    {
                         tfdHoTen.setEnabled(false);
                         tfdHoTen.setText("");
                    }
            }
        });
        
        chbLopHoc.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chbLopHoc.isSelected())
                {
                    cbbLopHoc.setEnabled(true);
                    if(chbTimTatCaCacNam.isSelected())
                    {
                        LopDTO lopdto = new LopDTO();
                        lopdto.setNamHoc(cbbNamHoc.getSelectedItem().toString());
                        ResultSet rs = lopbll.LayDanhSachLopTheoNam(lopdto);
                        try {
                            OtherMethod.updateComboBox(cbbLopHoc, rs);
                        } catch (SQLException ex) {
                            Logger.getLogger(FormTraCuuHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        ResultSet rs = lopbll.LayDanhSachTatCaLop();
                        try {
                            OtherMethod.updateComboBox(cbbLopHoc, rs);
                        } catch (SQLException ex) {
                            Logger.getLogger(FormTraCuuHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else
                    if(!chbLopHoc.isSelected())
                    {
                         cbbLopHoc.setEnabled(false);
                         cbbLopHoc.removeAllItems();
                    }
            }
        });
        
        chbDiaChi.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(chbDiaChi.isSelected())
                    tfdDiaChi.setEnabled(true);
                else
                    if(!chbDiaChi.isSelected())
                    {
                         tfdDiaChi.setEnabled(false);
                         tfdDiaChi.setText("");
                    }
            }
        });
        
        chbNamSinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           if(chbNamSinh.isSelected())
                    tfdNamSinh.setEnabled(true);
                else
                    if(!chbNamSinh.isSelected())
                    {
                         tfdNamSinh.setEnabled(false);
                         tfdNamSinh.setText("");
                    }
            }
        });
        
        chbTimTatCaCacNam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chbTimTatCaCacNam.isSelected())
                {
                    cbbNamHoc.setEnabled(true);
                    ResultSet rs =  namhocbll.LayDanhSachNamHoc();
                    try {
                        OtherMethod.updateComboBox(cbbNamHoc, rs);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormTraCuuHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                    if(!chbTimTatCaCacNam.isSelected())
                    {
                         cbbNamHoc.setEnabled(false);
                         cbbNamHoc.removeAllItems();
                    }
            }
        });
        
// </editor-fold>
        btnTimKiem = new JButton("Tìm Kiếm");
        
        //btnTimKiem.setEnabled(false);
        btnTimKiem.addActionListener(new ActionListener()  
        {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (chbTraCuuHSDaPhanLop.isSelected())
            {
                HocSinhDTO hocsinhdto = new HocSinhDTO();
                if(cbbLopHoc.isEnabled())
                    hocsinhdto.setLop(cbbLopHoc.getSelectedItem().toString());
                else
                    hocsinhdto.setLop("");
                hocsinhdto.setMaHS(tfdMaHocSinh.getText());
                hocsinhdto.setHoTenHS(tfdHoTen.getText());
                hocsinhdto.setDiaChi(tfdDiaChi.getText());
                hocsinhdto.setNgaySinh(tfdNamSinh.getText());
                if(cbbNamHoc.isEnabled())
                    hocsinhdto.setNamHoc(cbbNamHoc.getSelectedItem().toString());
                else
                {
                     hocsinhdto.setNamHoc("");
                }
                ResultSet rs = hocsinhbll.TraCuuHocSinh(hocsinhdto);
                try {
                    OtherMethod.updateTable(tblKetQua, rs, columnsName);
                } catch (SQLException ex) {
                    Logger.getLogger(FormTraCuuHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                HocSinhDTO hocsinhdto = new HocSinhDTO();
                hocsinhdto.setMaHS(tfdMaHocSinh.getText());
                hocsinhdto.setHoTenHS(tfdHoTen.getText());
                hocsinhdto.setDiaChi(tfdDiaChi.getText());
                hocsinhdto.setNgaySinh(tfdNamSinh.getText());
                ResultSet rs  = hocsinhbll.TraCuuHocSinhChuaPhanLop(hocsinhdto);
                try {
                    OtherMethod.updateTable(tblKetQua, rs, columnsName);
                } catch (SQLException ex) {
                    Logger.getLogger(FormTraCuuHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
        });
        

        
        pThongTinTraCuu         = new JPanel();
        pLuaChonLoaiTraCuu      = new JPanel();
        pButton                 = new JPanel();
        pKetQua                 = new JScrollPane(tblKetQua);

        //doDefaultCloseAction();
        GroupLayout layout = new GroupLayout(pLuaChonLoaiTraCuu);
        
        //Panel 1
        pLuaChonLoaiTraCuu.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(chbTraCuuHSChuaPhanLop)
                .addComponent(chbTraCuuHSDaPhanLop)
            )
                
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(chbTraCuuHSDaPhanLop)
                        
            )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(chbTraCuuHSChuaPhanLop)
            )
        );
        
        //Panel 2
        layout = new GroupLayout(pThongTinTraCuu);
        pThongTinTraCuu.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(chbMaHocSinh)
                .addComponent(tfdMaHocSinh)
                .addComponent(chbHoTen)
                .addComponent(tfdHoTen)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(chbLopHoc)
                .addComponent(cbbLopHoc)
                .addComponent(chbDiaChi)
                .addComponent(tfdDiaChi)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(chbNamSinh)
                .addComponent(tfdNamSinh)
                .addComponent(chbTimTatCaCacNam)
                .addComponent(cbbNamHoc)
            )
               
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(chbMaHocSinh)
                .addComponent(chbLopHoc)
                .addComponent(chbNamSinh)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tfdMaHocSinh)
                .addComponent(cbbLopHoc)
                .addComponent(tfdNamSinh)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(chbHoTen)
                .addComponent(chbDiaChi)
                .addComponent(chbTimTatCaCacNam)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tfdHoTen)
                .addComponent(tfdDiaChi)
                .addComponent(cbbNamHoc)
            )
        );
        
        //Panel 3
        layout = new GroupLayout(pButton);
        pButton.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(btnTimKiem)
            )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnTimKiem)
            )
        );
        
 
        Container contentPane = this.getContentPane();
        setForeground(java.awt.Color.LIGHT_GRAY);
        if(RIGHT_TO_LEFT){
            contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        //Use GridBagLayout to manage panel Quản lý hồ sơ
        contentPane.setLayout(new GridBagLayout());
        
        
        pLuaChonLoaiTraCuu.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH ;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 30;
        gbc.ipady = 57;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5,5,0,0);
        contentPane.add(pLuaChonLoaiTraCuu , gbc);
        
        pThongTinTraCuu.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.ipadx = 50;
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPane.add(pThongTinTraCuu, gbc);
        
        pButton.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPane.add(pButton, gbc);
        
        pKetQua.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc.ipadx = 0;
        gbc.ipady = 300;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        contentPane.add(pKetQua, gbc);
        pack();
    }
    
    
    private void FormTraCuuHocSinhLoad()
    {
        emptyField();
    }
    
    private void emptyField()
    {
        tfdMaHocSinh.setText("");
        tfdHoTen.setText("");
        tfdDiaChi.setText("");
        tfdNamSinh.setText("");
        cbbNamHoc.removeAllItems();
        cbbLopHoc.removeAllItems();
    }
    
    private void uncheckAll()
    {
        chbMaHocSinh.setSelected(false);
        chbHoTen.setSelected(false);
        chbLopHoc.setSelected(false);
        chbDiaChi.setSelected(false);
        chbNamSinh.setSelected(false);
        chbTimTatCaCacNam.setSelected(false);
        tfdMaHocSinh.setEnabled(false);
        tfdHoTen.setEnabled(false);
        tfdDiaChi.setEnabled(false);
        tfdNamSinh.setEnabled(false);
        cbbNamHoc.setEnabled(false);
        cbbLopHoc.setEnabled(false);
    }
}
