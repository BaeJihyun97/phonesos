package phonesos.external;

import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

@Data
@ToString
public class LostItemReported extends AbstractEvent {

    private Long id;
    private Long userId;
    private Date createdAt;
    private LIRStatus status;
    private Long deviceId;
}
