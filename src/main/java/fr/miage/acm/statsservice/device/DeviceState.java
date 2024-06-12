package fr.miage.acm.statsservice.device;

import lombok.Getter;

@Getter
public enum DeviceState {
    NOT_ASSIGNED("not assigned"),
    OFF("off"),
    ON("on");

    private final String state;

    DeviceState(String state) {
        this.state = state;
    }
}
