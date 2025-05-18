package pl.wsei.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean(name = "userBean")
    public String userBean(){
        System.out.println("User bean created");
        return "user bean";
    }
}
