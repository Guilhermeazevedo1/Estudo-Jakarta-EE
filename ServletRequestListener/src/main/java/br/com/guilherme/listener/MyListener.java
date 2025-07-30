package br.com.guilherme.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


@WebListener
public class MyListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("Request foi destruída");
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
         System.out.println("Request foi inicializada");
         
         HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
         request.setAttribute("nome", "Carlos");
    }
	
}
