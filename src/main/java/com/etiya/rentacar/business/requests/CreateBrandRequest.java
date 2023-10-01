package com.etiya.rentacar.business.requests;

import lombok.*;
// apiyi kullanan son kullanıcıdan data alıyosak request ona bir yanıt veriyorsan response
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBrandRequest {
    private String name;
    //id zaten otomatik arttığı için sadece name aldık
}
