/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.vaadindemo.domain;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Piotr
 */
public class ShoppingList {    
    public String name;
    public Date creationDate;
    public List<Item> itemList;

    public ShoppingList(String name, Date creationDate, List<Item> itemList) {
        this.name = name;
        this.creationDate = creationDate;
        this.itemList = itemList;
    }

   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    
}
