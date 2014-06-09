/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BLL.HocKyBLL;
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
import javax.swing.JTable;

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
        lblBangDiem = new JLabel("BẢNG ĐIỂM MÔN HỌC ");
        lblLop = new JLabel("Lớp: ");
        lblMonhoc1 = new JLabel();
        lblNamHoc1 = new JLabel();
        lblLop1 = new JLabel();
        lblHocky1 = new JLabel();
        lblGvcn = new JLabel("GVCN: ");
        lblGvcn1 = new JLabel();
        tableLop = new JTable(10,1);
        tableBangDiem = new JTable(10,10);
        
        
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
                .addComponent(lblNamHoc1)
                .addComponent(lblGvcn)
                .addComponent(lblGvcn1)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblMonhoc1)
                .addComponent(lblLop)
                .addComponent(lblLop1)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblHocKy2)
                .addComponent(lblHocky1)
            )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblBangDiem)
                .addComponent(lblMonhoc1)
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
        //Panel 3 & 4
        panel3.add(tableLop);
        panel4.add(tableBangDiem);
        
        
        
        Container contentPane = this.getContentPane();
        setForeground(java.awt.Color.LIGHT_GRAY);
        if(RIGHT_TO_LEFT){
            contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        //Use GridBagLayout to manage panel Quản lý hồ sơ
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        if(shouldFill){
            c.fill = GridBagConstraints.NORTHWEST;
        }
        if(shouldWeightX){
            c.weightx = 0.5;
        }
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        c.insets = new Insets(0, 0, 0, 200);
        contentPane.add(panel1, c);
        
        c.anchor = GridBagConstraints.LINE_END;
        c.gridheight = 1;
        c.weightx = 0.7;
        c.gridx = 1;
        c.gridy = 0;
        contentPane.add(panel2, c);
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.3;
        c.gridx = 0;
        c.gridy = 2;
        contentPane.add(panel3, c);
        
        c.anchor = GridBagConstraints.LINE_END;
        c.weightx = 0.7;
        c.gridheight = 2;
        c.gridx = 1;
        c.gridy = 1;
        contentPane.add(panel4, c);
        
        
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
        if(cbbNamHoc.getSelectedItem().toString()!=""){
            ResultSet rsHocKy = hocky.layDanhSachHocKy(cbbNamHoc.getSelectedItem().toString());
            try {
                while(rsHocKy.next()){
                    cbbHocKy.addItem(rsHocKy.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormNhapDiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        pack();
    }
}
