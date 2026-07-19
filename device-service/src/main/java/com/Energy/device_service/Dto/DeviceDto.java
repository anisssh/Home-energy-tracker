package com.Energy.device_service.Dto;


import com.Energy.device_service.Model.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceDto {
    private Long id;
    private String name;
    private String location;
    private Long userId;
    private DeviceType type;

}
