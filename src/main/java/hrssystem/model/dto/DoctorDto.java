package hrssystem.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DoctorDto {
    private Integer doctorid;         // 의사 ID
    private String name;              // 의사 이름
    private String specialty;         // 전문 분야
    private String phone;             // 전화번호
    private LocalDateTime createdat;  // 생성일시
}
