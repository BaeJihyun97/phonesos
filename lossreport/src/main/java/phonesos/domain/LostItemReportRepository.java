package phonesos.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonesos.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "lostItemReports",
    path = "lostItemReports"
)
public interface LostItemReportRepository
    extends PagingAndSortingRepository<LostItemReport, Long> {}
