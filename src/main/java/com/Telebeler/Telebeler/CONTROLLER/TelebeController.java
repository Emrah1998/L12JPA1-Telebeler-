package com.Telebeler.Telebeler.CONTROLLER;

import com.Telebeler.Telebeler.MODEL.Request.CreateTelebeRequest;
import com.Telebeler.Telebeler.MODEL.Request.UpdataAgeRequest;
import com.Telebeler.Telebeler.MODEL.Response.TelebeResponse;
import com.Telebeler.Telebeler.SERVICE.TelebeServiceHandle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/telebeler")
public class TelebeController {
    private final TelebeServiceHandle telebeService;

    @PostMapping
    public void saveTelebe(@RequestBody CreateTelebeRequest telebe){
        telebeService.saveTelebe(telebe);
    }

    @PatchMapping("/{id}/age")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTelebeAge(@PathVariable Long id,
                                @RequestBody UpdataAgeRequest request){
        telebeService.updateTelebeAge(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTelebe(@PathVariable Long id){
        telebeService.deleteTelebe(id);
    }

    @GetMapping("/{id}")
    public TelebeResponse getTelebe(@PathVariable Long id){
        return telebeService.getTelebe(id);
    }
}
