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
    InsuranceRepository insuranceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostItemLongTermLost'"
    )
    public void wheneverLostItemLongTermLost_InsuranceClaim(
        @Payload LostItemLongTermLost lostItemLongTermLost
    ) {
        LostItemLongTermLost event = lostItemLongTermLost;
        System.out.println(
            "\n\n##### listener InsuranceClaim : " +
            lostItemLongTermLost +
            "\n\n"
        );

        // Comments //
        //장기 분실 기기의 경우 보험 청구 프로세스를 진행한다.

        // Sample Logic //
        Insurance.insuranceClaim(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
