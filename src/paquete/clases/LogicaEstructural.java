/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.clases;

import javax.swing.JTable;
import javax.swing.table.TableColumn;


/**
 *
 * @author Junior
 */
public class LogicaEstructural {
    
    public void addChecker(JTable table)
    {
        TableColumn tc = table.getColumnModel().getColumn(6);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }
    
}
