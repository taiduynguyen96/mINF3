/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Application;
import view.View;

/**
 *
 * @author nguyenta71300
 */
public class CommandAddContact implements CommandInterface
{
    private View view;
    private Application app;
    
    public CommandAddContact(View view, Application app)
    {
        this.view = view;
        this.app = app;
    }
    

//    @Override
//    public void actionPerformed(ActionEvent e)
//    {   
//        DefaultTableModel dtm = (DefaultTableModel) view.getTableAddressBook().getModel();
//        
//        boolean inputCancel = false;
//        Object[] rowData = new Object[app.getColumnCount()];
//        for (int i = 0; i < app.getColumnCount(); i++)
//        {
//            Object input = JOptionPane.showInputDialog(view, "Enter: " + app.getColumnName(i));
//            if(input == null)
//            {
//                inputCancel = true;
//                break;
//            }
//            else
//            {
//                rowData[i] = input;
//            }
//        }
//        if(!inputCancel)
//        {   
//            // Add row to JTable model
//            dtm.addRow(rowData);
//            
//            // Add row to internal model
//            app.eintragHinzufuegen();
//            for (int i = 0; i < app.getColumnCount(); i++)
//            {   
//                app.setValueAt(rowData[i], app.getRowCount()-1, i);
//            }
//        }
//        else 
//        {
//            JOptionPane.showMessageDialog(view, "Cancel adding contact");
//        }
//        //
//        System.out.println("AddContactController: app_.daten row count: " +app.getRowCount());
//        System.out.println("AddContactController: app_.daten column count: " +app.getColumnCount());
//
//    }

    @Override
    public void execute()
    {
        app.eintragHinzufuegen();
    }

    @Override
    public void undo()
    {
    }

    @Override
    public boolean isUndoable()
    {
        return false;
    }
}
