package com.etiya.rentacar.dataAccess.concretes.concretes;
import com.etiya.rentacar.business.abstracts.ModelService;
import com.etiya.rentacar.business.requests.CreateBrandRequest;
import com.etiya.rentacar.business.requests.CreateModelRequest;
import com.etiya.rentacar.business.responses.GetAllBrandsResponse;
import com.etiya.rentacar.business.responses.GetAllModelsResponse;
import com.etiya.rentacar.core.utilities.mappers.ModelMapperManager;
import com.etiya.rentacar.core.utilities.mappers.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.ModelRepository;
import com.etiya.rentacar.entities.concretes.Brand;
import com.etiya.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream() // stream listeyi tek tek dolanmayı sağlar
                .map(model -> this.modelMapperService.forResponse() // her bir brand için mapleme yap
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList()); //mapini kullanarak dönüşüm gerçekleştir, toList tipine çevir dedi burda
// for döngüsü kullanmak yerine 28-30 arasını yazdık.
        //List<GetAllModelsResponse> modelsResponse ;
        return modelsResponse;

    }

    @Override
    public void Add(CreateModelRequest createModelRequest) {

    }

    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class); //neyi neye map edeceğini belirttiğimiz alan parantezin içi
        //arka planda tek tek newleyip idsi eşleşenleri direk veritabanına ekler

        this.modelRepository.save(model);
    }

}
