package com.backbase.service.auth.controller;

import com.backbase.buildingblocks.authentication.core.AuthEndpoints;
import com.backbase.buildingblocks.authentication.core.AuthenticationHandler;
import com.backbase.buildingblocks.jwt.external.ExternalJwtProducer;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private static final String USERNAME_FIELD = "username";
    private static final String EMAIL_FIELD = "email";
    private static final String PASSWORD_FIELD = "password";
    private static final String LOGIN_TEMPLATE = "login.ftl";
    private static final String SUCCESS_TEMPLATE = "success.ftl";

    private static final String DEFAULT_LOGIN_PATH = "/login";

    private final AuthenticationManager authenticationManager;
    private final AuthenticationHandler authenticationHandler;
    private final ExternalJwtProducer tokenProducer;

    @ResponseBody
    @GetMapping(value = DEFAULT_LOGIN_PATH, produces = TEXT_HTML_VALUE)
    public String getLoginPage(HttpServletRequest request) {
        return generateHTMLTemplate(request, null, LOGIN_TEMPLATE);
    }

    @ResponseBody
    @PostMapping(value = DEFAULT_LOGIN_PATH, produces = TEXT_HTML_VALUE, consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> doLogin(@RequestParam(value = USERNAME_FIELD) String username,
                                          @RequestParam(value = EMAIL_FIELD) String email,
                                          @RequestParam(value = PASSWORD_FIELD) String password,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {

        AbstractAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        String templateToReturn;

        HttpStatus status;

        String errorMessage = null;

        try {
            Authentication authenticate = authenticationManager.authenticate(authRequest);

            authenticationHandler.onSuccessfulLogin(request, response, authenticate);
            // TODO 2 : call appendCookieToken method


            log.info("User '{}' authenticated with email '{}'", username, email);

            templateToReturn = SUCCESS_TEMPLATE;

            status = HttpStatus.OK;
        } catch (AuthenticationException ex) {
            log.error("Unauthorized user '{}'", username);

            templateToReturn = LOGIN_TEMPLATE;

            status = HttpStatus.UNAUTHORIZED;

            errorMessage = ex.getMessage();
        }

        return new ResponseEntity<>(generateHTMLTemplate(request, errorMessage, templateToReturn), status);
    }

    private void appendCookieToken(HttpServletResponse response, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken)) {
            log.info("Adding external JWT to the response as a cookie");
            //TODO 3 : Create an ExternalJwtCookie object with tokenProducer and authentication, more info at https://community.backbase.com/documentation/platform-services/1-11-0/use_jwts_in_ips
            //code here
            // TODO 4 : Add the ExternalJwtCookie to the response
            //code here
        }
    }


    private String generateHTMLTemplate(HttpServletRequest request, String errorMessage, String templateName) {
        final String loginPageUri = AuthEndpoints.getRequestPath(request);

        Configuration cfg = new Configuration();
        Writer out = new StringWriter();
        try {
            Resource resource = new ClassPathResource("statics");
            cfg.setDirectoryForTemplateLoading(resource.getFile());
            cfg.setDefaultEncoding("UTF-8");
            Template template = cfg.getTemplate(templateName);
            template.process(inputTemplateInitialization(errorMessage, loginPageUri), out);
        } catch (IOException | TemplateException e) {
            log.error("Error generating the HTML template", e);
        }

        return out.toString();
    }

    private Map<String, Object> inputTemplateInitialization(String errorMessage, String loginPageUri) {
        Map<String, Object> input = new HashMap<>();

        input.put("USERNAME_FIELD", USERNAME_FIELD);
        input.put("PASSWORD_FIELD", PASSWORD_FIELD);
        input.put("EMAIL_FIELD", EMAIL_FIELD);
        input.put("LOGIN_PAGE_URL", loginPageUri);
        input.put("ERROR_MESSAGE", errorMessage);
        return input;
    }

}