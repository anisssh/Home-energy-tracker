package com.Energy.device_service.Service;

import com.Energy.device_service.Dto.DeviceDto;
import com.Energy.device_service.Entity.Device;
import com.Energy.device_service.Repository.DeviceRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeviceService
{
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    public DeviceDto getDeviceById(Long id){
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("device not found" +id));
        return mapToDto(device);
    }

    private DeviceDto mapToDto(Device device){
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId(device.getId());
        deviceDto.setName(device.getName());
        deviceDto.setLocation(device.getLocation());
        deviceDto.setType(device.getType());
        deviceDto.setUserId(device.getUserId());
        return deviceDto;
    }

    public DeviceDto createDevice(DeviceDto deviceDto){
        Device device = new Device();
        device.setName(deviceDto.getName());
        device.setLocation(deviceDto.getLocation());
        device.setType(deviceDto.getType());
        device.setUserId(deviceDto.getUserId());

        Device savedDevice = deviceRepository.save(device);
        return mapToDto(savedDevice);
    }
    public DeviceDto updateDevice(Long id, DeviceDto input) {
        Device existing = deviceRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Device not found with id " + id));

        existing.setName(input.getName());
        existing.setType(input.getType());
        existing.setLocation(input.getLocation());
        existing.setUserId(input.getUserId());

        final Device updatedDevice = deviceRepository.save(existing);
        return mapToDto(updatedDevice);
    }

}
