package hrssystem.model.mapper;

import hrssystem.model.dto.AppointmentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppointmentMapper {

    // 전체 예약 조회
    @Select("SELECT * FROM appointment")
    List<AppointmentDto> selectAll();

    // 특정 예약 조회
    @Select("SELECT * FROM appointment WHERE appointmentid = #{appointmentid}")
    AppointmentDto selectById(@Param("appointmentid") int appointmentid);

    // 예약 등록
    @Insert("INSERT INTO appointment (patientid, doctorid, appointmentdate, appointmenttime, status, createdat) " +
            "VALUES (#{patientid}, #{doctorid}, #{appointmentdate}, #{appointmenttime}, #{status}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "appointmentid")
    int insert(AppointmentDto dto);

    // 예약 수정
    @Update("UPDATE appointment SET patientid = #{patientid}, doctorid = #{doctorid}, " +
            "appointmentdate = #{appointmentdate}, appointmenttime = #{appointmenttime}, status = #{status} " +
            "WHERE appointmentid = #{appointmentid}")
    int update(AppointmentDto dto);

    // 예약 삭제
    @Delete("DELETE FROM appointment WHERE appointmentid = #{appointmentid}")
    int delete(@Param("appointmentid") int appointmentid);
}