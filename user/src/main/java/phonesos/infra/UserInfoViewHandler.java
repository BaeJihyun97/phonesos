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
public class UserInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private UserInfoRepository userInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegistered_then_CREATE_1(@Payload Registered registered) {
        try {
            if (!registered.validate()) return;

            // view 객체 생성
            UserInfo userInfo = new UserInfo();
            // view 객체에 이벤트의 Value 를 set 함
            userInfo.setId(registered.getId());
            userInfo.setEmail(String.valueOf(registered.getEmail()));
            userInfo.setResidentNumber(registered.getResidentNumber());
            // view 레파지 토리에 save
            userInfoRepository.save(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
