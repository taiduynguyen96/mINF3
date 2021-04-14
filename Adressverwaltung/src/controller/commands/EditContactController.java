/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Application;
import view.View;

/**
 *
 * @author nguyenta71300
 */
public class EditContactController implements ActionListener
{
    private View view;
    private Application app;
    private int toEditRow = 0;
    final private int NAME_COLUMN = 0;
    
    public EditContactController(View view, Application app)
    {
        this.view = view;
        this.app = app;
    }
    
    public void registerEvents()
    {
        view.getBtnUndo().addActionListener(this);
    }

    boolean isNameValid(Object name)
    {
        for(int i = 0; i < app.getRowCount(); i++)
        {
            // Using equals() for content and "==" for references.
            if(name.equals(app.getValueAt(i, NAME_COLUMN)))
            {
                toEditRow = i;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {   
        DefaultTableModel dtm = (DefaultTableModel) view.getTableAddressBook().getModel();
        
        Object input = JOptionPane.showInputDialog(view, "Enter: Name");
        if(input != null && isNameValid(input))
        {
            System.out.println("EditContactController: input name found: " + input);
            for (int i = NAME_COLUMN; i < app.getColumnCount(); i++)
            {
                Object new_input = JOptionPane.showInputDialog(view, "Enter: " + app.getColumnName(i));
                System.out.println(input);
                if(new_input == null)
                {
                    break;
                }
                else
                {
                    // Set new value to JTable cell
                    dtm.setValueAt(new_input, toEditRow, i);
                    // Set new value to iternal cell
                    app.setValueAt( new_input, toEditRow, i);
                }
            }
        }
        //TODO: else when to edit contact not found ....

        System.out.println("EditContactController: app_.daten row count: " +app.getRowCount());
        System.out.println("EditContactController: app_.daten column count: " +app.getColumnCount());
    }
}
