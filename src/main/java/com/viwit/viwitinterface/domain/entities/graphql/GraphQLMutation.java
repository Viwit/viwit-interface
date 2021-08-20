package com.viwit.viwitinterface.domain.entities.graphql;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class GraphQLMutation {
    private String mutation;
}
