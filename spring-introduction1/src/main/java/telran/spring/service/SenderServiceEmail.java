package telran.spring.service;

import org.springframework.stereotype.Service;

@Service
public class SenderServiceEmail implements SenderService {

	@Override
	public void send(String message) {
		System.out.printf("message: %s has been sent to email\n", message);

	}

	@Override
	public String getType() {
		
		return "email";
	}

}