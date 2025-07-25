package br.com.guilherme.websocket;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class NotificationRequestDecoder implements Decoder.Text<NotificationRequest>{

	@Override
	public void init(EndpointConfig arg0) {	
	}

	@Override
	public NotificationRequest decode(String json) throws DecodeException {
		JsonObject jsonObj = Json.createReader(new StringReader(json)).readObject();
		String title = jsonObj.getString("title");
		String content = jsonObj.getString("content");
		
		return new NotificationRequest(title, content);
	}

	@Override
	public boolean willDecode(String json) {
		try {
			Json.createReader(new StringReader(json)).readObject();
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	@Override
	public void destroy() {
	}
}
