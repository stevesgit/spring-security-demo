package cn.steve.security.core.validate.code;

/**
 * Created By SteveWoo
 */

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.steve.security.core.properties.SecurityProperties;
import cn.steve.security.core.validate.code.sms.SmsCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;


/**
 * @author SteveWoo
 */
public class SmsCodeFilter extends OncePerRequestFilter {
    private AuthenticationFailureHandler authenticationFailureHandler;
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    private SecurityProperties securityProperties;
    private Set<String> urls = new HashSet<>();
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] ConfigUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getSms().getUrl(), ",");
        System.out.println(ConfigUrls);
        for (String configUrl : ConfigUrls) {
            urls.add(configUrl);
        }
        urls.add("/authentication/mobile");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        boolean action = false;
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                action = true;
            }

        }
        if (action) {
            try {
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        chain.doFilter(request, response);

    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        SmsCode codeInSession = (SmsCode) sessionStrategy.getAttribute(request,
                "SESSION_KEY_FOR_CODE_" + "SMS");
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "smsCode");

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("短信验证码的值不能为空");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("短信验证码不存在");
        }
        System.out.println(codeInSession.getCode());
        System.out.println(codeInSession);
        System.out.println(codeInSession.getCode());
        System.out.println(codeInSession.getCode());
        System.out.println(codeInSession.getCode());


        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(request, "SESSION_KEY_FOR_CODE_" + "SMS");
            throw new ValidateCodeException("验证码已经过期");
        }
        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(request, "SESSION_KEY_FOR_CODE_" + "SMS");

    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public SessionStrategy getSessionStrategy() {
        return sessionStrategy;
    }

    public void setSessionStrategy(SessionStrategy sessionStrategy) {
        this.sessionStrategy = sessionStrategy;
    }
}