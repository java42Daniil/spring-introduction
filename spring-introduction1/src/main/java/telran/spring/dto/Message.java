package telran.spring.dto;

public class Message {

public String senderType;
public String text;
public Message() {
}
public Message(String senderType, String message) {
	this.senderType = senderType;
	this.text = message;
}
}