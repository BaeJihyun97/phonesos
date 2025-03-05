package phonesos.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phonesos.domain.*;

@Component
public class LostItemReportHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<LostItemReport>> {

    @Override
    public EntityModel<LostItemReport> process(
        EntityModel<LostItemReport> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/report")
                .withRel("report")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/resolve")
                .withRel("resolve")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/markitemfound")
                .withRel("markitemfound")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/marklongtermlost"
                )
                .withRel("marklongtermlost")
        );

        return model;
    }
}
