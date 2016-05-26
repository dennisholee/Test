package org.test;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class Dashboard extends HorizontalLayout implements View {

	public Dashboard() {
		
		Button projectBtn = new Button();
		projectBtn.setIcon(FontAwesome.FOLDER_OPEN);
		
		Button taskBtn = new Button();
		taskBtn.setIcon(FontAwesome.TASKS);
		taskBtn.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!" + "task");
		});
		
		
		Button eventBtn = new Button();
		eventBtn.setIcon(FontAwesome.CALENDAR);
		
		Button notesBtn = new Button();
		notesBtn.setIcon(FontAwesome.PENCIL_SQUARE);
		
		Tree projectTree = new Tree("Project");
		projectTree.addItem("Tasks");
		projectTree.addItem("New");
		projectTree.setParent("New", "Tasks");
		projectTree.setChildrenAllowed("New", false);
		projectTree.addItem("Calender");
		projectTree.addItem("Notes");
		projectTree.addItem("Bill");
		
		
		
		addComponent(projectBtn);
		addComponent(taskBtn);
		addComponent(eventBtn);
		addComponent(notesBtn);
		addComponent(projectTree);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}

}
