package com.etiya.rentacar.business.requests;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBrandRequest {
    private int id;
    private String name;
}
