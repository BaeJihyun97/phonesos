package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceInfoUpdated extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String phoneNumber;
    private Long deviceId;
    private Status status;
    private Status status;

    public DeviceInfoUpdated(Device aggregate) {
        super(aggregate);
    }

    public DeviceInfoUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
