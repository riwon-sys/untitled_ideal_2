package hrssystem.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
public class AppointmentDto {
    private Integer appointmentid;    // 예약 ID
    private Integer patientid;        // 환자 ID
    private Integer doctorid;         // 의사 ID
    private LocalDate appointmentdate;// 예약 날짜
    private LocalTime appointmenttime;// 예약 시간
    private Integer status;           // 예약 상태 (1: 예약확정, 0: 취소됨)
    private LocalDateTime createdat;  // 생성일시
}
