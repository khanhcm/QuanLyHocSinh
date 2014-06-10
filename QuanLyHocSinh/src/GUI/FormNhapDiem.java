/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BLL.GiaoVienBLL;
import BLL.HocKyBLL;
import BLL.LopBLL;
import BLL.MonHocBLL;
import BLL.NamHocBLL;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CaoMinh
 */
public class FormNhapDiem extends JInternalFrame{
    private JLabel lblNamHoc2;
    private JLabel lblNamHoc;
    private JLabel lblHocKy;
    private JLabel lblHocKy2;
    private JLabel lblMonHoc;
    private JLabel lblBangDiem;
    private JLabel lblMonhoc1;
    private JLabel lblNamHoc1;
    private JLabel lblLop;
    private JLabel lblLop1;
    private JLabel lblHocky1;
    private JLabel lblGvcn;
    private JLabel lblGvcn1;
    private JComboBox cbbNamHoc;
    private JComboBox cbbHocKy;
    private JComboBox cbbMonHoc;
    private JList lstLop;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JTable tableLop;
    private JTable tableBangDiem;
    private OtherMethod method;
    String[] lopColumnsName = new String[]{"Tên lớp"};
    String[] bangDiemColumsName = new String[]{"Mã HS","Họ tên","Điểm 15p 1","Điểm 15p 2",
        "Điểm 15p 3", "Điểm 1 tiết 1", "Điểm 1 tiết 2", "Điểm Thi", "Điểm TB" };
    
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public FormNhapDiem() {
        super("Nhập điểm môn học",true,true);
        initComponents();
    }

