package ma.enset.patientmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecurityController {

    @GetMapping(path = "/403")

    public  String notAuthorized(){
        return "403";
}



}
