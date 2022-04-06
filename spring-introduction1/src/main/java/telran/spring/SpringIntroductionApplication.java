package telran.spring;

import java.util.Scanner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringIntroductionApplication {
	

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringIntroductionApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		Sender sender = ctx.getBean(Sender.class);
		System.out.println(sender.getSenderGreeting());
		
		while(true) {
			System.out.println("Enter  exit for graceful shutdown");
			String line = scanner.nextLine();
			if (line.equals("exit")) {
				ctx.close();
				break;
			}
			
			
			
			
		}
	}
	

}