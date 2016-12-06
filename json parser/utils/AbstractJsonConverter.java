package ru.kpfu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import ru.kpfu.entities.MyObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Vlad.M on 12.09.2016.
 */
public class AbstractJsonConverter<T extends MyObject> implements MyJSonConverter<T> {
    private final Class<T> type;

    public Class<T> getMyType() {
        return this.type;
    }
    public AbstractJsonConverter(Class<T> typeParameterClass){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        this.type = typeParameterClass;
    }
    public T convert(InputStream inputStream) throws IOException {
        return mapper.readValue(inputStream, getMyType());
    }

    public String convert(T post) throws JsonProcessingException {
        return mapper.writeValueAsString(post);
    }

    public List<T> convertToList(InputStream inputStream) throws IOException {
        return mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(List.class, getMyType()));
    }


    public String convertToList(List<T> posts) throws JsonProcessingException {
        return mapper.writeValueAsString(posts);
    }
}
