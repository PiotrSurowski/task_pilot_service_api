package pl.wsei.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = "*")
public class UserController2 {
    private String userBean;
    @Autowired
    public UserController2(@Qualifier("userBean") String userBean) {
        this.userBean = userBean;
    }

    @GetMapping("getUser")
    public String getUser(){
        return "userBean";
    }
}
