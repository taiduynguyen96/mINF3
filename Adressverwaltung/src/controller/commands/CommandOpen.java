/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

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
public class CommandOpen implements CommandInterface
{
    private View view;
    private Application app;
    private Preferences prefs = Preferences.userRoot().node(getClass().getName());
    private final String LAST_USED_FOLDER = " ";
    
    public CommandOpen(View view, Application app)
    {
        this.view = view;
        this.app = app;
    }
    
    @Override
    public void execute()
    {   
        view.getFileChooseOpen().setCurrentDirectory(new File(prefs.get( LAST_USED_FOLDER, new File(".").getAbsolutePath())));
        int choice = view.getFileChooseOpen().showOpenDialog(view);
        if (choice == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = view.getFileChooseOpen().getSelectedFile();
            view.getLbData().setText("File: " + selectedFile.getAbsolutePath());
            try
            {
              app.datenLesen(selectedFile);
              prefs.put(LAST_USED_FOLDER, selectedFile.getParent());
            } catch (IOException ex)
            {
                Logger.getLogger(CommandOpen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(CommandOpen.class.getName()).log(Level.SEVERE, null, ex);
            }
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
