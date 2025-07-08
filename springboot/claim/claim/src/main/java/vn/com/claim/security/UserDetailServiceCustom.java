package vn.com.claim.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import vn.com.claim.entity.RoleEntity;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceCustom implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("username is empty");
        }

        //2.2 lấy user từ username của font-end
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("username not found");
        }
        // 2.3 tạo user của spring security
        Set<RoleEntity> roles = userEntity.getRoles();
        if (CollectionUtils.isEmpty(roles)) {
            throw new UsernameNotFoundException("username not authorized");
        }
        Set<GrantedAuthority> authoritiesRole = new HashSet<GrantedAuthority>();
        for (RoleEntity role : roles) {
            authoritiesRole.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
        }
        UserDetails userSecurity = new User(userEntity.getUsername(),userEntity.getPassword(),authoritiesRole);
        return userSecurity;
    }
}
