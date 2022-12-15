package pack1.util;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import pack1.entity.User;

@Component
public class JwtUtils {
	private static String secret="This_is_secret";
	private static long expiryDuration=60*60;
	public String generateJwt(User user) {
		//claims
//		long millsec=System.currentTimeMillis();
//		long expirytime=millsec+expiryDuration;
//		Date expiredAt=new Date(expirytime);
//		Date issuedAt=new Date(millsec);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("Username",user.getUsername());
		map.put("Email",user.getEmailId());
		String s=Jwts.builder().setClaims(map).signWith(SignatureAlgorithm.HS512,secret).compact();
		return s;
//		Claims claims=Jwts.claims()
//				.setIssuer(user.getId().toString())
//				.setIssuedAt(issuedAt).setExpiration(expiredAt);
////		claims.put(k:"username",user.getUsername());
//
//		//generate jwt using claims
//		return Jwts.builder()
//				.setClaims(claims).signWith(SignatureAlgorithn.HS512,secret)
//				.compact();
	}

}
