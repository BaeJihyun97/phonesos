package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceRegistered extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String phoneNumber;
    private Long deviceId;
    private Status status;
    private Status status;

    public DeviceRegistered(Device aggregate) {
        super(aggregate);
    }

    public DeviceRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
