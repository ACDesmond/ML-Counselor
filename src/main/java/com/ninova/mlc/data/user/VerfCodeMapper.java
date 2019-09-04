package com.ninova.mlc.data.user;

import com.ninova.mlc.po.verf_code_form;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface VerfCodeMapper {
    public int addVerfCode(@Param("emailAdd")String emailAdd, @Param("VerfCode")String VerfCode, @Param("time")Timestamp time);

    public List<verf_code_form> getVerfCode(String email);

    public void deleteCode(String email);

    @Scheduled(cron = "0/1 * * * * ?")
    void cleanExpiredCode();
}
