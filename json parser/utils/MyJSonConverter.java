package ru.kpfu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.entities.MyObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Vlad.M on 12.09.2016.
 */
public interface MyJSonConverter<T extends MyObject> {
    ObjectMapper mapper = new ObjectMapper();

     T convert(InputStream inputStream) throws IOException;

     String convert(T post) throws JsonProcessingException ;

     List<T> convertToList(InputStream inputStream) throws IOException ;

     String convertToList(List<T> posts) throws JsonProcessingException ;
}
