package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneRented extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long rentalDeviceId;
    private Date startDate;
    private Date dueDate;
    private Status status;

    public PhoneRented(DeviceRental aggregate) {
        super(aggregate);
    }

    public PhoneRented() {
        super();
    }
}
//>>> DDD / Domain Event
