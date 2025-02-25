package hrssystem.service;

import hrssystem.model.dto.AppointmentDto;
import hrssystem.model.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentService(AppointmentMapper appointmentMapper) {
        this.appointmentMapper = appointmentMapper;
    }

    // 전체 예약 조회
    public List<AppointmentDto> getAllAppointments() {
        return appointmentMapper.selectAll();
    }

    // 특정 예약 조회
    public AppointmentDto getAppointmentById(int appointmentid) {
        return appointmentMapper.selectById(appointmentid);
    }

    // 예약 등록
    public int createAppointment(AppointmentDto dto) {
        return appointmentMapper.insert(dto);
    }

    // 예약 수정
    public int updateAppointment(AppointmentDto dto) {
        return appointmentMapper.update(dto);
    }

    // 예약 삭제
    public int deleteAppointment(int appointmentid) {
        return appointmentMapper.delete(appointmentid);
    }
}
