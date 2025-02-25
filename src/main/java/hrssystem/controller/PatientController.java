package hrssystem.controller;

import hrssystem.model.dto.PatientDto;
import hrssystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // 전체 환자 조회
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // 특정 환자 조회
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable int id) {
        PatientDto patient = patientService.getPatientById(id);
        return patient != null ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
    }

    // 환자 등록
    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
        patientService.createPatient(patientDto);
        return ResponseEntity.ok(patientDto);
    }

    // 환자 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable int id, @RequestBody PatientDto patientDto) {
        patientDto.setPatientid(id);
        patientService.updatePatient(patientDto);
        return ResponseEntity.ok(patientDto);
    }

    // 환자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
