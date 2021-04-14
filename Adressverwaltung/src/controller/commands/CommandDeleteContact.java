/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import javax.swing.JOptionPane;
import model.Application;
import view.View;

/**
 *
 * @author nguyenta71300
 * @version 1.0
 */
public class CommandDeleteContact implements CommandInterface
{
    private View view;
    private Application app;
    private int toDeleteRow = 0;
    private Stack<MyPair> deletedRowStack;
    
    public CommandDeleteContact(View view, Application app)
    {
        this.view = view;
        this.app = app;
        this.deletedRowStack = new Stack<>();
    }
  
    @Override
    public void execute()
    {
        int selectedRow = view.getTableAddressBook().getSelectedRow();
        if (selectedRow >= 0)
        {   
            deletedRowStack.push(new MyPair(selectedRow, app.getRowData(selectedRow)));
            app.eintragLoeschen(selectedRow);
            JOptionPane.showMessageDialog(view, "Row deleted");
        } 
        else
        {
            JOptionPane.showMessageDialog(view, "Unable to delete");
        }
            
    }

    @Override
    public void undo()
    {
        if(!deletedRowStack.empty())
        {
             MyPair toRecoverRow = deletedRowStack.pop();
             app.eintragHinzufuegenInplace(toRecoverRow.getKey(),toRecoverRow.getValue());
        }
        view.getLbData().setText("Undo: ");
    }
    
    /**
     * 
     * @return true falls cmd .....
     */
    @Override
    public boolean isUndoable()
    {
        return true;
    }
        
}
