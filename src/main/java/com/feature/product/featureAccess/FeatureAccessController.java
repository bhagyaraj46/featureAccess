package com.feature.product.featureAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feature")
public class FeatureAccessController {
    @Autowired
    FeatureAccessService featureAccessService;




    @PostMapping
    public ResponseEntity newFeatureAccess(@RequestBody  FeatureAccess featureAccess)
    {
        if(Objects.nonNull(featureAccess) && Objects.nonNull(featureAccess.getFeatureName())
                && Objects.nonNull(featureAccess.getEmail()))
            return new ResponseEntity(HttpStatusCode.valueOf(featureAccessService.createNewFeatureAccess(featureAccess)));
        else
         return new ResponseEntity(HttpStatusCode.valueOf(304));
    }

    @GetMapping
    public ResponseEntity<List<FeatureAccessDTO>> getFeatureList(@RequestParam("email")  String email, @RequestParam("feature")  String feature)
    {
        List<FeatureAccessDTO> entities = featureAccessService.getAccess(email,feature);
         return  new ResponseEntity<List<FeatureAccessDTO>>(
               entities.stream().map(FeatureAccessDTO::mapToDto).collect(Collectors.toList()),
               HttpStatusCode.valueOf(200));
    }


}
