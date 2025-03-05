package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phonesos.infra.AbstractEvent;

@Data
public class LostItemResolved extends AbstractEvent {

    private Long id;
    private Long userId;
    private Date createdAt;
    private Status status;
    private Long deviceId;
}
