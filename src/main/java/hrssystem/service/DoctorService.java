package hrssystem.service;

import hrssystem.model.dto.DoctorDto;
import hrssystem.model.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorService(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    // 전체 의사 조회
    public List<DoctorDto> getAllDoctors() {
        return doctorMapper.getAllDoctors();
    }

    // 특정 의사 조회
    public DoctorDto getDoctorById(int id) {
        return doctorMapper.getDoctorById(id);
    }

    // 의사 등록
    public void createDoctor(DoctorDto doctorDto) {
        doctorMapper.createDoctor(doctorDto);
    }

    // 의사 정보 수정
    public void updateDoctor(DoctorDto doctorDto) {
        doctorMapper.updateDoctor(doctorDto);
    }

    // 의사 삭제
    public void deleteDoctor(int id) {
        doctorMapper.deleteDoctor(id);
    }
}