package telran.spring.courses.dto;

public class LoginResponse {
public String accessToken;
public String role;
public LoginResponse() {
}
public LoginResponse(String accessToken, String role) {
	this.accessToken = accessToken;
	this.role = role;
}

}