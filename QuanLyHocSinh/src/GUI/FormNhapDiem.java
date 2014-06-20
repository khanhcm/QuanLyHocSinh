/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BLL.BangDiemBLL;
import BLL.HocKyBLL;
import BLL.LopBLL;
import BLL.MonHocBLL;
import BLL.NamHocBLL;
import DTO.BangDiemDTO;
import DTO.LopDTO;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
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
    private JLabel lblLop;
    private JLabel lblGvcn;
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
    private JButton btnLuuBangDiem;
    private JButton btnHoanThanh;
    
    
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
        lblBangDiem = new JLabel("<html><h3>BẢNG ĐIỂM MÔN HỌC </h3></html>");
        lblLop = new JLabel("Lớp: ");
        lblGvcn = new JLabel("GVCN: ");
        btnLuuBangDiem = new JButton("Lưu bảng điểm");
        btnLuuBangDiem.setEnabled(false);
        btnHoanThanh = new JButton("Hoàn thành");
        btnHoanThanh.setEnabled(true);
        
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
                .addComponent(lblNamHoc2)
                .addComponent(lblGvcn)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblLop)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblHocKy2)
            )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblBangDiem)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNamHoc2)
                .addComponent(lblLop)
                .addComponent(lblHocKy2)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblGvcn)
            )
        );
        //panel 3
        //table lop
        String[] lopColName = {"Lớp"};
        tableLop = new JTable();
        tableLop.setModel(new DefaultTableModel(
                new Object[][]{
                    {null},
                    {null},
                    {null},
                    {null},
                    {null},
                }
                , lopColName
        ));
        GridBagLayout gbl1 = new GridBagLayout();
        panel3.setLayout(gbl1);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.anchor = GridBagConstraints.NORTHWEST;
        c1.fill = GridBagConstraints.BOTH;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.ipady = 200;
        c1.ipadx = 200;
        c1.gridheight =2;
        panel3.add(new JScrollPane(tableLop),c1);
        //panel4
        //table Bang Diem
        final String[] bangdiemColName = {"Mã HS", 
            "Họ tên", 
            "Điểm 15 phút 1", 
            "Điểm 15 phút 2", 
            "Điểm 15 phút 3",
            "Điểm 1 tiết 1",
            "Điểm 1 tiết 2",
            "Điểm thi",
            "Điểm TB"
        };
        
        tableBangDiem = new JTable();
        tableBangDiem.setModel(new DefaultTableModel(
            new Object[][]{
                {null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null},
            },
            bangdiemColName
        ));
        tableBangDiem.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableBangDiem.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        btnLuuBangDiem.setText("Lưu bảng điểm");
        GridBagLayout gbl = new GridBagLayout();
        panel4.setLayout(gbl);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.ipady = 200;
        c.ipadx = 600;
        panel4.add(new JScrollPane(tableBangDiem),c);
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.ipadx = 50;
        c.ipady = 20;
        panel4.add(btnHoanThanh,c);
        c.fill = GridBagConstraints.CENTER;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 50;
        c.ipady = 20;
        panel4.add(btnLuuBangDiem,c);
        
        
        
        Container contentPane = this.getContentPane();
        setForeground(java.awt.Color.LIGHT_GRAY);
        
        //Use GroupLayout to manage panel Quản lý hồ sơ
        GroupLayout layout1 = new GroupLayout(contentPane);
        contentPane.setLayout(layout1);
        layout1.setAutoCreateGaps(true);
        layout1.setAutoCreateContainerGaps(true);
        
        layout1.setHorizontalGroup(layout1.createSequentialGroup()
            .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(panel1)
                .addComponent(panel3)
            )
            .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(panel2)
                .addComponent(panel4)
            )
        );
        
        layout1.setVerticalGroup(layout1.createSequentialGroup()
            .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(panel1)
                .addComponent(panel2)
            )
            .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(panel3)
                .addComponent(panel4)
            )
        );
        
        
        //Handling control from Form Nhap Diem
        //combobox nam hoc
        NamHocBLL namhoc = new NamHocBLL();
        ResultSet rsNamHoc = namhoc.LayDanhSachNamHoc();
        try {
            OtherMethod.updateComboBox(cbbNamHoc, rsNamHoc);
        } catch (SQLException ex) {
            Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        //combobox hoc ky
        HocKyBLL hocky = new HocKyBLL();
        ResultSet rsHocKy;
        if(!"".equals(cbbNamHoc.getSelectedItem().toString())){
            rsHocKy = hocky.layHocKyTuNamHoc(cbbNamHoc.getSelectedItem().toString());
            try {
                OtherMethod.updateComboBox(cbbHocKy, rsHocKy);
            } catch (SQLException ex) {
                Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //combobox mon hoc
        MonHocBLL monhoc = new MonHocBLL();
        ResultSet rsMonHoc;
        if(!"".equals(cbbNamHoc.getSelectedItem().toString())){
            rsMonHoc = monhoc.layMonHocTheoNam(cbbNamHoc.getSelectedItem().toString());
            try {
                OtherMethod.updateComboBox(cbbMonHoc, rsMonHoc);
            } catch (SQLException ex) {
                Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //table lop
        LopBLL lop = new LopBLL();
        LopDTO lopDto = new LopDTO();
        ResultSet rsLop;
        if(!"".equals(cbbNamHoc.getSelectedItem().toString())){
            lopDto.setNamHoc(cbbNamHoc.getSelectedItem().toString());
            rsLop = lop.LayDanhSachLopTheoNam(lopDto);
            try {
                OtherMethod.updateTableWithNotEditable(tableLop, rsLop, lopColName);
            } catch (SQLException ex) {
                Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Handling event table lop
        ListSelectionModel cellSelectionModel = tableLop.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedData = null;

                int[] selectedRow = tableLop.getSelectedRows();
                int[] selectedColumns = tableLop.getSelectedColumns();

                for (int i = 0; i < selectedRow.length; i++) {
                    for (int j = 0; j < selectedColumns.length; j++) {
                        selectedData = (String) tableLop.getValueAt(selectedRow[i], selectedColumns[j]);
                    }
                }
                //label Bang diem
                lblBangDiem.setText(String.format("<html><h3>BẢNG ĐIỂM MÔN HỌC %s</h3></html>", cbbMonHoc.getSelectedItem().toString().toUpperCase()));
                //label Nam hoc 2
                lblNamHoc2.setText(String.format("Năm học: %s", cbbNamHoc.getSelectedItem()));
                //label Hoc ky 2
                lblHocKy2.setText(String.format("%s", cbbHocKy.getSelectedItem()));
                //label lop
                lblLop.setText(String.format("Lớp: %s", selectedData));
                //label GVCN
                LopBLL lop = new LopBLL();
                ResultSet rsGvcn = lop.layTenGvcnTuLop(selectedData, cbbNamHoc.getSelectedItem().toString());
                try {
                    while(rsGvcn.next()){
                        lblGvcn.setText(String.format("GVCN: %s", rsGvcn.getString(1)));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
                //table bang diem
                BangDiemBLL bangdiem = new BangDiemBLL();
                BangDiemDTO bangdiemdto = new BangDiemDTO();
                bangdiemdto.setTenNamHoc(cbbNamHoc.getSelectedItem().toString());
                bangdiemdto.setTenHocKy(cbbHocKy.getSelectedItem().toString());
                bangdiemdto.setTenMonHoc(cbbMonHoc.getSelectedItem().toString());
                bangdiemdto.setTenLop(selectedData);
                ResultSet rsBangDiem = bangdiem.layBangDiemTuThongTin(bangdiemdto);
                try {
                    OtherMethod.updateTable(tableBangDiem, rsBangDiem, bangdiemColName);
                } catch (SQLException ex) {
                    Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //Handling button Hoan thanh
        btnHoanThanh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnHoanThanh.setEnabled(false);
                btnLuuBangDiem.setEnabled(true);
                if(tableBangDiem.isEditing())
                    tableBangDiem.getCellEditor().stopCellEditing();
            }
        });
        //Handling button Luu Bang Diem 
        btnLuuBangDiem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int rows = tableBangDiem.getRowCount();
                for(int i = 0; i < rows; i++){
                    try{
                        float diem15p1 = Float.parseFloat(tableBangDiem.getValueAt(i, 2).toString());
                        float diem15p2 = Float.parseFloat(tableBangDiem.getValueAt(i, 3).toString());
                        float diem15p3 = Float.parseFloat(tableBangDiem.getValueAt(i, 4).toString());
                        float diem1tiet1 = Float.parseFloat(tableBangDiem.getValueAt(i, 5).toString());
                        float diem1tiet2 = Float.parseFloat(tableBangDiem.getValueAt(i, 6).toString());
                        float diemthi = Float.parseFloat(tableBangDiem.getValueAt(i, 7).toString());
                        
                        float dtb = (diem15p1 + diem15p2 + diem15p3 + diem1tiet1*2.0f + diem1tiet2*2.0f+diemthi*3.0f)/10.0f;
                        String mahs = tableBangDiem.getValueAt(i, 0).toString();
                        BangDiemDTO bangdiemdto = new BangDiemDTO();
                        BangDiemBLL bangdiem = new BangDiemBLL();
                        bangdiemdto.setTenNamHoc(cbbNamHoc.getSelectedItem().toString().trim());
                        bangdiemdto.setTenHocKy(cbbHocKy.getSelectedItem().toString().trim());
                        bangdiemdto.setTenMonHoc(cbbMonHoc.getSelectedItem().toString().trim());
                        bangdiemdto.setTenLop(tableLop.getValueAt(tableLop.getSelectedRow(), tableLop.getSelectedColumn()).toString().trim());
                        bangdiemdto.setDiem15Phut1(diem15p1);
                        bangdiemdto.setDiem15Phut2(diem15p2);
                        bangdiemdto.setDiem15Phut3(diem15p3);
                        bangdiemdto.setDiem1Tiet1(diem1tiet1);
                        bangdiemdto.setDiem1Tiet2(diem1tiet2);
                        bangdiemdto.setDiemThi(diemthi);
                        bangdiemdto.setDiemTB(dtb);
                        bangdiemdto.setMaHocSinh(mahs);
                        ResultSet rsBangDiem1 =  bangdiem.capnhatBangDiem(bangdiemdto);
                        BangDiemBLL bangdiem1 = new BangDiemBLL();
                        ResultSet rsBangDiem = bangdiem1.layBangDiemTuThongTin(bangdiemdto);
                        try {
                            OtherMethod.updateTable(tableBangDiem, rsBangDiem, bangdiemColName);
                        } catch (SQLException ex) {
                            Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        btnHoanThanh.setEnabled(true);
                        btnLuuBangDiem.setEnabled(false);
                    }
                    catch(Exception ex){
                        Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
        pack();
    }
}



