package phonesos.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phonesos.AlarmApplication;

@Entity
@Table(name = "Alarm_table")
@Data
//<<< DDD / Aggregate Root
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Date createdAt;

    private String message;

    public static AlarmRepository repository() {
        AlarmRepository alarmRepository = AlarmApplication.applicationContext.getBean(
            AlarmRepository.class
        );
        return alarmRepository;
    }

    //<<< Clean Arch / Port Method
    public static void lostItemFoundAlarm(LostItemFound lostItemFound) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(lostItemFound.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void longTermLostAlarm(
        LostItemLongTermLost lostItemLongTermLost
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        

        repository().findById(lostItemLongTermLost.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
