package org.test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.navigator.Navigator;

import java.io.File;


/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@SpringUI
@Widgetset("org.test.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final CssLayout topBar = new CssLayout();
        final CssLayout viewLayout = new CssLayout();

        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue()
                    + ", it works!"));
            Notification.show("Test");
        });

        layout.addComponent(topBar);
        layout.addComponent(viewLayout);
        
        final Navigator navigator = new Navigator(this, viewLayout);
        navigator.addView("login", LoginPage.class);
        navigator.addView("dashboard", Dashboard.class);
        navigator.addView("task", TaskComponent.class);
        navigator.navigateTo("login");
        
        
        /*
        layout.addComponents(name, button);

        FilesystemContainer dataSource = new FilesystemContainer(new File("data.txt"));
        ComboBox fileSelector = new ComboBox("", dataSource);

        layout.addComponents(fileSelector);
        
        layout.addComponent(new LoginComponent());

        layout.setMargin(true);
        layout.setSpacing(true);
*/
        setContent(layout);
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
