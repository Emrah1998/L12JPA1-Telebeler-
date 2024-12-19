package com.Telebeler.Telebeler.DAO.Entity;

import com.Telebeler.Telebeler.MODEL.Enum.TelebeStatus;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of="id")
@Entity
@Table(name="telebeler")
public class TelebeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private TelebeStatus status;
}
