package phonesos.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonesos.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "lostItemReportPages",
    path = "lostItemReportPages"
)
public interface LostItemReportPageRepository
    extends PagingAndSortingRepository<LostItemReportPage, Long> {}
