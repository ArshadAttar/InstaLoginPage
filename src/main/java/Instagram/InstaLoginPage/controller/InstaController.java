package Instagram.InstaLoginPage.controller;

import Instagram.InstaLoginPage.model.InstaDTO;
import Instagram.InstaLoginPage.model.TempDto;
import Instagram.InstaLoginPage.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InstaController {
    @Autowired
    private Service service;

    @GetMapping("/instagram")
    public String instaHomePage() {
        return "homePage";
    }

    @GetMapping("/addDetails")
    public String addDetails(Model model) {
        model.addAttribute("instaObject", new InstaDTO());
        return "loginPage";
    }

    @PostMapping("/saveDataLink")
    public String saveUserData(@ModelAttribute("instaObject") InstaDTO dto) {
        service.saveData(dto);
        return "redirect:/instagram";
    }

    @GetMapping("/loginLink")
    public String checkData(Model model) {
        model.addAttribute("loginForm", new TempDto());
        return "loginLink";
    }

    @PostMapping("/loginLink")
    public String dataValidation(@ModelAttribute("loginForm") TempDto tempDto, Model model) {
        String tempData = tempDto.getUserData();
        String tempPass = tempDto.getPassword();
        Boolean result = service.validateData(tempData, tempPass);
        if (result) {
            return "InstagramPage";
        } else {
            model.addAttribute("errorMessage", "Invalid User Id And Password ! ");
            return "homePage";
        }
    }
}

