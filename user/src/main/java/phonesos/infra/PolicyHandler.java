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
import phonesos.external.LostItemReported;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostItemReported'"
    )
    public void wheneverLostItemReported_DeviceStateUpdate(
        @Payload LostItemReported lostItemReported
    ) {
        LostItemReported event = lostItemReported;
        System.out.println(
            "\n\n##### listener DeviceStateUpdate : " +
            lostItemReported +
            "\n\n"
        );

        // Sample Logic //
        Device.deviceStateUpdate(event);
    }

    // @StreamListener(
    //     value = KafkaProcessor.INPUT,
    //     condition = "headers['type']=='LostItemResolved'"
    // )
    // public void wheneverLostItemResolved_DeviceStateUpdate(
    //     @Payload LostItemResolved lostItemResolved
    // ) {
    //     LostItemResolved event = lostItemResolved;
    //     System.out.println(
    //         "\n\n##### listener DeviceStateUpdate : " +
    //         lostItemResolved +
    //         "\n\n"
    //     );

    //     // Sample Logic //
    //     Device.deviceStateUpdate(event);
    // }

    // @StreamListener(
    //     value = KafkaProcessor.INPUT,
    //     condition = "headers['type']=='LostItemFound'"
    // )
    // public void wheneverLostItemFound_DeviceStateUpdate(
    //     @Payload LostItemFound lostItemFound
    // ) {
    //     LostItemFound event = lostItemFound;
    //     System.out.println(
    //         "\n\n##### listener DeviceStateUpdate : " + lostItemFound + "\n\n"
    //     );

    //     // Sample Logic //
    //     Device.deviceStateUpdate(event);
    // }

    // @StreamListener(
    //     value = KafkaProcessor.INPUT,
    //     condition = "headers['type']=='LostItemLongTermLost'"
    // )
    // public void wheneverLostItemLongTermLost_DeviceStateUpdate(
    //     @Payload LostItemLongTermLost lostItemLongTermLost
    // ) {
    //     LostItemLongTermLost event = lostItemLongTermLost;
    //     System.out.println(
    //         "\n\n##### listener DeviceStateUpdate : " +
    //         lostItemLongTermLost +
    //         "\n\n"
    //     );

    //     // Sample Logic //
    //     Device.deviceStateUpdate(event);
    // }
}
//>>> Clean Arch / Inbound Adaptor
