package flat.io.macnss.controller;
import flat.io.macnss.entity.person.Person;
import flat.io.macnss.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private HttpSession session;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role)
    {

        if(email == null || password == null || role == null) return "redirect:/users/login";

        Person person = userService.authenticate(email,password,role);

        System.out.println("session inside UserController: "+session);

        if (person != null){
            session.setAttribute("person",person);
            session.setAttribute("role",role);
            return role+"/home";
        }

        return "redirect:/users/login";
    }
}
