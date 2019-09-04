package com.ninova.mlc.blImpl.user;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Random;

public class sendEmail {
    public static void sendEmailCode(String emailAddress,String code)throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.qq.com");
        email.setCharset("UTF-8");
        //收件地址
        email.addTo(emailAddress);
        //邮件的发送人和地址
        email.setFrom("187039836@qq.com", "验证码邮件");
        //账户和授权码 用于登陆邮箱服务器的
        email.setAuthentication("187039836@qq.com", "ruymqzkiyqhpcbdg");
        email.setSubject("测试");
        email.setMsg("这是验证码测试"+code);
        email.send();
    }

    public static void main(String[] args) throws Exception{
        StringBuffer buffer=new StringBuffer();
        Random random=new Random();
        for(int i=0;i<6;i++){
            buffer.append(random.nextInt(10)+"");
        }
        sendEmailCode("1045407918@qq.com",buffer.toString());
    }
}
