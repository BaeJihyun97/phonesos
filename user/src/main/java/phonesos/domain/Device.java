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
import phonesos.external.LostItemReported;

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

    @Enumerated(EnumType.STRING)
    private Status status;


    public static DeviceRepository repository() {
        DeviceRepository deviceRepository = UserApplication.applicationContext.getBean(
            DeviceRepository.class
        );
        return deviceRepository;
    }


//<<< Clean Arch / Port Method
    public void deviceRegister(DeviceRegisterCommand deviceRegisterCommand){
        
        //implement business logic here:
        this.userId = deviceRegisterCommand.getUserId();
        this.imei = deviceRegisterCommand.getImei();
        this.phoneNumber = deviceRegisterCommand.getPhoneNumber();
        this.status = deviceRegisterCommand.getStatus();

        repository().save(this);

        DeviceRegistered deviceRegistered = new DeviceRegistered(this);
        deviceRegistered.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void deviceInfoUpdate(DeviceInfoUpdateCommand deviceInfoUpdateCommand){
        
        //implement business logic here:
        repository()
            .findById(deviceInfoUpdateCommand.getId())
            .ifPresent(device -> {
                if (deviceInfoUpdateCommand.getUserId() != null) {
                    device.setUserId(deviceInfoUpdateCommand.getUserId());
                }
                if (deviceInfoUpdateCommand.getImei() != null) {
                    device.setImei(deviceInfoUpdateCommand.getImei());
                }
                if (deviceInfoUpdateCommand.getPhoneNumber() != null) {
                    device.setPhoneNumber(deviceInfoUpdateCommand.getPhoneNumber());
                }
                if (deviceInfoUpdateCommand.getStatus() != null) {
                    device.setStatus(deviceInfoUpdateCommand.getStatus());
                }

                DeviceInfoUpdated deviceInfoUpdated = new DeviceInfoUpdated(this);
                deviceInfoUpdated.publishAfterCommit();
            });
        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void deviceDelete(){
        
        //implement business logic here:
        repository()
            .findById(this.id)
            .ifPresent(device ->{
                device.setStatus(Status.deleted);

                DeviceDeleted deviceDeleted = new DeviceDeleted(this);
                deviceDeleted.publishAfterCommit();
            });

    }
//>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void deviceStateUpdate(LostItemReported lostItemReported) {
        //implement business logic here:
        repository()
        .findById(Long.valueOf(lostItemReported.getDeviceId()))
        .ifPresentOrElse(device->{
            
            device.setStatus(Status.deactivated);
            repository().save(device);

            DeviceStateUpdated deviceStateUpdated = new DeviceStateUpdated(device);
            deviceStateUpdated.publishAfterCommit();
            System.out.println("\n\ndevice state updated after lostItemReported\n\n");
         },  () -> {
            DeviceNotFound deviceNotFound = new DeviceNotFound();
            deviceNotFound.setId(lostItemReported.getId());
            deviceNotFound.setUserId(lostItemReported.getUserId());
            deviceNotFound.setDeviceId(lostItemReported.getDeviceId());
            deviceNotFound.publishAfterCommit();
            System.out.println("\n\ndevice Not found\n\n");
         });

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
