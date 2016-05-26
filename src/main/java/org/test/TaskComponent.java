package org.test;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.test.WidgetFactoryBuilder.WIDGET;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class TaskComponent extends FormLayout implements View {

	public TaskComponent() throws JsonParseException, IOException {
		super();

		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(TaskComponent.class.getResourceAsStream("task.json"));
		parser.nextToken();
		
		WidgetFactory widgetFactory = WidgetFactoryBuilder.build(WIDGET.VAADIN);
		
		while (parser.nextToken() != JsonToken.END_OBJECT) {

			String key = parser.getCurrentName();

			if (JsonToken.START_ARRAY.equals(parser.nextToken())) {
				// System.out.println("+ " + );

				while (!JsonToken.END_ARRAY.equals(parser.nextToken())) {

					System.out.println("++ " + parser.nextToken());
					System.out.println("+++ " + parser.nextToken());

					// Label
					System.out.println("++++ " + parser.getCurrentName());
					System.out.println(parser.getValueAsString());
					String label = parser.getValueAsString();

					parser.nextToken();
					parser.nextToken();

					// Widget
					System.out.println("+++++ " + parser.getCurrentName());
					System.out.println(parser.getValueAsString());
					
					Widget<AbstractComponent> widget = widgetFactory.create(parser.getValueAsString());
					widget.setLabel(label);
					addComponent(widget.build());
					/*
					switch(parser.getValueAsString()) {
					case "TextField":
						TextField textField = new TextField(label);
						addComponent(textField);
						break;
					case "TextArea":
						TextArea textArea = new TextArea(label);
						addComponent(textArea);
						break;
					case "Button":
						Button btn = new Button(label);
						addComponent(btn);
						break;
					}
					*/
					System.out.println("++++++ " + parser.nextToken());
				}

				//
				// "components" : [
				// { "label" : "", "component" : "TextField" }
				// ]
				//

				continue;
			}

			if (key == null) {
				parser.nextToken();
				continue;
			}

			switch (key) {
			case "title":
				String value = parser.getValueAsString();
				UI.getCurrent().getPage().setTitle(value);
				break;
			// case "components":
			// System.out.println("components");
			// System.out.println(">>" + parser.nextToken());
			// System.out.println(">>>" + parser.nextToken());
			// System.out.println(parser.nextFieldName());
			//
			//
			// if (parser.nextToken() == JsonToken.START_ARRAY) {
			// System.out.println(parser.getCurrentName());
			// while (parser.nextToken() != JsonToken.END_ARRAY) {
			// parser.nextToken();
			// System.out.println(parser.getCurrentName());
			//
			// }
			// }
			}
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
