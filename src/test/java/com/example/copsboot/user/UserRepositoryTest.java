package com.example.copsboot.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

;import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

  //  @Test
    public void testStoreUser() {
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        //User user = userRepository.save(new User(UUID.randomUUID(), "straore@me.com", "mysecret", roles));
      //  assertThat(user).isNotNull();
        assertThat(userRepository.count()).isEqualTo(1L);
    }

    @Test
    public void testFindByEmail() {
        User user = Users.newRandomOfficer();
        userRepository.save(user);
        Optional<User> optional = userRepository.findByEmailIgnoreCase(user.getEmail());
        assertThat(optional).isNotEmpty().contains(user);
    }

    @Test
    public void testFindByEmailIgnoringCase() {
        User user = Users.newRandomOfficer();
        userRepository.save(user);
        Optional<User> optional = userRepository.findByEmailIgnoreCase(user.getEmail().toUpperCase(Locale.US));
        assertThat(optional).isNotEmpty().contains(user);
    }

    @Test
    public void testFindByEmail_unknownEmail() {
        User user = Users.newRandomOfficer();
        userRepository.save(user);
        Optional<User> optional = userRepository.findByEmailIgnoreCase("will.not@find.me");
        assertThat(optional).isEmpty();
    }
}