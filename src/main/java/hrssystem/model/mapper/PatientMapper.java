package hrssystem.model.mapper;

import hrssystem.model.dto.PatientDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientMapper {

    // 전체 환자 조회
    @Select("SELECT patientid, name, birthdate, phone, address, createdat FROM patients")
    List<PatientDto> getAllPatients();

    // 특정 환자 조회
    @Select("SELECT patientid, name, birthdate, phone, address, createdat FROM patients WHERE patientid = #{id}")
    PatientDto getPatientById(int id);

    // 환자 등록
    @Insert("INSERT INTO patients (name, birthdate, phone, address, createdat) VALUES (#{name}, #{birthdate}, #{phone}, #{address}, #{createdat})")
    void createPatient(PatientDto patientDto);

    // 환자 정보 수정
    @Update("UPDATE patients SET name = #{name}, birthdate = #{birthdate}, phone = #{phone}, address = #{address}, createdat = #{createdat} WHERE patientid = #{patientid}")
    void updatePatient(PatientDto patientDto);

    // 환자 삭제
    @Delete("DELETE FROM patients WHERE patientid = #{id}")
    void deletePatient(int id);
}
