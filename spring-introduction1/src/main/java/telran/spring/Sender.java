package telran.spring;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.spring.service.SenderService;

@Component
public class Sender {
	
	Map<String, SenderService> mapServices;
	@Autowired
	public Sender(List<SenderService> services) {
		mapServices = services.stream().collect(Collectors.toMap(SenderService::getType, s -> s));
	}

public Sender() {
	System.out.println("Sender constructor");
}
public SenderService getServiceByType(String type) {
	return mapServices.get(type);
}
public String getSenderGreeting() {
	return "Hi, I'm a sender";
}


}