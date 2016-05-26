package org.test;

public class WidgetFactoryBuilder {
	public enum WIDGET {
		VAADIN
	}

	public static WidgetFactory build(WIDGET value) {
		switch(value) {
		case VAADIN:
			return VaadinWidgetFactory.instance();
		default:
			// TODO:
			throw new RuntimeException();
		}

	}

}
