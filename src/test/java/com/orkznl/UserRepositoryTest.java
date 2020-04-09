package com.orkznl;

import com.orkznl.model.User;
import com.orkznl.repository.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    @Ignore
    public void testFindByName() {

        entityManager.persist(new User("Harrie", "harrie1!", "harrie@harrie.nl"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(System.out::println);

        //assertEquals(1, users.size());

        //assertThat(users).extracting(User::getUsername).containsOnly("Harrie");

    }

}
