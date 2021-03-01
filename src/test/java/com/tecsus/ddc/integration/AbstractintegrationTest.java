package com.tecsus.ddc.integration;

import com.google.gson.Gson;
import net.minidev.json.JSONValue;
import org.springframework.test.web.servlet.MvcResult;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class AbstractintegrationTest<T> {

    protected String listAsJson(List<T> list) {
        return new Gson().toJson(list);
    }

    protected String objectAsJson(T obj) {
        return new Gson().toJson(obj);
    }

    protected String jsonAsString(final String path) throws UnsupportedEncodingException {
        var reader = new InputStreamReader(getClass().getResourceAsStream(String.format("/com/tecsus/ddc/jsons/%s", path)), StandardCharsets.UTF_8);
        return JSONValue.parse(reader).toString();
    }

    protected String getJsonResult(MvcResult result) throws UnsupportedEncodingException {
        return result.getResponse().getContentAsString();
    }
}
