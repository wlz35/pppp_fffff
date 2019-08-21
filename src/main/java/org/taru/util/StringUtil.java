package org.taru.util;

/**
 * �ַ���������
 * @author 
 *
 */
public class StringUtil {
	/**
	 * �Ѷ���ת�����ַ���
	 * @param obj
	 * @return
	 */
	public  static String  valueOf(Object  obj){
		if(obj!=null){
			return obj.toString();
		}
		return null;
	}

}
