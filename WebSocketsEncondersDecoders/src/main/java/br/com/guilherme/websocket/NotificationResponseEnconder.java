package br.com.guilherme.websocket;

import java.io.StringWriter;
import java.time.format.DateTimeFormatter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class NotificationResponseEnconder implements Encoder.Text<NotificationResponse>{

	

	@Override
	public void init(EndpointConfig arg0) {

	}

	@Override
	public String encode(NotificationResponse notificationResponse) throws EncodeException {
		JsonObject jsonObj = Json.createObjectBuilder()
			.add("time", notificationResponse.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
			.add("assignedId", notificationResponse.getAssignedId())
			.build();
		
		StringWriter out = new StringWriter();
		Json.createWriter(out).writeObject(jsonObj);
		return out.toString();
	}
	
	@Override
	public void destroy() {
	}
}
