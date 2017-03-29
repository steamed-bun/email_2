package com.xiyou.email.action;

import com.xiyou.email.entities.InfoRecord;
import com.xiyou.email.service.EmailService;
import com.xiyou.email.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailAction {

    @Autowired(required = false)
    private EmailService emailService;

    @RequestMapping(value = "/add")
    public String add(InfoRecord infoRecord){
        infoRecord.setActivationCode(UUIDUtil.getUUID());
        emailService.addInfoRecord(infoRecord);
        System.out.println(infoRecord);
        System.out.println("add");
        emailService.sendEmail(infoRecord.getReceiver(),infoRecord.getActivationCode());
//        emailService.addInfoRecord(infoRecord);
        return "test";
    }

    @RequestMapping(value= "/activation", method= RequestMethod.GET)
    public String activation(@RequestParam("activationCode") String activationCode){
        InfoRecord infoRecord = emailService.getInfoRecordByCode(activationCode);
        if (infoRecord == null){
            return "error";
        }else {
            emailService.updateStatus(infoRecord);
        }
        return "success";
    }

}
