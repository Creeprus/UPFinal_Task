package Controllers;

import Repository.AccountRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {
    @Autowired
    AccountRepositry accountRepositry;
}
