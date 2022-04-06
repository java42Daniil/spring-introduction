package telran.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import telran.spring.Sender;
import telran.spring.dto.Message;
import telran.spring.service.SenderService;

@RestController
@RequestMapping("/messages")
public class SenderController {
	@Autowired
	Sender sender;
	@PostMapping
	String sendMessage(@RequestBody Message message) {
		SenderService service = sender.getServiceByType(message.senderType);
		if (service == null) {
			return String.format("service %s is not implemented", message.senderType);
		}
		service.send(message.text);
		return "message has been sent - see logs";
	}

}