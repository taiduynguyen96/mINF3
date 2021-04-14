/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.commands.CommandAddContact;
import controller.commands.CommandDeleteContact;
import controller.commands.CommandOpen;
import controller.commands.CommandSaveContact;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Application;
import view.View;

/**
 *
 * @author le
 */
public class CommandController implements ActionListener
{
  private View view;
  private Application model;
  private CommandInvoker invoker;
  
  public CommandController(View view, Application model, CommandInvoker invoker)
  {
    this.view = view;
    this.model = model;
    this.invoker = invoker;
  }
  
  public void registerEvents()
  {
    view.getMnuItemOpen().addActionListener(this);     // Open
    view.getBtnAddContact().addActionListener(this);   // Add
    view.getBtnSave().addActionListener(this);         // Save
    view.getMnuItemSave().addActionListener(this);
    view.getBtnDeleteContact().addActionListener(this);   
    // usw.
  }
  
  public void registerCommands()
  {
    CommandOpen cmdOpen = new CommandOpen(view, model);
    invoker.addCommand(view.getMnuItemOpen(), cmdOpen);
    
    CommandAddContact cmdAddContact = new CommandAddContact(view, model);
    invoker.addCommand(view.getBtnAddContact(), cmdAddContact);
    
    CommandSaveContact cmdSaveContact = new CommandSaveContact(view, model);
    invoker.addCommand(view.getBtnSave(), cmdSaveContact);
    invoker.addCommand(view.getMnuItemSave(), cmdSaveContact);

    CommandDeleteContact cmdDeleteContact = new CommandDeleteContact(view, model);
    invoker.addCommand(view.getBtnDeleteContact(), cmdDeleteContact);
    //usw.
    
  }

  @Override
  public void actionPerformed(ActionEvent evt)
  {
    Object key = evt.getSource();
    invoker.executeCommand(key);
  }
}
