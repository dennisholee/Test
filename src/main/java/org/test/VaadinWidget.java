package org.test;

import com.vaadin.ui.AbstractComponent;

public class VaadinWidget implements Widget<AbstractComponent> {
	private AbstractComponent component;
	
	public VaadinWidget(AbstractComponent component) {
		this.component = component;
	}

	@Override
	public Widget setLabel(String label) {
		this.component.setCaption(label);
		return this;
	}

	@Override
	public Widget setURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractComponent build() {
		return component;
	}
	

}
