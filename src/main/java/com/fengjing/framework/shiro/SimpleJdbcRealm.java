package com.fengjing.framework.shiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.octo.captcha.service.image.ImageCaptchaService;

public class SimpleJdbcRealm extends JdbcRealm {

    private static final Logger log = LoggerFactory.getLogger(SimpleJdbcRealm.class);

	protected ImageCaptchaService imageCaptchaService; 
    
    public ImageCaptchaService getImageCaptchaService() {
		return imageCaptchaService;
	}

	public void setImageCaptchaService(ImageCaptchaService imageCaptchaService) {
		this.imageCaptchaService = imageCaptchaService;
	}
	
	/**
	 * 认证回调函数, 登录时调用.
	 */
	@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        
        CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
    	String parm = token.getCaptcha();
    	try {
	    	if (!imageCaptchaService.validateResponseForID(SecurityUtils.getSubject().getSession().getId().toString(), parm)) {
	    		throw new IncorrectCaptchaException("验证码错误！");
	    	}
    	} catch (Exception e) {
	    	throw new IncorrectCaptchaException("验证码错误！");
    	}
        
        String username = token.getUsername();

        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        Connection conn = null;
        AuthenticationInfo info = null;
        try {
            conn = dataSource.getConnection();

            String password = getPasswordForUser(conn, username);

            if (password == null) {
                throw new UnknownAccountException("No account found for user [" + username + "]");
            }

            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
            
            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
            
            info = simpleAuthenticationInfo;

        } catch (SQLException e) {
            final String message = "There was a SQL error while authenticating user [" + username + "]";
            if (log.isErrorEnabled()) {
                log.error(message, e);
            }

            throw new AuthenticationException(message, e);
        } finally {
            JdbcUtils.closeConnection(conn);
        }

        return info;
    	
    }
	
	
    private String getPasswordForUser(Connection conn, String username) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String password = null;
        try {
            ps = conn.prepareStatement(authenticationQuery);
            ps.setString(1, username);

            rs = ps.executeQuery();

            boolean foundResult = false;
            while (rs.next()) {

                if (foundResult) {
                    throw new AuthenticationException("More than one user row found for user [" + username + "]. Usernames must be unique.");
                }

                password = rs.getString(1);

                foundResult = true;
            }
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(ps);
        }

        return password;
    }
    
}
