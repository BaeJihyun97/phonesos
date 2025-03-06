// package phonesos.external;

// import java.util.Date;
// import java.util.List;
// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name = "user", url = "${api.url.user}")
// public interface UserInfoService {
//     @GetMapping(path = "/userInfos")
//     public List<UserInfo> getUserInfo();

//     @GetMapping(path = "/userInfos/{id}")
//     public UserInfo getUserInfo(@PathVariable("id") Long id);
// }
