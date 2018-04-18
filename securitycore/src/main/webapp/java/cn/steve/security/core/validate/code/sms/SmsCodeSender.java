package cn.steve.security.core.validate.code.sms;

/**
 * Created By SteveWoo
 */
public interface SmsCodeSender {
    void send(String mobile, String code);

}
