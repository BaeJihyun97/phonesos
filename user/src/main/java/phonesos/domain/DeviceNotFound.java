package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceNotFound extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long deviceId;

    public DeviceNotFound(Device aggregate) {
        super(aggregate);
    }

    public DeviceNotFound() {
        super();
    }
}
//>>> DDD / Domain Event
