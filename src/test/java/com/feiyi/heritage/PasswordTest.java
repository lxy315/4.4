package com.feiyi.heritage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PasswordTest {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Test
    void testPasswordEncoder() {
        String rawPassword = "123456";
        String encoded = passwordEncoder.encode(rawPassword);
        System.out.println("加密结果: " + encoded);
        assertTrue(passwordEncoder.matches(rawPassword, encoded));
    }
} 