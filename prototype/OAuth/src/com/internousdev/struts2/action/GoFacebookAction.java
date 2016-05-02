package com.internousdev.struts2.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;


/**
 * GoFacebookAction Facebookでログインする為のクラス
 * @author Morikawa Kanako
 * @since 2015/09/09
 * @version 1.0
 */
public class GoFacebookAction  extends ActionSupport implements ServletResponseAware,ServletRequestAware  {

	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = 8410788671527276072L;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * レスポンス
	 */
	private HttpServletResponse response;


	/**
	 * ユーザー情報取得用トークン取得メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/09
	 * @return SUCCESS
	 * @throws Exception 例外処理
	 */
    public String execute() throws Exception {
    	getToken(request, response);
		return SUCCESS;
	}

    /**
     * Facebook認証画面へ遷移する為のメソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/09
     * @param request リクエスト
     * @param response レスポンス
     * @throws ServletException 例外処理
     * @throws IOException 例外処理
     */
    public void getToken(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        facebook.setOAuthAppId("516147198559238", "1ff39b49ce02715931c0b94aae149945");
        String accessTokenString = "516147198559238|f488a642223ee7444c36592d133c13e8";
        AccessToken at = new AccessToken(accessTokenString);
        facebook.setOAuthAccessToken(at);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/LoginFacebookAction");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
    }

	/**
	 * リクエスト格納メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/09
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
				this.request=request;
	}

	/**
	 * レスポンス格納メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/09
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

}
