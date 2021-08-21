package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class GraphQLConfig {
    //INVERSE_PROXY
    public final String URL_CONNECTION = "https://54.237.94.101:8000/graphql";

//     API_GATEWAY
//     public final String URL_CONNECTION = "http://54.174.205.83:3000/graphql";
}
