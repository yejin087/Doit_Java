package com.builder.test;

import org.junit.Test;

public class UserBuilderTest {
	@Test
	public void builderTest() {
		User user = User.builder().name("hong").age(12).build();
	}
}
