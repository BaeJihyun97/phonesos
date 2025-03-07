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
    LostItemReportRepository lostItemReportRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceNotFound'"
    )
    public void wheneverDeviceNotFound_ChangeState(
        @Payload DeviceNotFound deviceNotFound
    ) {
        DeviceNotFound event = deviceNotFound;
        System.out.println(
            "\n\n##### listener ChangeState : " + deviceNotFound + "\n\n"
        );

        // Sample Logic //
        LostItemReport.changeState(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InsuranceClaimed'"
    )
    public void wheneverInsuranceClaimed_ChangeState(
        @Payload InsuranceClaimed insuranceClaimed
    ) {
        InsuranceClaimed event = insuranceClaimed;
        System.out.println(
            "\n\n##### listener ChangeState : " + insuranceClaimed + "\n\n"
        );

        // Sample Logic //
        LostItemReport.changeState(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
