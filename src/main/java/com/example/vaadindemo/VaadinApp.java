package com.example.vaadindemo;

import com.example.vaadindemo.domain.Person;
import com.example.vaadindemo.domain.ShoppingList;
import com.sun.javafx.font.FontConstants;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.ui.Field;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@Title("Vaadin Demo App")
@Theme("reindeer")
public class VaadinApp extends UI {
    
    private static final long serialVersionUID = 1L;
    
    @SuppressWarnings("deprecation")
    @Override
    protected void init(VaadinRequest request) {
        
        final AddItemPanel addItemPanel = new AddItemPanel();
        MenuPanel menuPanel = new MenuPanel();
        
        HorizontalLayout l = menuPanel.draw();
        // First set the root content for the UI
        VerticalLayout root = new VerticalLayout();
        
        setContent(root);
        VerticalLayout menuRoot = new VerticalLayout();
        root.addComponent(menuRoot);
        final VerticalLayout content = new VerticalLayout();
        root.addComponent(l);
        root.addComponent(content);

	//Item
        final Table personTable = new Table();

		//container data binding
        //personTable.setContainerDataSource(beanContainer);
        personTable.setSelectable(true);
        personTable.setImmediate(true);

        final BeanItemContainer<ShoppingList> container = new BeanItemContainer<ShoppingList>(ShoppingList.class);
        ShoppingList ls = new ShoppingList("shdbc", null, null);
        container.addBean(ls);
        //menuRoot.addComponent(menu);
        
		//content.addComponent(hl);

        /*
         personTable.addValueChangeListener(new Table.ValueChangeListener() {
			
         private static final long serialVersionUID = 1L;

         @Override
         public void valueChange(ValueChangeEvent event) {
         if(personTable.getValue() != null){
         //new: bind selected item into form
         Person selectedPerson = (Person) personTable.getValue();
         Notification.show("Wybrano osobę " + selectedPerson.toString());
         BeanItem<Person> newPersonBean = new BeanItem<Person>(selectedPerson);
         form.setItemDataSource(newPersonBean);
					
         //imieTF.setValue(selectedPerson.getFirstName()); //manually set form field value
         //--
         }
				
         }
         });*/
	//---
        //new: add person from form into table
        final Button addBtn = new Button("Add");
        
        final Label errLbl = new Label();
        errLbl.setContentMode(ContentMode.HTML);

        /*
         addBtn.addClickListener(new ClickListener() {

         private static final long serialVersionUID = 1L;

         @Override
         public void buttonClick(ClickEvent event) {
				
         try {
         form.commit();
         @SuppressWarnings("unchecked")
         Person newPerson = ((BeanItem<Person>) form.getItemDataSource()).getBean();
         Notification.show("Osoba z formularza " + newPerson.toString());					
         Person p = new Person(newPerson.getFirstName(), newPerson.getYob());
         beanContainer.addBean(p);
         } catch (CommitException e) { //show error message
         for(com.vaadin.ui.Field<?> field: form.getFields()){
         ErrorMessage errmsg = ((AbstractField<?>)field).getErrorMessage();
         if(errmsg != null){
         errLbl.setValue(errmsg.getFormattedHtmlMessage());
         }
         }
         }		
         }
         });*/
		//---
		//setting layout
        //hl.addComponent(personTable);
        //vl.addComponent(formLayout);
        //vl.addComponent(addBtn);
        //vl.addComponent(errLbl);
                //vl.setId("XXX");
        //content.addComponent(vl);
        
        /*Click Listeners*/        
        menuPanel.addItemButton.addClickListener(new ClickListener() {
            
            @Override
            public void buttonClick(ClickEvent event) {
                content.removeAllComponents();
                content.addComponent(addItemPanel.draw(container));
            }
        });
        menuPanel.addListButton.addClickListener(new ClickListener() {
            
            @Override
            public void buttonClick(ClickEvent event) {
                content.removeAllComponents();
            }
        });
    }
    
}
