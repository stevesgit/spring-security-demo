/**
 *
 */
package cn.steve.security.core.validate.code.sms;

import org.springframework.stereotype.Component;

/**
 * @author SteveWoo
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    /* (non-Javadoc)
     * @see com.imooc.security.core.validate.code.sms.SmsCodeSender#send(java.lang.String, java.lang.String)
     */
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }

}
