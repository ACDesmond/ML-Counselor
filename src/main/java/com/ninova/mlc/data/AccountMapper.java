package com.ninova.mlc.data;

import com.ninova.mlc.po.User;
import com.ninova.mlc.vo.UserForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    /**
     * 创建一个新的账号
     * @param username
     * @param password
     * @param Tag
     * @return
     */
    public int createNewAccount(@Param("username") String username, @Param("password") String password, @Param("Tag") int Tag,@Param("Tel")int Tel);
    /**
     * 根据用户名查找账号
     * @param username
     * @return
     */
    public User getAccountByName(@Param("username") String username);


    /**
     * 根据id查找员工
     * @param staffId
     * @return
     */
    User selectStaffById(@Param("staffId") int staffId);
    /**
     * 展示所有员工
     * @return
     */
    List<User> selectAllStaff();
    /**
     * 修改员工信息
     * @param updateStaffForm
     * @return
     */
    int updateStaff(UserForm updateStaffForm);
    /**
     * 根据ID删除员工信息
     * @param id
     * @return
     */
    int delStaffById(@Param("id") int id);

}
