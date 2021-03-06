package com.mall.dao;

import com.mall.model.AccountUserProfile;
import org.apache.ibatis.annotations.Insert;

public interface AccountUserProfileMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_user_profile
     *
     * @mbg.generated
     */
    @Insert({
        "insert into account_user_profile (id, account_id, ",
        "user_profile_id)",
        "values (#{id,jdbcType=INTEGER}, #{accountId,jdbcType=INTEGER}, ",
        "#{userProfileId,jdbcType=INTEGER})"
    })
    int insert(AccountUserProfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_user_profile
     *
     * @mbg.generated
     */
    int insertSelective(AccountUserProfile record);
}