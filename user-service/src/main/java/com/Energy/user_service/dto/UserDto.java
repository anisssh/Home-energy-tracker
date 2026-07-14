package com.Energy.user_service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDto {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private Boolean alerting;
    private Double energyAlertingThreshold;

}
