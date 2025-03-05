package phonesos.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phonesos.domain.*;

@Component
public class DeviceRentalHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DeviceRental>> {

    @Override
    public EntityModel<DeviceRental> process(EntityModel<DeviceRental> model) {
        return model;
    }
}
