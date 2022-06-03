package com.example.documentmanager;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class TestView extends VerticalLayout {

    public TestView() {
        Text text = new Text("Hello world in vaadin");
        add(text);

        Button button = new Button();
        button.setText("Click here");
        button.addClickListener(buttonClickEvent -> Notification.show("Successful click"));

        add(button);
    }
}
