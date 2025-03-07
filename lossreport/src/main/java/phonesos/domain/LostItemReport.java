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

        this.createdAt = new Date();
        this.status = Status.reported;

        // Set the userId and deviceId from the reportCommand
        this.userId = reportCommand.getUserId();
        this.deviceId = reportCommand.getDeviceId();

        // Save the entity or handle any further logic
        repository().save(this);

        // Publish the event
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

    //<<< Clean Arch / Port Method
    public static void changeState(DeviceNotFound deviceNotFound) {
        //implement business logic here:
        repository().findById(deviceNotFound.getId()).ifPresent(lostItemReport->{
            lostItemReport.setStatus(Status.canceled); // do something
            repository().save(lostItemReport);
         });
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeState(InsuranceClaimed insuranceClaimed) {
        //implement business logic here:

        /** Example 1:  new item 
        LostItemReport lostItemReport = new LostItemReport();
        repository().save(lostItemReport);

        */

        /** Example 2:  finding and process
        
        // if insuranceClaimed.insurerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> insuranceMap = mapper.convertValue(insuranceClaimed.getInsurerId(), Map.class);

        repository().findById(insuranceClaimed.get???()).ifPresent(lostItemReport->{
            
            lostItemReport // do something
            repository().save(lostItemReport);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
