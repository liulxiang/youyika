package com.taotaoti.common.email;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 * 邮件发送辅助类
 * 
 * @version 1.0.0
 */
public class MailUtils {

	private static final Logger log = LoggerFactory.getLogger(MailUtils.class);
	// email中会出现以逗号分隔的多个email情况
	//'[:blank:],，:;；'
	private final static String EMAIL_SEPRATOR = "[\\s,，:：;；]";

	private final static String emailPattern="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

	/**
	 * 以文档的形式发送邮件正文
	 * 
	 * @param from
	 *            发送邮箱
	 * @param to
	 *            接受邮箱
	 * @param text
	 *            正文
	 * @throws InternalException
	 */
	public static void sendMail(String from, String to, String text)
			{

		JavaMailSender mailSender = ServiceLocator.getInstance()
				.getJavaMailSender();

		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "GBK");

			messageHelper.setFrom(new InternetAddress(from));
			messageHelper.setTo(getAddress(to));
			messageHelper.setText(text);
			mimeMessage = messageHelper.getMimeMessage();
			mailSender.send(mimeMessage);
		} catch (Exception ex) {
			log.error("Send mail from " + from + " to " + to
					+ " failed,because " + ex.getMessage());
		}
	}

	/**
	 * 以文档的形式发送邮件正文和标题
	 * 
	 * @param from
	 *            发送邮箱
	 * @param to
	 *            接受邮箱
	 * @param title
	 *            标题
	 * @param text
	 *            正文
	 * @throws InternalException
	 */
	public static void sendMail(String from, String to, String title,
			String text)  {
		JavaMailSender mailSender = ServiceLocator.getInstance()
				.getJavaMailSender();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "GBK");

			messageHelper.setFrom(new InternetAddress(from));
			messageHelper.setTo(getAddress(to));
			messageHelper.setSubject(title);
			messageHelper.setText(text);
			mimeMessage = messageHelper.getMimeMessage();
			mailSender.send(mimeMessage);

		} catch (Exception ex) {
			log.error("Send mail from " + from + " to " + to
					+ " failed,because " + ex.getMessage());
			
		}
	}

	/**
	 * 以html的形式发送邮件正文和标题
	 * 
	 * @param from
	 *            发送邮箱
	 * @param to
	 *            接受邮箱
	 * @param title
	 *            标题
	 * @param text
	 *            正文
	 * @throws InternalException
	 *             升级兼容：接受邮箱会有以逗号分隔的多个地址情况
	 */
	public static void sendHtmlMail(String from, String to, String title,
			String text)  {
		JavaMailSender mailSender = ServiceLocator.getInstance()
				.getJavaMailSender();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "GBK");

			messageHelper.setFrom(new InternetAddress(from));
			messageHelper.setSubject(title);
			messageHelper.setText(text, true);

			messageHelper.setTo(getAddress(to));
			mimeMessage = messageHelper.getMimeMessage();
			mailSender.send(mimeMessage);

		} catch (Exception ex) {
			log.error("Send mail from " + from + " to " + to
					+ " failed,because " + ex.getMessage());
		}
	}

	/**
	 * 以html的形式发送邮件正文和标题，接受人为列表，并以抄送方式
	 * 
	 * @param from
	 *            发送邮箱
	 * @param tos
	 *            接受人为列表
	 * @param title
	 *            标题
	 * @param text
	 *            正文
	 * @throws InternalException
	 */
	public static void sendHtmlMailInBcc(String from, List tos, String title,
			String text) {
		JavaMailSender mailSender = ServiceLocator.getInstance()
				.getJavaMailSender();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "GBK");

			messageHelper.setFrom(new InternetAddress(from));

			if (tos == null || tos.size() == 0) {
				return;
			} else {
				Iterator it = tos.iterator();
				String tempMailAddress = "";
				while (it.hasNext()) {
					tempMailAddress = it.next().toString();
					try {
						messageHelper.addBcc(new InternetAddress(
								tempMailAddress));
					} catch (AddressException ae) {
						log.error("Format mail address:" + tempMailAddress
								+ " failed ,because " + ae.getMessage());
					}
				}
			}

			messageHelper.setSubject(title);
			messageHelper.setText(text, true);
			mimeMessage = messageHelper.getMimeMessage();
			mailSender.send(mimeMessage);

		} catch (Exception ex) {
			log.error("Send mail from " + from + " to " + tos
					+ " failed,because " + ex.getMessage());
		}
	}

	/**
	 * 以文本的形式发送邮件正文和标题，接受人为列表，并以抄送方式
	 * 
	 * @param from
	 *            发送邮箱
	 * @param tos
	 *            接受人列表
	 * @param title
	 *            标题
	 * @param text
	 *            正文
	 * @throws InternalException
	 */
	public static void sendMailInBcc(String from, List tos, String title,
			String text) {
		JavaMailSender mailSender = ServiceLocator.getInstance()
				.getJavaMailSender();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "GBK");

			messageHelper.setFrom(new InternetAddress(from));

			if (tos == null || tos.size() == 0) {
				return;
			} else {
				Iterator it = tos.iterator();
				String tempMailAddress = "";
				while (it.hasNext()) {
					tempMailAddress = it.next().toString();
					try {
						messageHelper.addBcc(new InternetAddress(
								tempMailAddress));
					} catch (AddressException ae) {
						log.error("Format mail address:" + tempMailAddress
								+ " failed ,because " + ae.getMessage());
					}
				}
			}

			messageHelper.setSubject(title);
			messageHelper.setText(text);
			mimeMessage = messageHelper.getMimeMessage();
			mailSender.send(mimeMessage);

		} catch (Exception ex) {
			log.error("Send mail from " + from + " to " + tos
					+ " failed,because " + ex.getMessage());
		}
	}

	/**
	 * 以文本的形式发送邮件正文和标题，接受人为列表
	 * 
	 * @param from
	 *            发送邮箱
	 * @param tos
	 *            接受人列表
	 * @param title
	 *            标题
	 * @param text
	 *            正文
	 * @throws InternalException
	 */
	public static void sendMail(String from, List tos, String title, String text)
			{
		JavaMailSender mailSender = ServiceLocator.getInstance()
				.getJavaMailSender();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "GBK");

			messageHelper.setFrom(new InternetAddress(from));

			if (tos == null || tos.size() == 0) {
				return;
			} else {
				Iterator it = tos.iterator();
				String tempMailAddress = "";
				while (it.hasNext()) {
					tempMailAddress = it.next().toString();
					try {
						messageHelper
								.addTo(new InternetAddress(tempMailAddress));
					} catch (AddressException ae) {
						log.error("Format mail address:" + tempMailAddress
								+ " failed ,because " + ae.getMessage());
					}
				}
			}

			messageHelper.setSubject(title);
			messageHelper.setText(text);
			mimeMessage = messageHelper.getMimeMessage();
			mailSender.send(mimeMessage);

		} catch (Exception ex) {
			log.error("Send mail from " + from + " to " + tos
					+ " failed,because " + ex.getMessage());
		}
	}

	/**
	 * 以文本的形式发送邮件正文和标题，和附件
	 * 
	 * @param from
	 *            发送邮箱
	 * @param to
	 *            接受邮箱
	 * @param title
	 *            标题
	 * @param text
	 *            正文
	 * @param fileName
	 *            附件显示名字
	 * @param filePath
	 *            附件文件路径
	 * @throws InternalException
	 */
	public static void sendMail(String from, String to, String title,
			String text, String fileName, String filePath)
			{
		JavaMailSender mailSender = ServiceLocator.getInstance()
				.getJavaMailSender();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "GBK");

			messageHelper.setFrom(new InternetAddress(from));
			messageHelper.setTo(getAddress(to));
			messageHelper.setSubject(title);
			messageHelper.setText(text);
			messageHelper.addAttachment(fileName, new File(filePath));
			mimeMessage = messageHelper.getMimeMessage();
			mailSender.send(mimeMessage);

		} catch (Exception ex) {
			log.error("Send mail from " + from + " to " + to
					+ " failed,because " + ex.getMessage());
		}
	}

	/**
	 * 获得to对于email接受人
	 * @param to 各个接受人之间以','分隔
	 * @return
	 * @throws AddressException
	 */
	private static InternetAddress[] getAddress(String to)
			throws AddressException {
		if (to == null) {
			return new InternetAddress[0];
		}
		String[] oneToEmails = to.split(EMAIL_SEPRATOR);
//		InternetAddress[] result = new InternetAddress[oneToEmails.length];
		List<InternetAddress> result = new ArrayList<InternetAddress>(oneToEmails.length);
		for (String add : oneToEmails) {
			if(!StringUtils.isBlank(add)){
				result.add(new InternetAddress(add));
			}
		}
		return result.toArray(new InternetAddress[0]);

	}

	public static boolean checkEmail(String email){
		if(email==null)
			return false;
		
		Matcher isEmail;
		Pattern pattern = Pattern.compile(emailPattern); 
		isEmail = pattern.matcher(email);
		if(isEmail.matches()){
			return true;
		}else
			return false;
				


	}

	public static void main(String[] args) {

		String content = "中文测试";
		String from = "zhangpeng@baidu.com";
		String to = "zhangpeng@baidu.com,zengyunfeng@baidu.com;a@b.co，,zen@b.c；a@c.c o@c.c\ta@c";
		String[] oneToEmails = to.split(EMAIL_SEPRATOR);
		System.out.println(oneToEmails.length);
		System.out.println(ArrayUtils.toString(oneToEmails));
//		try {
//			MailUtils.sendHtmlMail(from, to, "testing", content);
//		} catch (InternalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
