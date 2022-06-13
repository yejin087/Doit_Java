package com.react.reactmyjwt.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.react.reactmyjwt.model.User;

public class UserDetailsImpl implements UserDetails {

	private Long id;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private String role;

	public static UserDetailsImpl build(User user) {
		return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),
				user.getRole());
	}

	public UserDetailsImpl(Long id, String username, String email, String password, String role) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
		collect.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return role;
			}
		});
		return collect;
	}

	@Override
	public String getPassword() {

		return this.password;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public Long getId() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
