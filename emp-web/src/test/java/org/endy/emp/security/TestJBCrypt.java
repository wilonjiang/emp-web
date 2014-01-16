package org.endy.emp.security;

import static junit.framework.Assert.*;

import org.junit.Test;

public class TestJBCrypt {
	
	@Test
	public void testEncodeAndDeCode(){
		String salt = BCrypt.gensalt(12);
		String code = BCrypt.hashpw("123456", salt);
		System.out.println(code);
		assertEquals(true, BCrypt.checkpw("123456", code));
	}

}
