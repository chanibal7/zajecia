/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-webapp
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-06
 *
 *****************************************************/
package com.software.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.software.dto.UserChangePasswordDto;
import com.software.dto.UserResetPasswordDto;
import com.software.service.UserService;
import com.software.service.auth.ZajeciaAuthority;
import com.software.controller.helper.UrlHelper;

@Controller
public class LoginController {

    private static final String CHANGE_PASSWORD = "change-password";

    @Autowired
    private UserService userService;
    @Autowired
    private ZajeciaAuthority zajeciaAuthority;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/usage-agreement", method = RequestMethod.GET)
    public String usageAgreement() {
        return "zajeciaUsageAgreement";
    }

    @RequestMapping(value = "/accept-usage-agreement", method = RequestMethod.POST)
    public String acceptUsageAgreement() {

        zajeciaAuthority.acceptZajeciaAgreementAndReloadAuthorities();
        // Redirect because when you try to return just view name you will
        // display welcome page with accept-usage-agreement.htm access rights
        return "redirect:/welcome.htm";
    }

    @RequestMapping(value = "/reset-repeat", method = { RequestMethod.POST })
    public String resetRepeat() {
        return "reset-repeat";
    }

    @RequestMapping(value = "/change-password", method = { RequestMethod.GET })
    public String changePassword(final ModelMap model) {
        model.addAttribute("dto", UserChangePasswordDto.createEmptyDto());
        return CHANGE_PASSWORD;
    }

    @RequestMapping(value = "/set-new-password", method = { RequestMethod.POST })
    public ModelAndView setPassword(final ModelMap model, @ModelAttribute("dto") @Valid final UserChangePasswordDto dto, final BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView(CHANGE_PASSWORD, "dto", dto);
        }
        if (!userService.isCurrentPasswordExistsForLoggedUser(dto)){
            model.addAttribute("error", "login.change.password.incorect.password");
            return new ModelAndView(CHANGE_PASSWORD, model);
        }
        userService.changePassword(dto);
        return new ModelAndView("set-password");
    }


    @RequestMapping(value = "/reset", method = { RequestMethod.GET })
    public String reset() {
        return "reset";
    }

    @RequestMapping(value = "/reset-done", method = { RequestMethod.GET, RequestMethod.POST })
    public String resetDone(@RequestParam final String username, final HttpServletRequest request) {
        if (userService.findUniqueUserByEmailIgnoreCaseSensivity(username) == null) {
            return "reset-repeat";
        }
        userService.sendResetPasswordEmail(username, UrlHelper.getServerUrl(request));
        return "reset-done";
    }

    @RequestMapping(value = "/new-password", method = RequestMethod.GET)
    public String newPassword(@RequestParam final String token, final ModelMap model) {
        if (!userService.checkAvailabilityOfToken(token)) {
            return "invalid-token";
        }
        model.addAttribute("dto", UserResetPasswordDto.createEmptyWithToken(token));
        return "new-password";
    }

    @RequestMapping(value = "/set-password", method = { RequestMethod.POST })
    public ModelAndView setPassword(@ModelAttribute("dto") @Valid final UserResetPasswordDto dto, final BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("new-password", "dto", dto);
        }
        userService.setPasswordAndActiveAccount(dto.getToken(), dto.getNewPassword());
        return new ModelAndView("set-password");
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}
