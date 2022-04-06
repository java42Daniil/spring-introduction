package telran.spring.service;

import org.springframework.stereotype.Service;

@Service
public class SenderServiceSms implements SenderService {

	@Override
	public void send(String message) {
		System.out.printf("message: %s has been sent to SMS server\n", message);
		

	}

	@Override
	public String getType() {
		
		return "sms";
	}

}