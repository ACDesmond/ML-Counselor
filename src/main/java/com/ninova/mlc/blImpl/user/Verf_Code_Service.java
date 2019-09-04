package com.ninova.mlc.blImpl.user;

import com.ninova.mlc.data.user.VerfCodeMapper;
import com.ninova.mlc.po.verf_code_form;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
public class Verf_Code_Service {
    @Autowired
    VerfCodeMapper verfCodeMapper;

    public void sendVerfCode(String emailAdd, Timestamp time){
        try {
            StringBuffer buffer1=new StringBuffer();
            Random random=new Random();
            for(int i=0;i<6;i++){
                buffer1.append(random.nextInt(10)+"");
            }
            String VerCode=buffer1.toString();
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.qq.com");
            email.setCharset("UTF-8");
            //收件地址
            email.addTo(emailAdd);
            //邮件的发送人和地址
            email.setFrom("187039836@qq.com", "验证码邮件");
            //账户和授权码 用于登陆邮箱服务器的
            email.setAuthentication("187039836@qq.com", "ruymqzkiyqhpcbdg");
            email.setSubject("测试");
            email.setMsg("[ML+Counselor]您的验证码为"+VerCode+"，该验证码5分钟内有效。请勿泄漏于他人。");
            email.send();
            verfCodeMapper.addVerfCode(emailAdd,VerCode,time);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public String CompareVerfCode(String email,String code){
        verfCodeMapper.cleanExpiredCode();
        List<verf_code_form> verf_code_formList=verfCodeMapper.getVerfCode(email);
        if(verf_code_formList.size()==0){
            return "验证码已过期";
        }
        for(int i=0;i<verf_code_formList.size();i++){
            verf_code_form code_form=verf_code_formList.get(i);
            //Timestamp currentTime=new Timestamp(System.currentTimeMillis());
            //String currentTimeStr=currentTime.toString();
            if(code.equals(code_form.getVerf_code())){
                verfCodeMapper.deleteCode(email);
                return "验证成功";
            }
        }
        return "验证错误";
    }


}
