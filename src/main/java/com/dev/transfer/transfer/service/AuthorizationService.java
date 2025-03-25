package com.dev.transfer.transfer.service;

import com.dev.transfer.transfer.client.AuthorizationClient;
import com.dev.transfer.transfer.controller.dto.TransferDTO;
import com.dev.transfer.transfer.entity.Transfer;
import com.dev.transfer.transfer.exceptions.TransferException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDTO transfer) {
        var resp = authorizationClient.isAuthorized();

        if(resp.getStatusCode().isError()) {
            throw new TransferException();
        }

        return resp.getBody().authorize();
    }
}
