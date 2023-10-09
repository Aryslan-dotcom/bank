package Kaspi.bank.controllerWeb;

import Kaspi.bank.Users.service.UserService;
import Kaspi.bank.category.service.CategoryService;
import Kaspi.bank.color.service.ColorService;
import Kaspi.bank.instalments.service.InstamentsService;
import Kaspi.bank.phone.service.ItemPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/bank")
public class HomeController {
    @Autowired
    private CategoryService categoryItemService;
    @Autowired
    private ItemPhoneService itemPhoneService;
    @Autowired
    private InstamentsService installmentsService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/home")
    public String openHome(Model model) {
        model.addAttribute("categories", categoryItemService.getAllCategoriesWichImage());
        return "home";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/login")
    public String openLogin() {
        return "login";
    }


    @GetMapping(value = "/phone")
    public String openPhonePage(Model model) {
        model.addAttribute("phones", itemPhoneService.getAllItemPhone());
        return "phone";
    }


    @GetMapping(value = "/search_price")
    public String homePrice(@RequestParam(name = "min_price") String minPriceStr,
                            @RequestParam(name = "max_price") String maxPriceStr,
                            @RequestParam(name = "search_name") String name, Model model) {
        model.addAttribute("itemPhonePrice", itemPhoneService.getAllItemPhoneWithPriceName(minPriceStr, maxPriceStr, name));
        return "phone";
    }


    @GetMapping(value = "/phone_details/{id}")
    public String openPhoneDetails(Model model, @PathVariable Long id) {
        model.addAttribute("categories", categoryItemService.getAllCategories());
        model.addAttribute("item_phone", itemPhoneService.getByIdItemPhone(id));
        model.addAttribute("installments", installmentsService.getAllInstalments());
        model.addAttribute("colors", colorService.getAllColors());
        return "phone_details";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String openProfilePage() {
        return "profile";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/adminPanel")
    public String openAdminPanel() {
        return "admin_panel";
    }

    @PostMapping(value = "/addAdmin")
    public String changeUserName(@RequestParam(name = "email-admin") String emailAdmin,
                                 @RequestParam(name = "full-name-admin") String fullNameAdmin,
                                 @RequestParam(name = "password-admin") String password,
                                 @RequestParam(name = "re-password-admin") String rePassword) {
        String check = userService.addAdminUser(emailAdmin, fullNameAdmin, password, rePassword);
        if (check.equals("userEmailNotMatches")) {
            return "redirect:adminPanel?userEmailNotMatches";
        } else if (check.equals("userPasswordNotMatches")) {
            return "redirect:adminPanel?userPasswordNotMatches";
        } else if (check.equals("userAdminSuccessAdd")) {
            return "redirect:adminPanel?userAdminSuccessAdd";
        } else {
            return "redirect:adminPanel?userIsEmpty";
        }
    }

    @GetMapping(value = "/403")
    public String accessDeniedPage() {
        return "403";
    }

    @GetMapping(value = "/register")
    public String openRegistrationPage() {
        return "register";
    }


    @PostMapping(value = "/sign-up")
    public String openSingUp(@RequestParam(name = "user-full-name") String full_name,
                             @RequestParam(name = "user-email") String email,
                             @RequestParam(name = "user-password") String password,
                             @RequestParam(name = "user-re-password") String rePassword) {
        String check = userService.userSignUp(full_name, email, password, rePassword);
        if (check.equals("userExist")) {
            return "redirect:register?userExist";
        } else if (check.equals("passwordNotMatch")) {

            return "redirect:register?passwordNotMatch";
        } else {
            return "redirect:register?success";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/change-password")
    public String openChangePasswordPage() {
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    public String changePassword(@RequestParam(name = "current-user-id") Long userId,
                                 @RequestParam(name = "user-old-password") String oldPassword,
                                 @RequestParam(name = "user-new-password") String newPassword,
                                 @RequestParam(name = "user-re-password") String rePassword) {
        String check = userService.changePassword(userId, oldPassword, newPassword, rePassword);
        if (check.equals("oldPasswordNotMatches")) {
            return "redirect:change-password?oldPasswordNotMatches";
        } else if (check.equals("newPasswordsNotMatches")) {
            return "redirect:change-password?newPasswordNotMatches";
        } else {
            return "redirect:change-password?changesPasswordSuccess";
        }
    }
}
