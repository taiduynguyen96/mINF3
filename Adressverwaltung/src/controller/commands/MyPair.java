/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

import java.util.ArrayList;

/**
 *
 * @author nguyenta71300
 */
public class MyPair{
    
    private int key;
    private ArrayList<String> value;
    
    public MyPair(int key,ArrayList<String> value){
        this.key = key;
        this.value = value;
    }
    
   public int getKey()
   {
       return key;
   }
   
   public ArrayList<String> getValue()
   {
       return value;
   }
    
}