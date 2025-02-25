package hrssystem.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class PatientDto {
    private Integer patientid;        // 환자 ID
    private String name;              // 환자 이름
    private LocalDate birthdate;      // 생년월일
    private String phone;             // 전화번호
    private String address;           // 주소
    private LocalDateTime createdat;  // 생성일시
}
