package phonesos.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phonesos.domain.*;

@Component
public class DeviceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Device>> {

    @Override
    public EntityModel<Device> process(EntityModel<Device> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deviceregister")
                .withRel("deviceregister")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/deviceinfoupdate"
                )
                .withRel("deviceinfoupdate")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/devicedelete")
                .withRel("devicedelete")
        );

        return model;
    }
}