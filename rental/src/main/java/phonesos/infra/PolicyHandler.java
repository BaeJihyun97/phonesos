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
    DeviceRentalRepository deviceRentalRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostItemReported'"
    )
    public void wheneverLostItemReported_PhoneRent(
        @Payload LostItemReported lostItemReported
    ) {
        LostItemReported event = lostItemReported;
        System.out.println(
            "\n\n##### listener PhoneRent : " + lostItemReported + "\n\n"
        );

        // Comments //
        //대여폰을 대여하는 프로세스로 연결한다.

        // Sample Logic //
        DeviceRental.phoneRent(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
