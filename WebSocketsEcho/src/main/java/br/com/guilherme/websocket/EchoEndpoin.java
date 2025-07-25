package br.com.guilherme.websocket;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/server")
public class EchoEndpoin{

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println("Conexão Aberta!");
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println("Conexão Fechada!");
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.out.println("Erro");
		throwable.printStackTrace();
	}
	
	@OnMessage
	public void onMessage(Session session, String message) throws IOException {
		System.out.println("Mensagem recebida " + message);
		
		session.getBasicRemote().sendText(message);
	}
	
	
	
}
