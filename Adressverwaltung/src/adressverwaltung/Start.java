/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressverwaltung;

import controller.CommandController;
import controller.CommandInvoker;
import controller.UndoController;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Application;
import view.View;

/**
 *
 * @author nguyenta71300
 */
public class Start
{
    private View view;
    private Application app;
    private CommandInvoker ctrlInvoker;
    private CommandController ctrlCommand;
    private UndoController ctrlUndo;
    
    public Start()
    {
        this.view = new View();
        this.app = new Application(); 
        this.ctrlInvoker = new CommandInvoker();
        view.getTableAddressBook().setModel(app);
        
        this.ctrlCommand = new CommandController(view, app, ctrlInvoker);
        ctrlCommand.registerEvents();
        ctrlCommand.registerCommands();
        
        this.ctrlUndo = new UndoController(view, app, ctrlInvoker);
        ctrlUndo.registerEvents();
        
        view.setVisible(true);
    }
            
    public static void main(String[] args)
    {
        try
        {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(null, e.toString());
        }
        new Start();
    }
    
}
