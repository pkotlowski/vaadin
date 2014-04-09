/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.vaadindemo;

import com.example.vaadindemo.domain.Item;
import com.example.vaadindemo.domain.Person;
import com.example.vaadindemo.domain.ShoppingList;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 *
 * @author Piotr
 */
public class AddItemPanel {
    
    public HorizontalLayout draw(BeanItemContainer<ShoppingList> container){
        final HorizontalLayout x = new HorizontalLayout();
        x.setId("addItemPanel");
        Button persistNewItemButton = new Button("Dodaj");
        final Item item = new Item();
		BeanItem<Item> personBean = new BeanItem<Item>(item);
		
		final FormLayout formLayout = new FormLayout();
		
		final FieldGroup form = new FieldGroup(); //new name: form
		
		form.setItemDataSource(personBean); 
		form.setBuffered(true); 
		
		Field imieField = form.buildAndBind("Name", "firstName");
		imieField.setRequired(true);
		imieField.addValidator(new StringLengthValidator("bad length", 2, 5, false));
		formLayout.addComponent(imieField);
				
	//Container
		final BeanItemContainer<Item> beanContainer = new BeanItemContainer<Item>(Item.class);
                //beanContainer.addBean(new Item();
		//beanContainer.addBean(new Item("Bolek"));
		//beanContainer.addBean(new Person("Lolek", 1933));
                
                

    // Put some example data in it
    container.addItem(new ShoppingList("Mercury",null,null));
    //container.addItem(new Planet(2, "Venus"));
    //container.addItem(new Planet(3, "Earth"));
    //container.addItem(new Planet(4, "Mars"));

    // Create a selection component bound to the container
    final ComboBox select = new ComboBox("Planets", container);

    // Set the caption mode to read the caption directly
    // from the 'name' property of the bean
    select.setItemCaptionMode(ItemCaptionMode.PROPERTY);
    select.setItemCaptionPropertyId("name");
          select.setImmediate(true);
    final Label ldd = new Label();
    
                
        x.addComponent(select);
        x.addComponent(formLayout);
        x.addComponent(persistNewItemButton);
        x.addComponent(ldd);
        persistNewItemButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                Label l = new Label("jsdcbsc");
                x.addComponent(l);
                //ldd.setValue(select.getItem(item.firstName).toString());
            }
        });
      
        select.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               
               ldd.setValue(select.getItemCaption(event.getProperty().getValue()));
            }
        });
        return x;
    }
}
