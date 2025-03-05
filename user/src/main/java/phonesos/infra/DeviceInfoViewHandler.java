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
public class DeviceInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DeviceInfoRepository deviceInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceRegistered_then_CREATE_1(
        @Payload DeviceRegistered deviceRegistered
    ) {
        try {
            if (!deviceRegistered.validate()) return;

            // view 객체 생성
            DeviceInfo deviceInfo = new DeviceInfo();
            // view 객체에 이벤트의 Value 를 set 함
            deviceInfo.setId(deviceRegistered.getId());
            deviceInfo.setImei(deviceRegistered.getImei());
            deviceInfo.setUserId(deviceRegistered.getUserId());
            // view 레파지 토리에 save
            deviceInfoRepository.save(deviceInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceDeleted_then_DELETE_1(
        @Payload DeviceDeleted deviceDeleted
    ) {
        try {
            if (!deviceDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            deviceInfoRepository.deleteById(deviceDeleted.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
