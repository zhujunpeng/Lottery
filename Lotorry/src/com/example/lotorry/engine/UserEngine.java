package com.example.lotorry.engine;

import com.example.lotorry.bean.User;
import com.example.lotorry.net.protocal.Message;
/**
 * �û���ص�ҵ������Ľӿ�
 * @author Administrator
 *
 */
public interface UserEngine {
	/**
	 * �û���½
	 * @param user
	 * @return
	 */
	Message login(User user);
	/**
	 * ��ȡ�û����
	 * @param user
	 * @return
	 */
	Message getBalance(User user);
	/**
	 * �û�Ͷע
	 * @param user
	 * @return
	 */
	Message bet(User user);
}
