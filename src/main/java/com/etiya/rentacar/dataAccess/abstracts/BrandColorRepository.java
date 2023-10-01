package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandColorRepository extends JpaRepository<Color,Integer> {
}
