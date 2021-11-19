package com.mighty.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class UserRegMockitoTest {
	
	@InjectMocks
	private UserReg reg;
	
	@Mock
	private TestEntityManager entityManager;
	
	 @BeforeEach
	    public void init() {
	        MockitoAnnotations.openMocks(this);
	    }
	 
	 @Test
		public void testCreateUser() {
			User user = new User();
			user.setFirstName("dhiviya");
			user.setLastName("Bharathy");
			user.setUsername("divi");
			user.setPassword("vdb");
			
			User savedUser = reg.save(user);
			
			User existUser = entityManager.find(User.class, savedUser.getId());
			
			assertThat(existUser.getUsername()).isEqualTo(user.getUsername());
		}

}
