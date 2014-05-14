/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author CaoMinh
 */
public class FormNhapDiem extends JInternalFrame{
    private JLabel lblNamHoc;
    private JLabel lblHocKy;
    private JLabel lblMonHoc;
    private JComboBox cbbNamHoc;
    private JComboBox cbbHocKy;
    private JComboBox cbbMonHoc;
    private JTextField textfield;
    

    public FormNhapDiem() {
        initComponents();
    }

    private void initComponents() {
        
        pack();
    }
}
