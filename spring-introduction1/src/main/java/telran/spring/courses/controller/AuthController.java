package telran.spring.courses.controller;

import java.util.Base64;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import telran.spring.courses.dto.*;
import telran.spring.courses.exceptions.BadRequestException;
import telran.spring.courses.security.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class AuthController {
	static Logger LOG = LoggerFactory.getLogger(AuthController.class);
	AccountingManagement accounting;
	PasswordEncoder passwordEncoder;
	
	@Value("${app.security.enable: true}")
	private boolean securityEnable;
	
	public AuthController(AccountingManagement accounting, PasswordEncoder passwordEncoder) {
		this.accounting = accounting;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping
	LoginResponse login( @RequestBody @Valid LoginData loginData) {
		LOG.debug("login data are email {}, password: {}", loginData.email, loginData.password);
		Account account = accounting.getAccount(loginData.email);
		
		if(account == null || !passwordEncoder.matches(loginData.password, account.getPasswordHash())) {
			throw new BadRequestException("Wrong credentials");
		}
		LoginResponse response = new LoginResponse(getToken(loginData), account.getRole());
		LOG.debug("accessToken: {}, role {}", response.accessToken, response.role);
		return response;
	}

	private String getToken(LoginData loginData) {
		//"Basic <username:password> in Base64 code
		byte[] code = String.format("%s:%s", loginData.email, loginData.password).getBytes();
		return "Basic " + Base64.getEncoder().encodeToString(code);
	}

}