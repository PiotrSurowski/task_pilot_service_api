package pl.wsei.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    private String userBean;

    public UserComponent(@Qualifier("userBean") String userBean) {
        this.userBean = userBean;
    }
}
