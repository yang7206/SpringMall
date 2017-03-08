package com.mall.service;

import com.mall.model.Account;
import com.mall.model.UserProfile;
import com.mall.provider.CustomDaoAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangxiaoyu on 17/3/4.
 */
@Service("customAccountService")
public class CustomAccountService implements UserDetailsService {

    @Autowired
    IAccountService accountService;

    @Autowired
    CustomDaoAuthenticationProvider daoAuthenticationProvider;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s == null || "".equals(s.trim())){
            throw new UsernameNotFoundException(daoAuthenticationProvider.getMessage("AbstractUserDetailsAuthenticationProvider.emptyUsername", "请输入帐号"));
        }
        Account account = accountService.findAccountByAccount(s);
        if (account == null) {
            throw new UsernameNotFoundException(daoAuthenticationProvider.getMessage("AbstractUserDetailsAuthenticationProvider.invalidUsername", "用户不存在"));
        }

        return new User(account.getAccount(),account.getPassword(),
                account.getAccountState().equalsIgnoreCase("ACTIVE"),
                true,true,!account.getAccountState().equalsIgnoreCase("LOCKED"),getGrantedAuthoritise(account));
    }


    private List<GrantedAuthority> getGrantedAuthoritise(Account account){
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (UserProfile userProfile:
             account.getUserProfiles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));

        }

        System.out.println("authorities : "+authorities);

        return authorities;

    }

}
