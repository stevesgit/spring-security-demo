package cn.steve.security.core.validate.code;

import cn.steve.security.core.properties.SecurityProperties;
import cn.steve.security.core.validate.code.image.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
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
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Autowired
    private ValidateCodeGenerator codeGenerator;

    @GetMapping("/code/image")
    public void creteCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = codeGenerator.generate(new ServletWebRequest(request));
        System.out.println(imageCode.getCode());
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(new ServletWebRequest(request),
                ValidateCodeController.SESSION_KEY);
        System.out.println(codeInSession.getCode());
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }


}
