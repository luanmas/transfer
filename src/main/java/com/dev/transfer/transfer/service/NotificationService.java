package com.dev.transfer.transfer.service;

import com.dev.transfer.transfer.client.NotificationClient;
import com.dev.transfer.transfer.entity.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer) {
        try {
            logger.info("Enviando a notificação: ", transfer);
            var resp = notificationClient.sendNotification(transfer);

            if(resp.getStatusCode().isError()) {
                logger.error("Erro no envio da notificação, status code diferente de Ok");
            }

        } catch (Exception e) {
            logger.error("Erro no envio da notificação", e);
        }
    }
}
