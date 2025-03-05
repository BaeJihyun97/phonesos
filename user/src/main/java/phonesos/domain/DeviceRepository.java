package phonesos.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonesos.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "devices", path = "devices")
public interface DeviceRepository
    extends PagingAndSortingRepository<Device, Long> {}
