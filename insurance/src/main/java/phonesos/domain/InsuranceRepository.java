package phonesos.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonesos.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "insurances",
    path = "insurances"
)
public interface InsuranceRepository
    extends PagingAndSortingRepository<Insurance, Long> {}
