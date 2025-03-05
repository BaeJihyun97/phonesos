package phonesos.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonesos.LossreportApplication;

@Entity
@Table(name = "LostItemReport_table")
@Data
//<<< DDD / Aggregate Root
public class LostItemReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long deviceId;

    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public static LostItemReportRepository repository() {
        LostItemReportRepository lostItemReportRepository = LossreportApplication.applicationContext.getBean(
            LostItemReportRepository.class
        );
        return lostItemReportRepository;
    }

    //<<< Clean Arch / Port Method
    public void report(ReportCommand reportCommand) {
        //implement business logic here:

        LostItemReported lostItemReported = new LostItemReported(this);
        lostItemReported.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void resolve(ResolveCommand resolveCommand) {
        //implement business logic here:

        LostItemResolved lostItemResolved = new LostItemResolved(this);
        lostItemResolved.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void markItemFound(MarkItemFoundCommand markItemFoundCommand) {
        //implement business logic here:

        LostItemFound lostItemFound = new LostItemFound(this);
        lostItemFound.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void markLongTermLost(
        MarkLongTermLostCommand markLongTermLostCommand
    ) {
        //implement business logic here:

        LostItemLongTermLost lostItemLongTermLost = new LostItemLongTermLost(
            this
        );
        lostItemLongTermLost.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
