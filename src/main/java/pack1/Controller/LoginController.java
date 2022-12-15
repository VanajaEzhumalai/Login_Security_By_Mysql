package pack1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pack1.Service.LoginService;
import pack1.dto.loginRequestDto;
import pack1.dto.signupRequestDto;
import pack1.entity.APIResponse;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginservice;
	@PostMapping("/signup")
	public ResponseEntity<APIResponse> signup(@RequestBody signupRequestDto srd) {
		APIResponse apiResponse=loginservice.signup2(srd);
		return ResponseEntity.status(200).body(apiResponse);	
	}
	@PostMapping("/login")
	public ResponseEntity<APIResponse> login(@RequestBody loginRequestDto lrd) {
		APIResponse apiResponse=loginservice.login2(lrd);
		return ResponseEntity.status(200).body(apiResponse);
		
	}


}
