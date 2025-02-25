package hrssystem.model.mapper;

import hrssystem.model.dto.DoctorDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {

    // 전체 의사 조회
    @Select("SELECT doctorid, name, specialty, phone, createdat FROM doctors")
    List<DoctorDto> getAllDoctors();

    // 특정 의사 조회
    @Select("SELECT doctorid, name, specialty, phone, createdat FROM doctors WHERE doctorid = #{id}")
    DoctorDto getDoctorById(int id);

    // 의사 등록
    @Insert("INSERT INTO doctors (name, specialty, phone, createdat) VALUES (#{name}, #{specialty}, #{phone}, #{createdat})")
    void createDoctor(DoctorDto doctorDto);

    // 의사 정보 수정
    @Update("UPDATE doctors SET name = #{name}, specialty = #{specialty}, phone = #{phone}, createdat = #{createdat} WHERE doctorid = #{doctorid}")
    void updateDoctor(DoctorDto doctorDto);

    // 의사 삭제
    @Delete("DELETE FROM doctors WHERE doctorid = #{id}")
    void deleteDoctor(int id);
}