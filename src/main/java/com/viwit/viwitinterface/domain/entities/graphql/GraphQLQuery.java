package com.viwit.viwitinterface.domain.entities.graphql;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class GraphQLQuery {
    private String query;
}
