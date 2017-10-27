import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Vlad on 21.10.2017.
 */
public class DataHolder {
    @MyProperty(data = "test")
    public String data;

    public String getData(){
        return data;
    }
}
