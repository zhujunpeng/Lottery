package com.example.lotorry.engine;

import com.example.lotorry.net.protocal.Message;

/**
 * �������ݴ���
 * @author Administrator
 *
 */
public interface CommonInfoEngine {
	/**
	 * ��ȡ��ǰ��������Ϣ
	 * @param integer�����ֵı�ʾ
	 * @return
	 */
	Message getCurrentIssueInfo(Integer integer);

}
