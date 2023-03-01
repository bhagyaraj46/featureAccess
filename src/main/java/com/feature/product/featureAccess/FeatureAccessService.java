package com.feature.product.featureAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureAccessService {

    @Autowired
    FeatureAccessRepository featureAccessRepository;
    public List<FeatureAccess> getFeatureAccess(String email, String feature){
        return featureAccessRepository.findAll();
    }
    public int createNewFeatureAccess(FeatureAccess featureAccess) {

        try
        {
            if(featureAccessRepository.findByEmailAndFeatureName(featureAccess.getEmail(),
                    featureAccess.getFeatureName()).isEmpty()) {
                featureAccessRepository.save(featureAccess);
                return 200;
            }
            return 304;
        }
        catch(Exception e)
        {
            throw new IllegalStateException();
        }
    }


    public List<FeatureAccessDTO> getAccess(String email , String featureName) {
        return featureAccessRepository.findByEmailAndFeatureName(email,featureName);
    }
}
