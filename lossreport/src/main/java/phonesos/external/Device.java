package phonesos.external;

import java.util.Date;
import lombok.Data;

@Data
public class Device {

    private Long id;
    private Long userId;
    private String imei;
    private String phoneNumber;
    private Long deviceId;
    private Object status;
}
