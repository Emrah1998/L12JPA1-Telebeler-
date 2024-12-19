package com.Telebeler.Telebeler.SERVICE;

import com.Telebeler.Telebeler.DAO.Entity.TelebeEntity;
import com.Telebeler.Telebeler.DAO.Repository.TelebeRepository;
import com.Telebeler.Telebeler.MODEL.Request.CreateTelebeRequest;
import com.Telebeler.Telebeler.MODEL.Request.UpdataAgeRequest;
import com.Telebeler.Telebeler.MODEL.Enum.TelebeStatus;
import com.Telebeler.Telebeler.MODEL.Response.TelebeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelebeServiceHandle implements TelebeService {

    private final TelebeRepository telebeRepository;

    @Override
    public void saveTelebe(CreateTelebeRequest telebe) {
        telebeRepository.save(
                TelebeEntity.builder()
                        .name(telebe.getName())
                        .surname(telebe.getSurname())
                        .age(telebe.getAge())
                        .build()
        );
    }

    @Override
    public void updateTelebeAge(Long id, UpdataAgeRequest request) {

        var telebe = telebeRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        telebe.setAge(request.getAge());
        telebeRepository.save(telebe);
    }

    @Override
    public void deleteTelebe(Long id) {
        var telebe = fetchTelebeIfExist(id);
        telebe.setStatus(TelebeStatus.DELETED);
        telebeRepository.save(telebe);
    }

    @Override
    public TelebeResponse getTelebe(Long id) {
        var telebe = fetchTelebeIfExist(id);
        return new TelebeResponse(telebe.getName(), telebe.getSurname());
    }

    private TelebeEntity fetchTelebeIfExist(Long id) {
        return  telebeRepository.findByIdAndStatusNot(id,TelebeStatus.DELETED)
                .orElseThrow(RuntimeException::new);
    }
}
