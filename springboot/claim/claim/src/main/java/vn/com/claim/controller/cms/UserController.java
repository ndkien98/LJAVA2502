package vn.com.claim.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/cms/user-manager")
    public String manageUsers() {
        return "cms/user-manager"; // Return the view name for managing users
    }
}
