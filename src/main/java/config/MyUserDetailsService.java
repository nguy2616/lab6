
package config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;

        if(s.equalsIgnoreCase("user")) {

            List<GrantedAuthority> list = new ArrayList<>();
            list.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_USER";
                }
            });

            user = new User("user", "user",
                    true, true, true, true, list);

        }
        if(s.equalsIgnoreCase("admin"))
        {
            List<GrantedAuthority> list = new ArrayList<>();
            list.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_ADMIN";
                }
            });

            user = new User("admin", "admin",
                    true, true, true, true, list);

        }
        return user;
    }
}

