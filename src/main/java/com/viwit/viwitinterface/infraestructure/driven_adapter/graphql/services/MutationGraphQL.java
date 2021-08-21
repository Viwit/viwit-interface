package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.GraphQLConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

public class MutationGraphQL {

    public List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>)obj);
        }
        return list;
    }

    public Object sendMutation(String query, String nameQuery){
        JSONObject json = new JSONObject();
        json.put("query",query);
        try {
            //self-signed certificate
            SSLContextBuilder sslContextBuilder = SSLContextBuilder.create();
            sslContextBuilder.loadTrustMaterial(new org.apache.http.conn.ssl.TrustSelfSignedStrategy());
            SSLContext sslContext = sslContextBuilder.build();
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            HttpClientBuilder httpClientBuilder = HttpClients.custom().setSSLSocketFactory(ssf);
            CloseableHttpClient httpClient = httpClientBuilder.build();
            //self-signed certificate
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
