package com.builder.test1;

import org.junit.Test;

public class UserBuilderTest1 {
	@Test
	public void builderTest1() {

		User user = User.builder().name("hong").age(123).build();
		System.out.println(user);
	}
}
