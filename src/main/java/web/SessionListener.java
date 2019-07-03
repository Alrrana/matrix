package web;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent hse) {
        String dateTime = new Date().toString();
        System.out.println("\n===========================\n");
        System.out.println("Создана сессия, Id: " + hse.getSession().getId() + "\n Время создания " + dateTime);
        System.out.println("\n===========================\n");
    }

    public void sessionDestroyed (HttpSessionEvent hse) {
        String dateTime = new Date().toString();
        System.out.println("\n===========================\n");
        System.out.println("Уничтожена сессия, Id: " + hse.getSession().getId() + "\n Время уничтожения " + dateTime);
        System.out.println("\n===========================\n");
    }

}
