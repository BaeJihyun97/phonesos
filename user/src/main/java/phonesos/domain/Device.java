package phonesos.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonesos.UserApplication;
import phonesos.domain.DeviceDeleted;
import phonesos.domain.DeviceInfoUpdated;
import phonesos.domain.DeviceNotFound;
import phonesos.domain.DeviceRegistered;
import phonesos.domain.DeviceStateUpdated;

@Entity
@Table(name = "Device_table")
@Data
//<<< DDD / Aggregate Root
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String imei;

    private String phoneNumber;

    private Long deviceId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PostPersist
    public void onPostPersist() {
        DeviceRegistered deviceRegistered = new DeviceRegistered(this);
        deviceRegistered.publishAfterCommit();

        DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(this);
        deviceStateUpdated.publishAfterCommit();

        DeviceDeleted deviceDeleted = new DeviceDeleted(this);
        deviceDeleted.publishAfterCommit();

        DeviceNotFound deviceNotFound = new DeviceNotFound(this);
        deviceNotFound.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        DeviceInfoUpdated deviceInfoUpdated = new DeviceInfoUpdated(this);
        deviceInfoUpdated.publishAfterCommit();
    }

    public static DeviceRepository repository() {
        DeviceRepository deviceRepository = UserApplication.applicationContext.getBean(
            DeviceRepository.class
        );
        return deviceRepository;
    }

    //<<< Clean Arch / Port Method
    public static void deviceStateUpdate(LostItemReported lostItemReported) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
        deviceStateUpdated.publishAfterCommit();
        DeviceNotFound deviceNotFound = new DeviceNotFound(device);
        deviceNotFound.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostItemReported.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
            deviceStateUpdated.publishAfterCommit();
            DeviceNotFound deviceNotFound = new DeviceNotFound(device);
            deviceNotFound.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deviceStateUpdate(LostItemResolved lostItemResolved) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
        deviceStateUpdated.publishAfterCommit();
        DeviceNotFound deviceNotFound = new DeviceNotFound(device);
        deviceNotFound.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostItemResolved.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
            deviceStateUpdated.publishAfterCommit();
            DeviceNotFound deviceNotFound = new DeviceNotFound(device);
            deviceNotFound.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deviceStateUpdate(LostItemFound lostItemFound) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
        deviceStateUpdated.publishAfterCommit();
        DeviceNotFound deviceNotFound = new DeviceNotFound(device);
        deviceNotFound.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostItemFound.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
            deviceStateUpdated.publishAfterCommit();
            DeviceNotFound deviceNotFound = new DeviceNotFound(device);
            deviceNotFound.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deviceStateUpdate(
        LostItemLongTermLost lostItemLongTermLost
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
        deviceStateUpdated.publishAfterCommit();
        DeviceNotFound deviceNotFound = new DeviceNotFound(device);
        deviceNotFound.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostItemLongTermLost.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
            deviceStateUpdated.publishAfterCommit();
            DeviceNotFound deviceNotFound = new DeviceNotFound(device);
            deviceNotFound.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
