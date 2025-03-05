package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceDeleted extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String phoneNumber;
    private Long deviceId;
    private Status status;

    public DeviceDeleted(Device aggregate) {
        super(aggregate);
    }

    public DeviceDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