    private void initComponents() {
        lblNamHoc = new JLabel("Năm học: ");
        lblHocKy = new JLabel("Học kỳ: ");
        lblMonHoc = new JLabel("Môn học: ");
        lblNamHoc2 = new JLabel("Năm học: ");
        lblHocKy2 = new JLabel("Học kỳ: ");
        lblBangDiem = new JLabel("<html><h3>"+"BẢNG ĐIỂM MÔN HỌC "+"</h3></html>");
        lblLop = new JLabel("Lớp: ");
        lblMonhoc1 = new JLabel();
        lblNamHoc1 = new JLabel();
        lblLop1 = new JLabel();
        lblHocky1 = new JLabel();
        lblGvcn = new JLabel("GVCN: ");
        lblGvcn1 = new JLabel();
        
        tableLop = new JTable();
        tableLop.setModel(new DefaultTableModel(
            new Object[][]{
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            lopColumnsName
        ));
        tableBangDiem = new JTable();
        tableBangDiem.setModel(new DefaultTableModel(
            new Object[][]{
                {null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null}
            },
            bangDiemColumsName
        ));
        
        
        
        cbbNamHoc = new JComboBox();
        cbbHocKy = new JComboBox();
        cbbMonHoc = new JComboBox();
        lstLop = new JList();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        
        //doDefaultCloseAction();
        GroupLayout layout = new GroupLayout(panel1);
        
        //Panel 1
        panel1.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblNamHoc)
                .addComponent(cbbNamHoc)
                .addComponent(lblHocKy)
                .addComponent(cbbHocKy)
                .addComponent(lblMonHoc)
                .addComponent(cbbMonHoc)
            )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNamHoc)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cbbNamHoc)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblHocKy)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cbbHocKy)
            )       
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblMonHoc)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cbbMonHoc)  
            )
        );
        
        //Panel 2
        layout = new GroupLayout(panel2);
        panel2.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblBangDiem)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblNamHoc2)
                    .addComponent(lblNamHoc1)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblGvcn)
                    .addComponent(lblGvcn1)
                )
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblLop)
                    .addComponent(lblLop1)
                )
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblHocKy2)
                .addComponent(lblHocky1)
            )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblBangDiem)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNamHoc2)
                .addComponent(lblNamHoc1)
                .addComponent(lblLop)
                .addComponent(lblLop1)
                .addComponent(lblHocKy2)
                .addComponent(lblHocky1)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblGvcn)
                .addComponent(lblGvcn1)
            )
        );
        //Event for table lop
        tableLop.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tableLop.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedData = null;
                int[] selectedRow = tableLop.getSelectedRows();
                int[] selectedColumns = tableLop.getSelectedColumns();
                
                for(int i = 0; i< selectedRow.length; i++ ){
                    for(int j = 0; j < selectedColumns.length; j++){
                        selectedData = (String)tableLop.getValueAt(selectedRow[i], selectedColumns[j]);
                    }
                }
                
                //Handling title of form Bang Diem
                //Label NamHoc 1
        
                if(!"".equals(cbbNamHoc.getSelectedItem().toString())){
                    lblNamHoc1.setText(cbbNamHoc.getSelectedItem().toString());
                }
        
                //Label HocKy 1

                if(!"".equals(cbbHocKy.getSelectedItem().toString())){
                    lblHocky1.setText(cbbHocKy.getSelectedItem().toString());
                }
        
                //Label BangDiem

                if(!"".equals(cbbMonHoc.getSelectedItem().toString())){
                    lblBangDiem.setText(String.format("<html><h3>BẢNG ĐIỂM MÔN HỌC %s</h3></html>",
                            cbbMonHoc.getSelectedItem().toString().toUpperCase()));
                }
                
                //Label Lop
                if(!"".equals(selectedData)){
                    lblLop1.setText(selectedData);
                }
                
                //Label GVCN
                GiaoVienBLL giaovien = new GiaoVienBLL();
                ResultSet rsGiaovien = giaovien.layGiaoVienTheoLop(selectedData,cbbNamHoc.getSelectedItem().toString());
                try {
                    while(rsGiaovien.next())
                        lblGvcn1.setText(rsGiaovien.getString(1));
                } catch (SQLException ex) {
                    Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Table BangDiem
                
            }
        });
        //Panel 3 & 4
        
        
        panel3.add(new JScrollPane(tableLop));
        panel4.add(new JScrollPane(tableBangDiem));
        
        
        
        Container contentPane = this.getContentPane();
        setForeground(java.awt.Color.LIGHT_GRAY);
        if(RIGHT_TO_LEFT){
            contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(panel1)
                .addComponent(panel3)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(panel2)
                .addComponent(panel4)
            )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(panel1)
                .addComponent(panel2)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(panel3)
                .addComponent(panel4)
            )
        );
        
        
        //Xử lý các thành phần trong form
        //Combobox NamHoc
        NamHocBLL nam = new NamHocBLL();
        ResultSet rsNamHoc = nam.LayDanhSachNamHoc();
        try {
            while(rsNamHoc.next()){
                cbbNamHoc.addItem(rsNamHoc.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Combobox Hocky
        HocKyBLL hocky = new HocKyBLL();
        if(!"".equals(cbbNamHoc.getSelectedItem().toString())){
            ResultSet rsHocKy = hocky.layDanhSachHocKy(cbbNamHoc.getSelectedItem().toString());
            try {
                while(rsHocKy.next()){
                    cbbHocKy.addItem(rsHocKy.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Combobox MonHoc
        MonHocBLL monhoc = new MonHocBLL();
        if(!"".equals(cbbNamHoc.getSelectedItem().toString())){
            ResultSet rsMonHoc = monhoc.layMonHocTheoNam(cbbNamHoc.getSelectedItem().toString());
            try {
                while(rsMonHoc.next()){
                    cbbMonHoc.addItem(rsMonHoc.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Table Lop
        if(!"".equals(cbbNamHoc.getSelectedItem().toString())){
            LopBLL lop = new LopBLL();
            ResultSet rsLop = lop.LayDanhSachLopTheoNam(cbbNamHoc.getSelectedItem().toString());
            try {
                method.updateTableWithNonEditable(tableLop, rsLop, lopColumnsName);
            } catch (SQLException ex) {
                Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        pack();
    }
}
