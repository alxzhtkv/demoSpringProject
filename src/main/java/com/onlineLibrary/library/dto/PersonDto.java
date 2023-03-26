package com.onlineLibrary.library.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {
    private Integer id;
    private Integer loginID;
    private String password;
    private String role;
}
