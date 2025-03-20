package com.dev.transfer.transfer.client;

import com.dev.transfer.transfer.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        url = "client.notification-service.url"
)
public interface NotificationClient {

    ResponseEntity<Void> sendNotification(@RequestBody Transfer transfer);
}
