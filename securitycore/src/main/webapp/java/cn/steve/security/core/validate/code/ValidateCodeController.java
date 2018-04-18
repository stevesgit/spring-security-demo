package cn.steve.security.core.validate.code;

import cn.steve.security.core.properties.SecurityProperties;
import cn.steve.security.core.validate.code.image.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By SteveWoo
 */
@RestController
public class ValidateCodeController {
    @Autowired
    private SecurityProperties securityProperties;
    public static final String SESSION_KEY_PREFIX = "SESSION_KEY_";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Autowired
    @Qualifier("imageCodeGenerator")
    private ValidateCodeGenerator codeGenerator;
    @Autowired
    @Qualifier("smsCodeGenerator")
    private ValidateCodeGenerator smsCodeGenerator;

    @GetMapping("/code/image")
    public void creteCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode) codeGenerator.generate(new ServletWebRequest(request));
//        System.out.println(imageCode.getCode());
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_PREFIX + "IMAGE", imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }


    @GetMapping("/code/sms")
    public void creteSmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_PREFIX+"SMS", smsCode);
        System.out.println(smsCode.getCode());

        //短信发送
//        ImageIO.write(smsCode.getImage(), "JPEG", response.getOutputStream());
    }


}
