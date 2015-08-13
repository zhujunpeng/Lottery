package com.example.lotorry.net;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.example.lotorry.GlobalParams;

public class NetUtil {
	/**
	 * ����û������磺�Ƿ�������
	 */
	public static boolean checkNet(Context context) {
		// �жϣ�WiFi����
		boolean isWIFI = isWIFIConnection(context);
		// �ж�mobile����
		boolean isMOBILE = isMOBILEConnection(context);

		// ���Mobile�����ӣ��ж����ĸ�APN��ѡ����
		if (isMOBILE) {
			// APN��ѡ��,�Ĵ�����Ϣ�Ƿ������ݣ������wap��ʽ
			readAPN(context);// �ж����ĸ�APN��ѡ����
		}

		if (!isWIFI && !isMOBILE) {
			return false;
		}

		return true;
	}

	/**
	 * APN��ѡ��,�Ĵ�����Ϣ�Ƿ������ݣ������wap��ʽ
	 * 
	 * @param context
	 */
	private static void readAPN(Context context) {
		Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");//4.0ģ�������ε���Ȩ��

		// ������ϵ������
		ContentResolver resolver = context.getContentResolver();
		// �ж����ĸ�APN��ѡ����
		Cursor cursor = resolver.query(PREFERRED_APN_URI, null, null, null, null);
		
		if(cursor!=null&&cursor.moveToFirst())
		{
			GlobalParams.PROXY=cursor.getString(cursor.getColumnIndex("proxy"));
			GlobalParams.PORT=cursor.getInt(cursor.getColumnIndex("port"));
		}
		

	}

	/**
	 * �жϣ�Mobile����
	 * 
	 * @param context
	 * @return
	 */
	private static boolean isMOBILEConnection(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo networkInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (networkInfo != null) {
			return networkInfo.isConnected();
		}
		return false;
	}

	/**
	 * �жϣ�WIFI����
	 * 
	 * @param context
	 * @return
	 */
	private static boolean isWIFIConnection(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo networkInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (networkInfo != null) {
			return networkInfo.isConnected();
		}
		return false;
	}
}
