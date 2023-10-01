package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.requests.CreateBrandRequest;
import com.etiya.rentacar.business.requests.UpdateBrandRequest;
import com.etiya.rentacar.business.responses.GetAllBrandsResponse;
import com.etiya.rentacar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id); //direk id alıp günceller

}
