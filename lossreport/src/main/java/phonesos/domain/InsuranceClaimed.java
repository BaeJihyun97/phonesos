package phonesos.domain;

import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

@Data
@ToString
public class InsuranceClaimed extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer deviceId;
    private Date createdAt;
    private Integer payout;
    private Object status;
}
