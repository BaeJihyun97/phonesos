package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ResolveCommand {

    private Long id;
    private Status status;
}
