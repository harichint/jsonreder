package com.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
/**
 * Class to serialize and deserialize Json .
 */
public class JsonUtil {
    private static final ObjectMapper om = new ObjectMapper();

    /**
     *  Returns a List of Objects
     */
    public static <T> List<T> deserializeToPojo(String jsonValue) throws IOException, JsonProcessingException {
        List<T> listOfObjects = new ArrayList<>();
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        JsonParser parser = om.getFactory().createParser(jsonValue);
        listOfObjects = om.readValue(jsonValue, new TypeReference<List<T>>(){});

        return listOfObjects;
    }

    /**
     * TODO Returns a Map of key Object pairs
     */
    /**
     * TODO Load Deserialization Configurations
     */
    /**
     * TODO Load Serialization Configurations
     */
}
