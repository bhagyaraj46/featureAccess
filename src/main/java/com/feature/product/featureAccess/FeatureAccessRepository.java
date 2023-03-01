package com.feature.product.featureAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureAccessRepository
        extends JpaRepository<FeatureAccess,Long> {

    List<FeatureAccessDTO> findByEmailAndFeatureName(String email, String featureName);
}
