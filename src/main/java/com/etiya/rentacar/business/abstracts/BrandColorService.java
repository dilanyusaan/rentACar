package com.etiya.rentacar.business.abstracts;
import com.etiya.rentacar.business.requests.CreateColorRequest;
import com.etiya.rentacar.business.requests.UpdateColorRequest;
import com.etiya.rentacar.business.responses.GetAllColorResponse;
import com.etiya.rentacar.business.responses.GetByIdColorResponse;
import java.util.List;

public interface BrandColorService {
    List<GetAllColorResponse> getAll();

    void add(CreateColorRequest createColorRequest);

    void update(UpdateColorRequest updateColorRequest);

    void delete(int id);

    GetByIdColorResponse getById(int id);

}
