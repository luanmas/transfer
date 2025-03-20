package com.dev.transfer.transfer.client;

import com.dev.transfer.transfer.client.dto.AuthorizationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        url = "${client.authorization-service.url}"
)
public interface AuthorizationClient {
    @GetMapping
    ResponseEntity<AuthorizationRequest> isAuthorized();
}
