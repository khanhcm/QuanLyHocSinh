/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import static javax.swing.SwingUtilities.invokeLater;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author CaoMinh
 * class MainForm
 * contains main method
 */
public class MainForm extends JFrame{
    
    private JTabbedPane tabbedPane;
    private JPanel panelHoSo;
    private JPanel panelHocTap;
    private JPanel panelMain;
    private JButton btnKtNamHoc;
    private JButton btnDsLopHoc;
    private JButton btnHsGiaoVien;
    private JButton btnSuaQuyDinh;
    private JButton btnTiepNhanHs;
    private JButton btnTraCuuHs;
    private JButton btnPhanLopHs;
    private JButton btnNhapDiem;
    private JButton btnBcMonHoc;
    private JButton btnBCHocKy;
    
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    public MainForm(){
        initComponents();
    }
    
    public static void main(String args[]){
        invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                                  "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                                //  "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                                //UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                MainForm mainForm = new MainForm();
                mainForm.setBounds(0,0,1024,768);
                mainForm.setVisible(true);
            }
        });
        
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();
        panelHoSo = new JPanel();
        panelHocTap = new JPanel();
        panelMain = new JPanel();
        btnKtNamHoc = new JButton();
        btnDsLopHoc = new JButton();
        btnHsGiaoVien = new JButton();
        btnSuaQuyDinh = new JButton();
        btnTiepNhanHs = new JButton();
        btnTraCuuHs = new JButton();
        btnPhanLopHs = new JButton();
        btnNhapDiem = new JButton();
        btnBcMonHoc = new JButton();
        btnBCHocKy = new JButton();
        
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ HỌC SINH");
        setForeground(java.awt.Color.LIGHT_GRAY);
        setIconImages(null);
        
        
        
        btnKtNamHoc.setIcon(new ImageIcon("DataIcon/khoahoc.png"));
        btnKtNamHoc.setText("<html>"+"Khởi tạo "+"<br>"+"năm học"+"</html>");
        
        btnDsLopHoc.setIcon(new ImageIcon("DataIcon/dshocsinh.png"));
        btnDsLopHoc.setText("<html>"+"Danh sách "+"<br>"+"lớp học"+"</html>");
                  
        btnHsGiaoVien.setIcon(new ImageIcon("DataIcon/dsgiaovien.png"));
        btnHsGiaoVien.setText("<html>"+"Hồ sơ "+"<br>"+"giáo viên"+"</html>");
        
        btnSuaQuyDinh.setIcon(new ImageIcon("DataIcon/qdsiso.png"));
        btnSuaQuyDinh.setText("<html>"+"Sửa đổi "+"<br>"+"quy định"+"</html>");
        
        btnTiepNhanHs.setIcon(new ImageIcon("DataIcon/hocsinh.png"));
        btnTiepNhanHs.setText("<html>"+"Tiếp nhận "+"<br>"+"học sinh"+"</html>");
        
        btnTraCuuHs.setIcon(new ImageIcon("DataIcon/tracuuhocsinh.png"));
        btnTraCuuHs.setText("<html>"+"Tra cứu "+"<br>"+"học sinh"+"</html>");
        
        btnPhanLopHs.setIcon(new ImageIcon("DataIcon/phanlop.png"));
        btnPhanLopHs.setText("<html>"+"Phân lớp "+"<br>"+"học sinh"+"</html>");
        
        btnNhapDiem.setIcon(new ImageIcon("DataIcon/hocluc.png"));
        btnNhapDiem.setText("<html>"+"Nhập điểm "+"<br>"+"môn học"+"</html>");
        
        btnBcMonHoc.setIcon(new ImageIcon("DataIcon/monhoc.png"));
        btnBcMonHoc.setText("<html>"+"Báo cáo kết quả "+"<br>"+"môn học"+"</html>");
        
        btnBCHocKy.setIcon(new ImageIcon("DataIcon/namhoc.png"));
        btnBCHocKy.setText("<html>"+"Báo cáo kết quả "+"<br>"+"học kỳ"+"</html>");
        
        
        
        if(RIGHT_TO_LEFT){
            panelHoSo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        //Use GridBagLayout to manage panel Quản lý hồ sơ
        panelHoSo.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if(shouldFill){
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        if(shouldWeightX){
            c.weightx = 0.5;
        }
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 40;
        panelHoSo.add(btnKtNamHoc, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        panelHoSo.add(btnDsLopHoc, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.5;
        panelHoSo.add(btnHsGiaoVien, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        c.weightx = 0.5;
        panelHoSo.add(btnSuaQuyDinh, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        c.weightx = 0.5;
        panelHoSo.add(btnTiepNhanHs, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        c.weightx = 0.5;
        panelHoSo.add(btnTraCuuHs, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 0;
        c.weightx = 0.5;
        panelHoSo.add(btnPhanLopHs, c);
        
        
        panelMain.setBackground(Color.red);
        tabbedPane.addTab("Quản lý hồ sơ", panelHoSo);
        //Use GridBagLayout to manage panel Quản lý hồ sơ
        panelHocTap.setLayout(new GridBagLayout());
        if(shouldFill){
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        if(shouldWeightX){
            c.weightx = 0.05;
        }
        //c.anchor = GridBagConstraints.NORTHWEST;
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 40;
        
        
        
        panelHocTap.add(btnNhapDiem, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.05;
        
        panelHocTap.add(btnBcMonHoc, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.05;
        c.insets = new Insets(0, 0, 0, 600);
        
        panelHocTap.add(btnBCHocKy, c);
        
        
        tabbedPane.addTab("Quản lý học tập", panelHocTap);
        //Use GroupLayout to manage main form
        
        Container contentPane = this.getContentPane();
        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(tabbedPane, 100, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMain, 668, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tabbedPane, 100, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(panelMain, 668, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            )
        );
        pack();
    }

    
}

