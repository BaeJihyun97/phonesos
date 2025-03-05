package phonesos.domain;

import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

@Data
@ToString
public class LostItemFound extends AbstractEvent {

    private Long id;
    private Long userId;
    private Date createdAt;
    private Object status;
    private String message;
    private Long deviceId;
}
