package com.etiya.rentacar.dataAccess.concretes.concretes;

import com.etiya.rentacar.business.abstracts.BrandColorService;
import com.etiya.rentacar.business.requests.CreateColorRequest;
import com.etiya.rentacar.business.requests.UpdateColorRequest;
import com.etiya.rentacar.business.responses.GetAllColorResponse;
import com.etiya.rentacar.business.responses.GetByIdColorResponse;
import com.etiya.rentacar.core.utilities.mappers.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.BrandColorRepository;
import com.etiya.rentacar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandColorManager implements BrandColorService {

    private BrandColorRepository brandColorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllColorResponse> getAll() {
        List<Color> colors = brandColorRepository.findAll();

        List<GetAllColorResponse> colorResponse = colors.stream().
                map(color -> this.modelMapperService.forResponse().map(color, GetAllColorResponse.class)).collect(Collectors.toList());
        return colorResponse;
    }

    @Override
    public void add(CreateColorRequest createColorRequest) {
        Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
        this.brandColorRepository.save(color);

    }

    @Override
    public void update(UpdateColorRequest updateColorRequest) {
        Color color = this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
        this.brandColorRepository.save(color);
    }

    @Override
    public void delete(int id) {
        this.brandColorRepository.deleteById(id);

    }

    @Override
    public GetByIdColorResponse getById(int id) {
        Color color = this.brandColorRepository.findById(id).orElseThrow();
        GetByIdColorResponse response = this.modelMapperService.forResponse().map(color, GetByIdColorResponse.class);
        return response;
    }
}
