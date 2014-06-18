/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cong Ly Nguyen
 */
public class OtherMethod {
    
    public static void updateComboBox(JComboBox cbb,ResultSet rs) throws SQLException
    {
        cbb.removeAllItems();
        while (rs.next()) 
        {
            cbb.addItem(rs.getString(1));
        }
    }
    
    public static void updateTable(JTable table, ResultSet rs, String[] columnNames) throws SQLException
    {
        Vector column = new Vector();
        Vector data = new Vector();

        ResultSetMetaData metaData;
        metaData = rs.getMetaData();
        int columns = metaData.getColumnCount();
        for (int i = 0; i < columnNames.length; i++) {
            column.addElement(columnNames[i]);
        }
        while (rs.next()) {
            Vector row = new Vector(columns);
            for (int i = 1; i <= columns; i++) {
                row.addElement(rs.getObject(i));
            }
            data.addElement(row);
        }
        table.setModel(new DefaultTableModel(data, column));
    }
    public static void updateTableWithNotEditable(JTable table, ResultSet rs, String[] columnNames) throws SQLException
    {
        Vector column = new Vector();
        Vector data = new Vector();

        ResultSetMetaData metaData;
        metaData = rs.getMetaData();
        int columns = metaData.getColumnCount();
        for (int i = 0; i < columnNames.length; i++) {
            column.addElement(columnNames[i]);
        }
        while (rs.next()) {
            Vector row = new Vector(columns);
            for (int i = 1; i <= columns; i++) {
                row.addElement(rs.getObject(i));
            }
            data.addElement(row);
        }
        table.setModel(new DefaultTableModel(data, column){
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
       }
        });        
    }
    
    public static void removeRow(JTable table, int k)
    {
        Vector columnName = new Vector();
        Vector data = new Vector();
        for (int column = 0; column < table.getModel().getColumnCount(); column++) {
            columnName.addElement(table.getModel().getColumnName(column));
        }
        for (int row = 0; row < table.getModel().getRowCount(); row++) {
            Vector currentrow = new Vector(table.getModel().getColumnCount());
            for (int column = 0; column < table.getModel().getColumnCount(); column++) {
                currentrow.addElement(table.getModel().getValueAt(row, column).toString());
            }
            data.addElement(currentrow);
        }
       
        data.removeElementAt(k);
        table.setModel(new DefaultTableModel(data, columnName));
    }
    
    public static void addRow(JTable table, Vector rowData)
    {
        Vector columnName = new Vector();
        Vector data = new Vector();
        for (int column = 0; column < table.getModel().getColumnCount(); column++) {
            columnName.addElement(table.getModel().getColumnName(column));
        }
        for (int row = 0; row < table.getModel().getRowCount(); row++) {
            Vector currentrow = new Vector(table.getModel().getColumnCount());
            for (int column = 0; column < table.getModel().getColumnCount(); column++) {
                currentrow.addElement(table.getModel().getValueAt(row, column).toString());
            }
            data.addElement(currentrow);
        }
        data.addElement(rowData);
        table.setModel(new DefaultTableModel(data, columnName));
    }
    
    public static int getInt(ResultSet rs)
    {
        int result = 0;
        try {
            while (rs.next()) {
                result = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static String getString(ResultSet rs)
    {
        String result = "";
        try {
            while (rs.next()) {
                result = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormXepLop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static void clearTable(JTable tbl, String[] columnNames)
    {
        Vector column = new Vector();
        Vector data = new Vector();
        data.removeAllElements();
        int columns = columnNames.length;
        for (int i = 0; i < columnNames.length; i++) {
            column.addElement(columnNames[i]);
        }
        tbl.setModel(new DefaultTableModel(data, column)); 
    }
}
