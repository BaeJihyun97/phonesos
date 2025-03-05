package phonesos.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phonesos.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/devices")
@Transactional
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping(
        value = "/devices/{id}/deviceinfoupdate",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Device deviceInfoUpdate(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /device/deviceInfoUpdate  called #####");
        Optional<Device> optionalDevice = deviceRepository.findById(id);

        optionalDevice.orElseThrow(() -> new Exception("No Entity Found"));
        Device device = optionalDevice.get();
        device.deviceInfoUpdate();

        deviceRepository.save(device);
        return device;
    }
}
//>>> Clean Arch / Inbound Adaptor
