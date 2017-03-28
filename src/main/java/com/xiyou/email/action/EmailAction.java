package com.xiyou.email.action;

import com.xiyou.email.entities.InfoRecord;
import com.xiyou.email.service.EmailService;
import com.xiyou.email.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailAction {

    @Autowired(required = false)
    private EmailService emailService;

    @RequestMapping(value = "/add")
    public String add(InfoRecord infoRecord){
        infoRecord.setActivationCode(UUIDUtil.getUUID() + UUIDUtil.getUUID());
        emailService.addInfoRecord(infoRecord);
        System.out.println(infoRecord);
        System.out.println("add");
        //emailService.sendEmail();
        return "test";
    }

}
