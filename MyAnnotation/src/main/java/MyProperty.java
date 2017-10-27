import java.lang.annotation.*;

/**
 * Created by Vlad on 21.10.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface MyProperty {
    String data();
}
