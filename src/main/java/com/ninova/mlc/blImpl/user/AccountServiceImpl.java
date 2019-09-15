package com.ninova.mlc.blImpl.user;

import com.ninova.mlc.bl.user.AccountService;
import com.ninova.mlc.data.user.AccountMapper;
import com.ninova.mlc.po.User;
import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.UserForm;
import com.ninova.mlc.vo.UserVO;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {
    private final static String ACCOUNT_EXIST = "账号已存在";

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private Verf_Code_Service verf_code_service;

    @Override
    public ResponseVO registerAccount(UserForm userForm) {
        try {
            accountMapper.createNewAccount(userForm.getUsername(), userForm.getPassword(),0,userForm.getEmailAdd());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public UserVO login(UserForm userForm) {
        User user = accountMapper.getAccountByName(userForm.getUsername());
        if (null == user || !user.getPassword().equals(userForm.getPassword())) {
            return null;
        }
        return new UserVO(user);
    }

    /**
     * 添加员工信息
     * @param userForm
     * @return
     */
    @Override
    public ResponseVO addStaff(UserForm userForm){
        try {
            accountMapper.createNewAccount(userForm.getUsername(),userForm.getPassword(),userForm.getTag(),userForm.getEmailAdd());
            return ResponseVO.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
    };

    /**
     * 修改员工信息
     * @param userForm
     * @return
     */
    @Override
    public ResponseVO updateUserInfo(UserForm userForm){
        try {
            accountMapper.updateUser(userForm);
            return ResponseVO.buildSuccess();
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };

    /**
     * 根据id查询员工信息
     * @param staffId
     * @return
     */
    @Override
    public ResponseVO searchStaffById(int staffId){
        try{
            User staff=accountMapper.selectUserById(staffId);
            return ResponseVO.buildSuccess(staff);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };


    /**
     * 根据id删除员工
     * @param staffId
     * @return
     */
    @Override
    public ResponseVO delStaffById(int staffId){
        try {
            accountMapper.delStaffById(staffId);
            return ResponseVO.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO sendVerificationCode(String emailAdd) {
        try {
            Timestamp currenttime = new Timestamp(System.currentTimeMillis());
            verf_code_service.sendVerfCode(emailAdd,currenttime);
            return ResponseVO.buildSuccess("发送成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getEmail(int userID){
        try {
            User user=accountMapper.selectUserById(userID);
            String emailAdd=user.getEmailAdd();
            return ResponseVO.buildSuccess(emailAdd);
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO compareCode(String email, String code) {
        try {
            String str=verf_code_service.CompareVerfCode(email,code);
            return ResponseVO.buildSuccess(str);
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }


}
