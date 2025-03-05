package phonesos.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phonesos.domain.*;

@RepositoryRestResource(collectionResourceRel = "userInfos", path = "userInfos")
public interface UserInfoRepository
    extends PagingAndSortingRepository<UserInfo, Long> {}
