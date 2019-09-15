package com.ninova.mlc.bl.user;

import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.UserForm;
import com.ninova.mlc.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountService {
    /**
     * 注册账号
     * @return
     */
    ResponseVO registerAccount(UserForm userForm);

    /**
     * 用户登录，登录成功会将用户信息保存再session中
     * @return
     */
    UserVO login(UserForm userForm);


    /**
     * 添加员工信息
     * @param userForm
     * @return
     */
    ResponseVO addStaff(UserForm userForm);

    /**
     * 修改员工信息
     * @param userForm
     * @return
     */
    ResponseVO updateUserInfo(UserForm userForm);

    /**
     * 根据id查询员工信息
     * @param userId
     * @return
     */
    ResponseVO searchStaffById(int userId);


    /**
     * 根据id删除员工
     * @param userId
     * @return
     */
    ResponseVO delStaffById(int userId);

    /*发送验证码的接口
    * */
    ResponseVO sendVerificationCode(String emailAdd);

    ResponseVO getEmail(int userID);

    ResponseVO compareCode(String email, String code);
}
