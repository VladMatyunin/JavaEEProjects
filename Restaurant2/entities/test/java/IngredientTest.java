import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.kpfu.model.ingredient.Ingredient;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by Vlad.M on 13.11.2016.
 */
public class IngredientTest extends Assert{
    private static ValidatorFactory factory;
    private static Validator validator;
    @BeforeClass
    public static void init(){
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @AfterClass
    public static void close(){
        factory.close();
    }
    @Test
    public void testSimpleIngedient(){
        Ingredient testIngredient = new Ingredient("test_ingedint",1.0f,1.0f,"gr");
        Set<ConstraintViolation<Ingredient>> violations =
                validator.validate(testIngredient);
        assertEquals(0,violations.size());
    }
    @Test
    public void testSimpleIngredientWithError(){
        Ingredient ingredient = new Ingredient("",1.1f,1.1f,"g");
        Set<ConstraintViolation<Ingredient>> violations = validator.validate(ingredient);
        assertEquals(1,violations.size());
        System.out.println("test ingredient with error:"+violations.iterator().next().getMessage());
    }
}
