package com.insat.demo;
import com.insat.demo.entity.Personality;
import com.insat.demo.repositories.PersonalityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonalityRepoTest {

    @Autowired
    private PersonalityRepository personalityRepository;

    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePersonalityTest() {

        Personality personality = Personality.builder()
                .firstname("Ramesh")
                .lastname("Fadatare")
                .nation("FR")
                .build();

        personalityRepository.save(personality);

        Assertions.assertThat( personality.getId()).isGreaterThan( 0);
    }
    @Test
    @Order(2)
    @Rollback(value = false)
    public void updatePersonalityTest(){

        Personality personality = personalityRepository.findById(1L).get();

        personality.setFirstname("Ramesh");

        Personality personalityUpdated =  personalityRepository.save(personality);

        Assertions.assertThat(personalityUpdated.getFirstname()).isEqualTo("Ramesh");

    }
}
