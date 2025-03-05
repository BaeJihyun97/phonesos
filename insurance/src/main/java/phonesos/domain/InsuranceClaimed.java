package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InsuranceClaimed extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer deviceId;
    private Date createdAt;
    private Integer payout;
    private Status status;

    public InsuranceClaimed(Insurance aggregate) {
        super(aggregate);
    }

    public InsuranceClaimed() {
        super();
    }
}
//>>> DDD / Domain Event
