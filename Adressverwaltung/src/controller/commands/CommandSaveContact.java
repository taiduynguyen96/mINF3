/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import model.Application;
import view.View;

/**
 *
 * @author nguyenta71300
 */
public class CommandSaveContact implements CommandInterface
{
    private View view;
    private Application app;
    private Preferences prefs = Preferences.userRoot().node(getClass().getName());
    private final String LAST_USED_FOLDER = " ";
    
    public CommandSaveContact(View view, Application app)
    {
        this.view = view;
        this.app = app;
    }
   
   
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {   
//        // Save with File Choose
//        int option = view.getFileChooseOpen().showSaveDialog(view);
//        if(option == JFileChooser.APPROVE_OPTION)
//        {
//            File file = view.getFileChooseOpen().getSelectedFile();
//            //view_.getjPanel1().setVisible(true);
//            try
//            {
//                app.datenSpeichern(file);
//            } catch (IOException ex)
//            {
//                Logger.getLogger(CommandSaveContact.class.getName()).log(Level.SEVERE, null, ex);
//            } 
//            view.getLbData().setText("Saved to: " + file.getAbsolutePath());
//        }
        
        // Save to opened File
//        File saved_file = app_.getOpenedFile();
//        if(saved_file != null)
//        {
//            try
//            {
//                app_.datenSpeichern(saved_file);
//            } catch (IOException ex)
//            {
//                Logger.getLogger(SaveController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            view_.getLbData().setText("Saved to: " + saved_file.getAbsolutePath());
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(view_, "Error: No file to save");
//        }
//      } 

    @Override
    public void execute()
    {
        // Save with File Choose
        int option = view.getFileChooseOpen().showSaveDialog(view);
        if(option == JFileChooser.APPROVE_OPTION)
        {
            File file = view.getFileChooseOpen().getSelectedFile();
            //view_.getjPanel1().setVisible(true);
            try
            {
                app.datenSpeichern(file);
                prefs.put(LAST_USED_FOLDER, file.getParent());

            } catch (IOException ex)
            {
                Logger.getLogger(CommandSaveContact.class.getName()).log(Level.SEVERE, null, ex);
            } 
            view.getLbData().setText("Saved to: " + file.getAbsolutePath());
        }
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
