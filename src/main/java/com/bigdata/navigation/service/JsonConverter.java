package com.bigdata.navigation.service;

import com.bigdata.navigation.model.JsonNavigationData;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonConverter {
    private ObjectMapper mapper;

    public JsonConverter() {
        mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }


    public String getJson(JsonNavigationData data) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }
}
