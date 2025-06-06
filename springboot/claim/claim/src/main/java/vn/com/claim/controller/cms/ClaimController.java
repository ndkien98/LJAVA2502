package vn.com.claim.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClaimController {


    @GetMapping("/cms/claim-manager")
    public String claimManager() {
        return "cms/claim-manager";
    }
}
