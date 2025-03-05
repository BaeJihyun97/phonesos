package phonesos.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phonesos.config.kafka.KafkaProcessor;
import phonesos.domain.*;

@Service
public class LostItemReportPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private LostItemReportPageRepository lostItemReportPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostItemReported_then_CREATE_1(
        @Payload LostItemReported lostItemReported
    ) {
        try {
            if (!lostItemReported.validate()) return;

            // view 객체 생성
            LostItemReportPage lostItemReportPage = new LostItemReportPage();
            // view 객체에 이벤트의 Value 를 set 함
            lostItemReportPage.setId(lostItemReported.getId());
            lostItemReportPage.setUserId(lostItemReported.getUserId());
            lostItemReportPage.setDeviceId(lostItemReported.getDeviceId());
            lostItemReportPage.setCreatedAt(lostItemReported.getCreatedAt());
            lostItemReportPage.setStatus(
                String.valueOf(lostItemReported.getStatus())
            );
            lostItemReportPage.set();
            // view 레파지 토리에 save
            lostItemReportPageRepository.save(lostItemReportPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostItemResolved_then_UPDATE_1(
        @Payload LostItemResolved lostItemResolved
    ) {
        try {
            if (!lostItemResolved.validate()) return;
            // view 객체 조회
            Optional<LostItemReportPage> lostItemReportPageOptional = lostItemReportPageRepository.findById(
                lostItemResolved.getId()
            );

            if (lostItemReportPageOptional.isPresent()) {
                LostItemReportPage lostItemReportPage = lostItemReportPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostItemReportPage.setStatus(
                    String.valueOf(lostItemResolved.getStatus())
                );
                // view 레파지 토리에 save
                lostItemReportPageRepository.save(lostItemReportPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostItemFound_then_UPDATE_2(
        @Payload LostItemFound lostItemFound
    ) {
        try {
            if (!lostItemFound.validate()) return;
            // view 객체 조회
            Optional<LostItemReportPage> lostItemReportPageOptional = lostItemReportPageRepository.findById(
                lostItemFound.getId()
            );

            if (lostItemReportPageOptional.isPresent()) {
                LostItemReportPage lostItemReportPage = lostItemReportPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostItemReportPage.setStatus(
                    String.valueOf(lostItemFound.getStatus())
                );
                // view 레파지 토리에 save
                lostItemReportPageRepository.save(lostItemReportPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostItemLongTermLost_then_UPDATE_3(
        @Payload LostItemLongTermLost lostItemLongTermLost
    ) {
        try {
            if (!lostItemLongTermLost.validate()) return;
            // view 객체 조회
            Optional<LostItemReportPage> lostItemReportPageOptional = lostItemReportPageRepository.findById(
                lostItemLongTermLost.getId()
            );

            if (lostItemReportPageOptional.isPresent()) {
                LostItemReportPage lostItemReportPage = lostItemReportPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostItemReportPage.setStatus(
                    String.valueOf(lostItemLongTermLost.getStatus())
                );
                // view 레파지 토리에 save
                lostItemReportPageRepository.save(lostItemReportPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostItemFound_then_UPDATE_4(
        @Payload LostItemFound lostItemFound
    ) {
        try {
            if (!lostItemFound.validate()) return;
            // view 객체 조회
            Optional<LostItemReportPage> lostItemReportPageOptional = lostItemReportPageRepository.findById(
                lostItemFound.getId()
            );

            if (lostItemReportPageOptional.isPresent()) {
                LostItemReportPage lostItemReportPage = lostItemReportPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostItemReportPage.setStatus(
                    String.valueOf(lostItemFound.getStatus())
                );
                // view 레파지 토리에 save
                lostItemReportPageRepository.save(lostItemReportPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostItemLongTermLost_then_UPDATE_5(
        @Payload LostItemLongTermLost lostItemLongTermLost
    ) {
        try {
            if (!lostItemLongTermLost.validate()) return;
            // view 객체 조회
            Optional<LostItemReportPage> lostItemReportPageOptional = lostItemReportPageRepository.findById(
                lostItemLongTermLost.getId()
            );

            if (lostItemReportPageOptional.isPresent()) {
                LostItemReportPage lostItemReportPage = lostItemReportPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostItemReportPage.setStatus(
                    String.valueOf(lostItemLongTermLost.getStatus())
                );
                // view 레파지 토리에 save
                lostItemReportPageRepository.save(lostItemReportPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
