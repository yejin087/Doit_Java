package com.react.reactmyjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.reactmyjwt.model.User;
import com.react.reactmyjwt.payload.request.LoginRequest;
import com.react.reactmyjwt.payload.request.SignupRequest;
import com.react.reactmyjwt.payload.response.JwtResponse;
import com.react.reactmyjwt.payload.response.MessageResponse;
import com.react.reactmyjwt.repository.UserRepository;
import com.react.reactmyjwt.security.jwt.JwtUtils;
import com.react.reactmyjwt.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/*")
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/signup")
	public ResponseEntity registerUser(@RequestBody SignupRequest signupRequest) {

		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("error : user name already taken"));
		}

		if (userRepository.existsByEmail(signupRequest.getEmail())) {

			return ResponseEntity.badRequest().body(new MessageResponse("error : email already taken"));
		}

		User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
				passwordEncoder.encode(signupRequest.getPassword()));
		user.setRole("USER");
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("success register"));
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticationUser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		// jwt 토큰 생성해서 인증된 객체에 추가
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				userDetails.getEmail(), userDetails.getRole()));
	}
}
