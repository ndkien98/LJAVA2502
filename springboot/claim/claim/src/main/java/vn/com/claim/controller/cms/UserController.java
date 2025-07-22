package vn.com.claim.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/cms/user-manager")
    public String manageUsers() {
        return "cms/user/user-manager"; // Return the view name for managing users
    }

    @RequestMapping("/cms/create-user")
    public String createUser() {
        return "cms/user/create-user"; // Return the view name for creating a new user
    }

    @RequestMapping("/cms/detail-user/{id}")
    public String detailUser(@PathVariable int id) {
        return "cms/user/detail-user"; // Return the view name for user details
    }
}
