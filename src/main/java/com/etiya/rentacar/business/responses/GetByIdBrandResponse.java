package com.etiya.rentacar.business.responses;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetByIdBrandResponse {
    private int id;
    private String name;
}
