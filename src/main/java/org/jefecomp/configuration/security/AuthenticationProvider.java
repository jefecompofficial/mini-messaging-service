/**
 * 
 */
package org.jefecomp.configuration.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author jefecomp
 *
 */
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(Authentication arg0) throws AuthenticationException {
	
	return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> arg0) {
	// TODO Auto-generated method stub
	return false;
    }

}
