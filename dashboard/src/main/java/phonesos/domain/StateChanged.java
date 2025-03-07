package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phonesos.infra.AbstractEvent;

@Data
public class StateChanged extends AbstractEvent {

    private Long id;
    private Status status;
}
