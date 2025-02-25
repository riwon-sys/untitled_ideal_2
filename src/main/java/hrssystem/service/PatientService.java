package hrssystem.service;

import hrssystem.model.dto.PatientDto;
import hrssystem.model.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientMapper patientMapper;

    @Autowired
    public PatientService(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    // 전체 환자 조회
    public List<PatientDto> getAllPatients() {
        return patientMapper.getAllPatients();
    }

    // 특정 환자 조회
    public PatientDto getPatientById(int id) {
        return patientMapper.getPatientById(id);
    }

    // 환자 등록
    public void createPatient(PatientDto patientDto) {
        patientMapper.createPatient(patientDto);
    }

    // 환자 정보 수정
    public void updatePatient(PatientDto patientDto) {
        patientMapper.updatePatient(patientDto);
    }

    // 환자 삭제
    public void deletePatient(int id) {
        patientMapper.deletePatient(id);
    }
}