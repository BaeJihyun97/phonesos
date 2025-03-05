package phonesos.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonesos.RentalApplication;
import phonesos.domain.PhoneRented;
import phonesos.domain.PhoneReturned;

@Entity
@Table(name = "DeviceRental_table")
@Data
//<<< DDD / Aggregate Root
public class DeviceRental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long rentalDeviceId;

    private Date startDate;

    private Date dueDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PostPersist
    public void onPostPersist() {
        PhoneRented phoneRented = new PhoneRented(this);
        phoneRented.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        PhoneReturned phoneReturned = new PhoneReturned(this);
        phoneReturned.publishAfterCommit();
    }

    public static DeviceRentalRepository repository() {
        DeviceRentalRepository deviceRentalRepository = RentalApplication.applicationContext.getBean(
            DeviceRentalRepository.class
        );
        return deviceRentalRepository;
    }

    //<<< Clean Arch / Port Method
    public static void phoneRent(LostItemReported lostItemReported) {
        //implement business logic here:

        /** Example 1:  new item 
        DeviceRental deviceRental = new DeviceRental();
        repository().save(deviceRental);

        PhoneRented phoneRented = new PhoneRented(deviceRental);
        phoneRented.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostItemReported.get???()).ifPresent(deviceRental->{
            
            deviceRental // do something
            repository().save(deviceRental);

            PhoneRented phoneRented = new PhoneRented(deviceRental);
            phoneRented.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
