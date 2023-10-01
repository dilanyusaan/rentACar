package com.etiya.rentacar.webApi.controller;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.requests.CreateBrandRequest;
import com.etiya.rentacar.business.requests.UpdateBrandRequest;
import com.etiya.rentacar.business.responses.GetAllBrandsResponse;
import com.etiya.rentacar.business.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;


    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){

        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){

        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest){

        this.brandService.add(createBrandRequest);
    }

    @PutMapping() //güncelleme
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){

        this.brandService.delete(id);
    }
}
// post eklemek için
//get data çekmek için kullanılır
//post güncelleme yapar
//softdelete veri silmek istersek tamam silmek değil de silmiş gibi yapıp güncellemekte kullanılır