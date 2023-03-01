package com.feature.product.featureAccess;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table
@Setter
@Getter
public class FeatureAccess {
    public FeatureAccess() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String featureName;

    private String email;

    private Boolean enable = false;

    public FeatureAccess(String featureName, String email, Boolean enable) {
        this.featureName = featureName;
        this.email = email;
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "FeatureAccess{" +
                "id=" + id +
                ", featureName='" + featureName + '\'' +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                '}';
    }
}
