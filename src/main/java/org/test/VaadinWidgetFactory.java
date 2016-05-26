package org.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class VaadinWidgetFactory implements WidgetFactory {

	private final static Logger logger = LoggerFactory.getLogger(VaadinWidgetFactory.class);
	
	private static WidgetFactory instance = new VaadinWidgetFactory();

	private VaadinWidgetFactory() {
	}

	public Widget create(String widgetName) {
		AbstractComponent instance = null;
		
		logger.debug("Creating widget %s".format(widgetName));

		switch (widgetName) {
		case "TextField":
			instance = new TextField();
			break;
		case "TextArea":
			instance = new TextArea();
			break;
		case "Button":
			instance = new Button();
			break;
		case "Select" :
			instance = new ListSelect();
			((ListSelect) instance).setRows(1);
			break;
		default:
			// TODO
		}

		return new VaadinWidget(instance);
	}

	public static WidgetFactory instance() {
		return instance;
	}

}
