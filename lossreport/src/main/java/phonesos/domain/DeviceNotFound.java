package phonesos.domain;

import java.util.*;
import lombok.*;
import phonesos.domain.*;
import phonesos.infra.AbstractEvent;

@Data
@ToString
public class DeviceNotFound extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long deviceId;
}
