/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.vaadindemo;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 *
 * @author Piotr
 */
public class MenuPanel {
    public Button addItemButton;
    public Button addListButton;
    
    public HorizontalLayout draw(){    
        
    HorizontalLayout menu = new HorizontalLayout();
    addItemButton = new Button("Dodaj do listy");
    addListButton = new Button("Dodaj listę");
    Label appTitle = new Label("Organizator zakupów");
    appTitle.setId("appTitle");
    
    menu.addComponent(appTitle);
    menu.addComponent(addItemButton);
    menu.addComponent(addListButton);
    return menu;
}}
