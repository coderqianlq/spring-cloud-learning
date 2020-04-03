package com.qianlq.support.client;

import com.qianlq.api.v2.api.TestApi;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author CoderQian
 * @version v1.0
 * @date 2020-04-01
 */

@Component
@FeignClient(name = "service-producer")
public interface TestClient extends TestApi {
}
