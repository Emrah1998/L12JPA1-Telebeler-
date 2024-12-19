package com.Telebeler.Telebeler.DAO.Repository;

import com.Telebeler.Telebeler.DAO.Entity.TelebeEntity;
import com.Telebeler.Telebeler.MODEL.Enum.TelebeStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TelebeRepository extends CrudRepository<TelebeEntity,Long> {
Optional<TelebeEntity> findByIdAndStatusNot(Long id, TelebeStatus status);
}
