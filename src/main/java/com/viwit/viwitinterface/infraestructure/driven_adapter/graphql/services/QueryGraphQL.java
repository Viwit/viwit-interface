package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.*;

import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.GraphQLConfig;

public class QueryGraphQL {

    public List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>)obj);
        }
        return list;
    }

    public Object sendQueryIndividualResponse(String query, String nameQuery){
        JSONObject json = new JSONObject();
        json.put("query",query);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost(GraphQLConfig.builder().build().getURL_CONNECTION());
            StringEntity params = new StringEntity(json.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse httpResponse = httpClient.execute(request);
            String jsonInput = EntityUtils.toString(httpResponse.getEntity());
            Map<String,Object> result = new ObjectMapper().readValue(jsonInput, HashMap.class);
            LinkedHashMap<String,String> data = (LinkedHashMap)result.get("data");
            LinkedHashMap<String,String> object = (LinkedHashMap<String,String>)((Object) data.get(nameQuery));
            httpClient.close();
            return object;
        } catch (Exception ex) {
            System.out.println("Error sendGet: " + ex);
            return null;
            // handle exception here
        }
    }

}
