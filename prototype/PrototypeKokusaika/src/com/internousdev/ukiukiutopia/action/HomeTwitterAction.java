package com.internousdev.ukiukiutopia.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ukiukiutopia.Token.TwitterAccessToken;
import com.internousdev.ukiukiutopia.dao.HomeUserDAO;
import com.internousdev.ukiukiutopia.dto.HomeUserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginTwitterAction
 * Twitter認証画面からユーザーページか新規登録画面へ遷移する為のアクションクラス
 * @author 佐島 和至
 * @since 2015/08/10
 * @version 1.0
 */
public class HomeTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware{

	/**
	 * シリアルバージョンIDの生成
	 */
	private static final long serialVersionUID = 3787626263699340105L;

	/**
	 * セッション
	 */
	public Map<String, Object> session;

	/**
	 * レスポンス
	 */
	private HttpServletResponse response;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * ユーザー情報
	 */
	private String[] userData = new String[2];

	/**
	 * ログインID
	 */
	public String userLoginId = null;


	/**
	 * 実行メソッド
	 * @since 2015/08/10
	 * @return result
	 * @see TwitterAccessToken
	 */
	public String execute() {
		TwitterAccessToken twitter = new TwitterAccessToken();

		String result = ERROR;

		String verifier = request.getParameter("oauth_verifier");
		if(verifier == null){
			return result;
		}

		try{
			userData = twitter.loginOAuth(response, request);

			userLoginId = userData[1];

			HomeUserDAO dao = new HomeUserDAO();
			HomeUserDTO dto;
			if(dao.selectByUserUniqueId(userLoginId)){
				dto = dao.getLoginUserDTO();

				session.put("userId", dto.getUserId());
				session.put("loginId", dto.getLoginId());
				session.put("password", dto.getPassword());
				session.put("userName", dto.getUserName());
				session.put("uniqueId", dto.getUniqueId());
				result = "success";

				if(session.containsKey("prePage")){

					String prePage = (String)session.get("prePage");

					if(prePage.equals("selectProductPage")){
						result = "selectProductPage";
					}

					if(prePage.equals("selectDetailPage")){
						result = "selectDetailPage";
					}

					if(prePage.equals("cartPage")){
						result = "cartPage";
					}


				}

			}else {
				session.put("userUniqueId", userLoginId);
				result = "firstcontact";
			}

		} catch (Exception e){

		}
		return result;
	}

	/**
	 * レスポンス格納メソッド
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * リクエスト格納メソッド
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	/**
	 * セッション格納メソッド
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	/**
	 * セッション取得メソッド
	 * @return Session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

}

