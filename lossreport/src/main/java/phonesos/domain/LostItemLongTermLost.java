package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostItemLongTermLost extends AbstractEvent {

    private Long id;
    private Long userId;
    private Date createdAt;
    private Status status;
    private String message;
    private Long deviceId;

    public LostItemLongTermLost(LostItemReport aggregate) {
        super(aggregate);
    }

    public LostItemLongTermLost() {
        super();
    }
}
//>>> DDD / Domain Event
