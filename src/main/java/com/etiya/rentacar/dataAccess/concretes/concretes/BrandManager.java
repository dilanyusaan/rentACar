package com.etiya.rentacar.dataAccess.concretes.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.requests.CreateBrandRequest;
import com.etiya.rentacar.business.requests.UpdateBrandRequest;
import com.etiya.rentacar.business.responses.GetAllBrandsResponse;
import com.etiya.rentacar.business.responses.GetByIdBrandResponse;
import com.etiya.rentacar.business.rules.BrandBusinessRules;
import com.etiya.rentacar.core.utilities.mappers.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService; //modelmapper implementastonu alır
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponse = brands.stream(). // stream listeyi tek tek dolanmayı sağlar
                map(brand -> this.modelMapperService.forResponse(). // her bir brand için mapleme yap
                        map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList()); //mapini kullanarak dönüşüm gerçekleştir, toList tipine çevir dedi burda
// for döngüsü kullanmak yerine 28-30 arasını yazdık.
        return brandsResponse;
    }
// IOC
    //response request patternde objelere dikkat etmek gerekir çünkü sürekli değişebilir, for döngüsü kullanaarak da mapping yapılabilir ama uzun iş
    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class); //neyi neye map edeceğini belirttiğimiz alan parantezin içi
        //arka planda tek tek newleyip idsi eşleşenleri direk veritabanına ekler

        this.brandRepository.save(brand);
    }
    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }
    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow(); // bulamazsan hata fırlat demektir
        // bir brand geldi dönüş tipi getbyidresponse

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;
    }
}
