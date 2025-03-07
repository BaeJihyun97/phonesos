package phonesos.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "LostItemReportPage_table")
@Data
public class LostItemReportPage {

    @Id
    private Long id;

    private Long userId;
    private Long deviceId;
    private Date createdAt;
    private String status;
}
