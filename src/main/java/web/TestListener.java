package web;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Атрибут сессии добавлен:{" + httpSessionBindingEvent.getName() + "," + httpSessionBindingEvent.getValue() + "}");
    }

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Атрибут сессии убран:{" + httpSessionBindingEvent.getName() + "," + httpSessionBindingEvent.getValue() + "}");
    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Атрибут сессии изменён:{" + httpSessionBindingEvent.getName() + "," + httpSessionBindingEvent.getValue() + "}");
    }

}

