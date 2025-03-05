package phonesos.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phonesos.config.kafka.KafkaProcessor;
import phonesos.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AlarmRepository alarmRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostItemFound'"
    )
    public void wheneverLostItemFound_LostItemFoundAlarm(
        @Payload LostItemFound lostItemFound
    ) {
        LostItemFound event = lostItemFound;
        System.out.println(
            "\n\n##### listener LostItemFoundAlarm : " + lostItemFound + "\n\n"
        );

        // Sample Logic //
        Alarm.lostItemFoundAlarm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostItemLongTermLost'"
    )
    public void wheneverLostItemLongTermLost_LongTermLostAlarm(
        @Payload LostItemLongTermLost lostItemLongTermLost
    ) {
        LostItemLongTermLost event = lostItemLongTermLost;
        System.out.println(
            "\n\n##### listener LongTermLostAlarm : " +
            lostItemLongTermLost +
            "\n\n"
        );

        // Sample Logic //
        Alarm.longTermLostAlarm(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
