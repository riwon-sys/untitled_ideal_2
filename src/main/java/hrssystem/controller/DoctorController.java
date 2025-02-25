package hrssystem.controller;


import hrssystem.model.dto.DoctorDto;
import hrssystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // 전체 의사 조회
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    // 특정 의사 조회
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable int id) {
        DoctorDto doctor = doctorService.getDoctorById(id);
        return doctor != null ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    // 의사 등록
    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        doctorService.createDoctor(doctorDto);
        return ResponseEntity.ok(doctorDto);
    }

    // 의사 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable int id, @RequestBody DoctorDto doctorDto) {
        doctorDto.setDoctorid(id);
        doctorService.updateDoctor(doctorDto);
        return ResponseEntity.ok(doctorDto);
    }

    // 의사 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}