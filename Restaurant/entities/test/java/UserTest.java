import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import com.kpfu.model.users.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by Vlad.M on 13.11.2016.
 */
public class UserTest extends Assert {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = factory.getValidator();
    @AfterClass
    public static void destroy(){
        factory.close();
    }
    @Test
    public void testUserWithNoErrors(){
        User user = new User("testuser","testuser@gmail.com","qwerty");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(0,violations.size());
    }
    @Test
    public void testUserWithEmailError(){
        User user = new User("testuser2","wrongemail","qwerty");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(1,violations.size());
        System.out.println(violations.iterator().next().getMessage());
    }
}
