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
public class UndoController implements ActionListener
{
  private View view;
  private Application model;
  private CommandInvoker invoker;
  
  public UndoController(View view, Application model, CommandInvoker invoker )
  {
    this.view = view;
    this.model = model;
    this.invoker = invoker;
  }
  
  public void registerEvents()
  {
    view.getBtnUndo().addActionListener(this);         // Undo
  }
  
  @Override
  public void actionPerformed(ActionEvent evt)
  {
        invoker.undoCommand();
  }
}
