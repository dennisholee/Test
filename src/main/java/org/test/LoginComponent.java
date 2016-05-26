package org.test;

import com.vaadin.data.validator.NullValidator;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginComponent extends FormLayout {
	
	public LoginComponent() {
		
		TextField userTxtFld = new TextField("Username");
		userTxtFld.setIcon(FontAwesome.USER);
		userTxtFld.setRequired(true);
		userTxtFld.addValidator(new NullValidator("Must be given", false));
		
		
		PasswordField passwdTxtFld = new PasswordField("Password");
		passwdTxtFld.setRequired(true);
		passwdTxtFld.addValidator(new NullValidator("Must be given", false));
		passwdTxtFld.setIcon(FontAwesome.KEY);
		
		Button loginBtn = new Button("Login");
		loginBtn.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!" + "dashboard");
		});
		
		
		addComponent(userTxtFld);
		addComponent(passwdTxtFld);
		addComponent(loginBtn);
		
	}
}
