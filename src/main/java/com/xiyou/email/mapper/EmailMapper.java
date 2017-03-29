package com.xiyou.email.mapper;

import com.xiyou.email.entities.InfoRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailMapper {

    /**
     * 增加一条发送记录
     * @param infoRecord
     */
    void addInfoRecord(InfoRecord infoRecord);

    /**
     * 更改状态码
     * @param activationCode
     */
    void updateStatus(Object activationCode);

    /**
     * 通过激活码找到对应的记录
     * @param activationCode
     * @return
     */
    InfoRecord getInfoRecordByCode(Object  activationCode);

}
