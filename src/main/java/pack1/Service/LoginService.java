package pack1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack1.dto.loginRequestDto;
import pack1.dto.signupRequestDto;
import pack1.entity.APIResponse;
import pack1.entity.User;
import pack1.repo.UserRepo;
import pack1.util.JwtUtils;
@Service
public class LoginService {
	@Autowired
	private UserRepo userrpo;
	@Autowired
	private JwtUtils jwtutils;
	public APIResponse signup2(signupRequestDto signupReqDto) {
		APIResponse apiresponse =new APIResponse(); 
		//validation
		 
		//dto to entity
		User user=new User();
		user.setUsername(signupReqDto .getUsername());
		user.setEmailId(signupReqDto.getEmailId());
		user.setGender(signupReqDto.getGender());
		user.setPassword(signupReqDto.getPassword());
		user.setPhonenumber(signupReqDto.getPhonenumber());
		//store entity
		user=userrpo.save(user);
		
		
//		apiresponse.setData("User data created successfully!!!");
		apiresponse.setData(user);
		return apiresponse; 
	}
	public APIResponse login2(loginRequestDto lrd) {
		APIResponse apiresponse =new APIResponse(); 
		//validation
		//verify user exist with given username and password
		
//		User user=userrpo.findOneByUsernameIgnoreCaseAndPassword(loginRequestDto.getUsername(),loginRequestDto.getPassword());
		
		List<User> user=(List<User>) userrpo.findAll();
		for(User u: user) {
			if(u.getUsername().equals(lrd.getUsername()) && u.getPassword().equals(lrd.getPassword())) {
				String token=jwtutils.generateJwt(u);
				apiresponse.setData(token);
				return apiresponse;
			}
			else if(!u.getUsername().equals(lrd.getUsername()) && u.getPassword().equals(lrd.getPassword())) {
				apiresponse.setData("Username Doesn't match with your password!!");
				return apiresponse;
			}
			else if(u.getUsername().equals(lrd.getUsername()) && !u.getPassword().equals(lrd.getPassword())) {
				apiresponse.setData("Password doesn't match with your username!!");
				return apiresponse;
			}
			
		}
		
//		if(user==null) {
//			apiresponse.setData("User login failed!!!");
//			return apiresponse;
//		}
//		//generate jwt
//		String token=jwtutils.generateJwt(user);
		apiresponse.setData("Invalid credentials!!");
		return apiresponse;
//	} 
	}

}
