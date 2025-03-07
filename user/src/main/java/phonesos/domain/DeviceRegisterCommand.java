package phonesos.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeviceRegisterCommand {

    private Long userId;
    private String imei;
    private String phoneNumber;
    private Status status;
}