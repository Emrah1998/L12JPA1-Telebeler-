package com.Telebeler.Telebeler.SERVICE;

import com.Telebeler.Telebeler.MODEL.Request.CreateTelebeRequest;
import com.Telebeler.Telebeler.MODEL.Request.UpdataAgeRequest;
import com.Telebeler.Telebeler.MODEL.Response.TelebeResponse;

public interface TelebeService {
    void saveTelebe (CreateTelebeRequest telebe);
    void updateTelebeAge (Long id, UpdataAgeRequest request);
    void deleteTelebe (Long id);
    TelebeResponse getTelebe (Long id);
}
