package phonesos.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonesos.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "deviceRentals",
    path = "deviceRentals"
)
public interface DeviceRentalRepository
    extends PagingAndSortingRepository<DeviceRental, Long> {}
