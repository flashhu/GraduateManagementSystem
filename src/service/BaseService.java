package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����ˣ�ѧ���˵�ͨ�÷���
 * */
public class BaseService {
  /**
   * �ж������ַ����Ƿ�Ϊ�ֻ���
   * */
  public static boolean isMobile(final String str) {
	Pattern p = null;
	Matcher m = null;
	boolean b = false;
	p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // ��֤�ֻ���
	m = p.matcher(str);
	b = m.matches();
	return b;
  }
}
