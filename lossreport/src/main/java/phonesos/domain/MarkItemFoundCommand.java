package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class MarkItemFoundCommand {

    private Long id;
    private Status status;
}
