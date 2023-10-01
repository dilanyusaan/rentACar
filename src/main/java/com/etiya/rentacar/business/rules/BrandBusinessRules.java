package com.etiya.rentacar.business.rules;


import com.etiya.rentacar.core.utilities.exceptions.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){ //marka isimleri tekrar ediyor mu?
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand already exists");
            //java exception types
        }
    }
}