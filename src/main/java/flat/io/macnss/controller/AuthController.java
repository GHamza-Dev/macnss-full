package flat.io.macnss.controller;
import flat.io.macnss.entity.person.Person;
import flat.io.macnss.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class AuthController {

    private AuthService authService;
    private HttpSession session;

    @Autowired
    public void setUserService(AuthService authService) {
        this.authService = authService;
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

        Person person = authService.authenticate(email,password,role);

        System.out.println("session inside AuthController: "+session);

        if (person != null){
            session.setAttribute("person",person);
            session.setAttribute("role",role);
            return role+"/home";
        }

        return "redirect:/users/login";
    }
}
