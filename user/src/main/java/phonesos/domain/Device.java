package phonesos.domain;

import phonesos.domain.DeviceStateUpdated;
import phonesos.domain.DeviceNotFound;
import phonesos.UserApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="Device_table")
@Data

//<<< DDD / Aggregate Root
public class Device  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private Long userId;
    
    
    
    
    private String imei;
    
    
    
    
    private String phoneNumber;
    
    
    
    
    private Long deviceId;
    
    
    
    @Enumerated(EnumType.STRING)
    private Status status;


    public static DeviceRepository repository(){
        DeviceRepository deviceRepository = UserApplication.applicationContext.getBean(DeviceRepository.class);
        return deviceRepository;
    }



//<<< Clean Arch / Port Method
    public void deviceRegister(DeviceRegisterCommand deviceRegisterCommand){
        
        //implement business logic here:
        


        DeviceRegistered deviceRegistered = new DeviceRegistered(this);
        deviceRegistered.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void deviceInfoUpdate(DeviceInfoUpdateCommand deviceInfoUpdateCommand){
        
        //implement business logic here:
        

        phonesos.external.DeviceQuery deviceQuery = new phonesos.external.DeviceQuery();
        // deviceQuery.set??()        
          = DeviceApplication.applicationContext
            .getBean(phonesos.external.Service.class)
            .device(deviceQuery);

        DeviceInfoUpdated deviceInfoUpdated = new DeviceInfoUpdated(this);
        deviceInfoUpdated.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void deviceDelete(){
        
        //implement business logic here:
        

        phonesos.external.DeviceQuery deviceQuery = new phonesos.external.DeviceQuery();
        // deviceQuery.set??()        
          = DeviceApplication.applicationContext
            .getBean(phonesos.external.Service.class)
            .device(deviceQuery);

        DeviceDeleted deviceDeleted = new DeviceDeleted(this);
        deviceDeleted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method

//<<< Clean Arch / Port Method
    public static void deviceStateUpdate(LostItemReported lostItemReported){
        
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
    public static void deviceStateUpdate(LostItemResolved lostItemResolved){
        
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
    public static void deviceStateUpdate(LostItemFound lostItemFound){
        
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
    public static void deviceStateUpdate(LostItemLongTermLost lostItemLongTermLost){
        
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
