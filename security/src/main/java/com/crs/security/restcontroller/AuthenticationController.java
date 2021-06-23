package com.crs.security.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crs.security.app.dto.JWTResponse;
import com.crs.security.app.dto.JwtRequest;
import com.crs.security.jwt.utility.JWTUtility;
import com.crs.security.service.UserService;

@RestController
public class AuthenticationController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public JWTResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final String token = jwtUtility.generateToken(userService.loadUserByUsername(jwtRequest.getUsername()));

		return new JWTResponse(token);
	}
	
	@GetMapping
	public String testMethod() {
		return "Its working";
	}

}
