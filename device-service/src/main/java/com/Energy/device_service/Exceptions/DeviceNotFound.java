package com.Energy.device_service.Exceptions;

public class DeviceNotFound extends RuntimeException {
    public DeviceNotFound(String message) {
        super(message);
    }
}
