package phonesos.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonesos.InsuranceApplication;
import phonesos.domain.InsuranceClaimed;

@Entity
@Table(name = "Insurance_table")
@Data
//<<< DDD / Aggregate Root
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer userId;

    private Integer deviceId;

    private Date createdAt;

    private Integer payout;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PostPersist
    public void onPostPersist() {
        InsuranceClaimed insuranceClaimed = new InsuranceClaimed(this);
        insuranceClaimed.publishAfterCommit();
    }

    public static InsuranceRepository repository() {
        InsuranceRepository insuranceRepository = InsuranceApplication.applicationContext.getBean(
            InsuranceRepository.class
        );
        return insuranceRepository;
    }

    //<<< Clean Arch / Port Method
    public static void insuranceClaim(
        LostItemLongTermLost lostItemLongTermLost
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Insurance insurance = new Insurance();
        repository().save(insurance);

        InsuranceClaimed insuranceClaimed = new InsuranceClaimed(insurance);
        insuranceClaimed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostItemLongTermLost.get???()).ifPresent(insurance->{
            
            insurance // do something
            repository().save(insurance);

            InsuranceClaimed insuranceClaimed = new InsuranceClaimed(insurance);
            insuranceClaimed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
