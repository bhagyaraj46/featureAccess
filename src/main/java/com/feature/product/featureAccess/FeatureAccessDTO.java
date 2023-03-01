package com.feature.product.featureAccess;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public  class FeatureAccessDTO {
    @JsonProperty("canAccess")

    private Boolean enable;
     static FeatureAccessDTO mapToDto(FeatureAccessDTO x) {
        return FeatureAccessDTO.builder().enable(x.getEnable()).build();
    }
}