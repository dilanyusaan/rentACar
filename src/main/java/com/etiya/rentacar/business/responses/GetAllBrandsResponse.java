package com.etiya.rentacar.business.responses;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllBrandsResponse {
    private int id;
    private String name;
}
