/**
 * 
 */
package cn.steve.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author SteveWoo
 *
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
