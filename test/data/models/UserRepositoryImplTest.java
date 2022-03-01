package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository customer;
    @BeforeEach
    public void setUp(){
        customer=new UserRepositoryImpl();

        }
        @Test
        public void UserSavesTest(){
        //given
        User aUser=new User("deolaoladeji@gmail.com");

        //when i try to save the save;
//            aUser.setEmail("deolaoladeji@gmail.com");
        User savedUser=customer.save(aUser);
        //assert that the return, has an email;
            assertEquals("deolaoladeji@gmail.com",savedUser.getEmail());
            //assert that the count is 1;
            assertEquals(1,customer.count());

    }
    @Test
    void UserSaveTest(){
        //given
        User firstUser = new User("deolaoladeji@gmail.com");
        User secondUser = new User("ted@gmail.com");
        User ThirdUser = new User("rate34@gmail.com");
        //when
        customer.save(firstUser);
        customer.save(secondUser);
        customer.save(ThirdUser);
        //assert

        User foundUser= customer.findByEmail("ted@gmail.com");
      assertEquals(secondUser,foundUser);
        assertEquals("ted@gmail.com",foundUser.getEmail());


    }
    @Test
    void deleteUserByEmailTest(){
        //given
        User firstUser = new User("deolaoladeji@gmail.com");
        User secondUser = new User("ted@gmail.com");
        User ThirdUser = new User("rate34@gmail.com");
        //when
        customer.save(firstUser);
        customer.save(secondUser);
        customer.save(ThirdUser);
        //assert
        customer.delete("ted@gmail.com");
        assertEquals(2,customer.count());
    }

    private void saveThreeUsers(){
        //given
        User firstUser = new User("deolaoladeji@gmail.com");
        User secondUser = new User("ted@gmail.com");
        User ThirdUser = new User("rate34@gmail.com");
        //when
        customer.save(firstUser);
        customer.save(secondUser);
        customer.save(ThirdUser);
    }
    @Test
    void findByIdWorks_AfterDeleteByUser(){
        saveThreeUsers();
        customer.delete("ted@gmail.com");

        User foundUser= customer.findByEmail("ted@gmail.com");
        assertNull(foundUser);

    }
    @Test
    void saveNewEmailAfterADelete_givesCorrectPackageIdTest(){
        //given
        saveThreeUsers();
        customer.delete("del@gmail.com");
        User savedUser=customer.save(new User("del@gmail.com"));
        assertEquals("del@gmail.com",savedUser.getEmail());
    }
    @Test
    void deleteByUserTest(){
        //given
        User firstUser = new User("deolaoladeji@gmail.com");
        User secondUser = new User("ted@gmail.com");
        User ThirdUser = new User("rate34@gmail.com");

        customer.save(firstUser);
        customer.save(secondUser);
        customer.save(ThirdUser);

        customer.delete(ThirdUser);
        assertEquals(2,customer.count());
        assertNull(customer.findByEmail("rate34@gmail.com"));

    }
    @Test
    void findAllTest(){
        saveThreeUsers();
        List<User> all =customer.findAll();
        assertEquals(3,all.size());
    }



}