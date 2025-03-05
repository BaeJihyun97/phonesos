package phonesos.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonesos.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "deviceInfos",
    path = "deviceInfos"
)
public interface DeviceInfoRepository
    extends PagingAndSortingRepository<DeviceInfo, Long> {}
