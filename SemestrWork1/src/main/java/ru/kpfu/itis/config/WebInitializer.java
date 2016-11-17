package ru.kpfu.itis.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebInitializer extends AbstractDispatcherServletInitializer {

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
    cxt.register(RootConfig.class);
    cxt.register(SecurityConfig.class);
    return cxt;
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
    cxt.register(WebConfig.class);
    cxt.register(SecurityConfig.class);
    return cxt;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

  @Override
  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    registration.setMultipartConfig(getMultipartConfigElement());
  }

  private MultipartConfigElement getMultipartConfigElement() {
    MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
    return multipartConfigElement;
  }

  private static final String LOCATION = "C:\\Users\\Vlad.M\\Desktop\\TESTPIC"; // Temporary location where files will be stored

  private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
  // Beyond that size spring will throw exception.
  private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.

  private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk
}
