package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReportCommand {

    private Long id;
    private Long userId;
    private Status status;
    private Date createdAt;
    private Long deviceId;
}
