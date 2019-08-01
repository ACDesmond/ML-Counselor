package com.ninova.mlc.blImpl.user;

import com.ninova.mlc.bl.user.AccountService;
import com.ninova.mlc.data.AccountMapper;
import com.ninova.mlc.po.User;
import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.UserForm;
import com.ninova.mlc.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class AccountServiceImpl implements AccountService {
    private final static String ACCOUNT_EXIST = "账号已存在";

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public ResponseVO registerAccount(UserForm userForm) {
        try {
            accountMapper.createNewAccount(userForm.getUsername(), userForm.getPassword(),0);
        } catch (Exception e) {
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
            accountMapper.createNewAccount(userForm.getUsername(),userForm.getPassword(),userForm.getUserlevel());
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
    public ResponseVO updateStaffInfo(UserForm userForm){
        try {
            accountMapper.updateStaff(userForm);
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
            User staff=accountMapper.selectStaffById(staffId);
            return ResponseVO.buildSuccess(staff);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };

    /**
     * 搜索所有员工信息
     * @return
     */
    @Override
    public ResponseVO searchAllStaff(){
        try {
            return ResponseVO.buildSuccess(accountMapper.selectAllStaff());
        } catch (Exception e) {
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
    };


}
