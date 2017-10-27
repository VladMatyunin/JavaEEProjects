import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.StaticApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Vlad on 21.10.2017.
 */
@Configuration
@ComponentScan("java")
public class Main implements BeanPostProcessor{
    @Bean
    public DataHolder createDataHolder(){
        return new DataHolder();
    }
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        DataHolder holder = context.getBean(DataHolder.class);
        System.out.print(holder.getData());
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        String input = System.getProperty("myProperty");
        for (Field field: bean.getClass().getFields()){
            Annotation annotation = field.getAnnotation(MyProperty.class);
            if (annotation!=null){
                try {
                    field.set(bean, input);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;

    }
}
