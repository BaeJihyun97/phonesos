package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostItemResolved extends AbstractEvent {

    private Long id;
    private Long userId;
    private Date createdAt;
    private Status status;
    private Long deviceId;

    public LostItemResolved(LostItemReport aggregate) {
        super(aggregate);
    }

    public LostItemResolved() {
        super();
    }
}
//>>> DDD / Domain Event
