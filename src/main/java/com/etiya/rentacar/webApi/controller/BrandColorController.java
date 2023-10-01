package com.etiya.rentacar.webApi.controller;

import com.etiya.rentacar.business.abstracts.BrandColorService;
import com.etiya.rentacar.business.requests.CreateColorRequest;
import com.etiya.rentacar.business.requests.UpdateColorRequest;
import com.etiya.rentacar.business.responses.GetAllColorResponse;
import com.etiya.rentacar.business.responses.GetByIdColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
@AllArgsConstructor
public class BrandColorController {
    private BrandColorService brandColorService;

    @GetMapping
    public List<GetAllColorResponse> getAll() {
        return brandColorService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdColorResponse getById(@PathVariable int id) {
        return brandColorService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateColorRequest createColorRequest) {
        this.brandColorService.add(createColorRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateColorRequest updateColorRequest) {
        this.brandColorService.update(updateColorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandColorService.delete(id);
    }

}
