package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName (String name); //jpa bizim için özel keywordler sunuyor varsa true yoksa false döndürüyor findByname de olabilir
    //spring jpa keywords

}
