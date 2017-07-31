package net.ivica.toolr.web.controller;

import net.ivica.toolr.api.UserProfile;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class IndexController {

    @RequestMapping("/index.html")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean isAnonymous = (authentication == null || authentication instanceof AnonymousAuthenticationToken);

        if (!isAnonymous) {
            UserProfile authUser = (UserProfile) authentication.getPrincipal();

            model.addAttribute("authUser", authUser);
        }

        return "index";
    }

    @RequestMapping("/")
    public String root(Locale locale) {
        return "redirect:/index.html";
    }

}
