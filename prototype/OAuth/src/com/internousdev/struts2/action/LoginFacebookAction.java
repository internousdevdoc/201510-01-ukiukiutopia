package com.internousdev.struts2.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internousdev.struts2.dao.LoginOauthDAO;
import com.internousdev.struts2.dto.LoginOauthDTO;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


/**
 * LoginFacebookAction Facebookでログインする為のクラス
 * @author Morikawa Kanako
 * @since 2015/09/15
 * @version 1.0
 */
public class LoginFacebookAction extends ActionSupport implements SessionAware,
ServletResponseAware, ServletRequestAware{

	/**
	 *生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = 2731955946962434760L;

	/**
	 * レスポンス
	 */
	private HttpServletRequest request;

	/**
	 * リクエスト
	 */
	private HttpServletResponse response;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * FacebookのユニークID
	 */
	private String uniqueId;

	/**
	 * ユーザーID
	 */
	private String id;

	/**
	 * 結果
	 */
	private String result;

	/**
	 * セッション
	 */
	public Map<String, Object> session;

	/**
	 * Facebook認証の実行メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/15
	 * @return result 
	 * @throws Exception 例外処理
	 */
	public String execute() throws Exception {
		result = ERROR;

			getToken(request, response);

			if (id == null) {
				return result;
			}
			return id;
	}




	/**
	 * ユーザー情報取得用トークン取得メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/15
	 * @param request リクエスト
	 * @param response レスポンス
	 * @throws ServletException 例外処理
	 * @throws Exception 例外処理
	 */
	public void getToken(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {
		final String callbackURL = request.getRequestURL().toString();
		final String code = request.getParameter("code");
		if (code == null) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
		}
		final String appId = "516147198559238";
		final String appSecret = "1ff39b49ce02715931c0b94aae149945";
		final String accessTokenURL = "https://developers.facebook.com/docs/authentication/server-side/"
				+ appId
				+ "&redirect_uri="
				+ URLEncoder.encode(callbackURL, "UTF-8")
				+ "&client_secret="
				+ appSecret + "&code=" + URLEncoder.encode(code, "UTF-8");
		final String accessTokenResult = httpRequest(new URL(accessTokenURL));
		String accessToken = null;
		String[] pairs = accessTokenResult.split("&");
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			if (kv.length != 2) {
				throw new RuntimeException("Unexpected auth response");
			} else {
				if (kv[0].equals("access_token")) {
					accessToken = kv[1];
				}
			}
		}
		final String apiURL = "https://developers.facebook.com/docs/authentication/server-side/me?access_token="
				+ URLEncoder.encode(accessToken, "UTF-8");
		final String apiResult = httpRequest(new URL(apiURL));
		Map<?, ?> map = new HashMap<Object, Object>();
		session.put("familyname", name);
		session.put("id", id);
		session.put("accessToken", accessToken);
		request.getSession().setAttribute("loginUser", map);
	}

	String httpRequest(URL url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String line = null;
		String response = "";
		while ((line = reader.readLine()) != null) {
			response += line;
		}
		reader.close();
		conn.disconnect();
		return response;
	}

	/**
	 * リクエスト格納メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/15
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * レスポンス格納メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/15
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * セッション取得メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/15
	 * @return session 
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション格納メソッド
	 * @author Morikawa Kanako
	 * @since 2015/09/15
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
