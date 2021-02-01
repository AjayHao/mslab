package com.ajayhao.mslab.crawler.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

/**
 */
public class MailCommonUtil {
	private static Logger logger = LoggerFactory.getLogger(MailCommonUtil.class);

	public static <T extends Serializable> T clone(T obj) throws Exception {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(obj);
			bis = new ByteArrayInputStream(bos.toByteArray());
			is = new ObjectInputStream(bis);
			return (T) is.readObject();
		} catch (Exception e) {
			throw e;
		} finally {
			close(bos);
			close(os);
			close(bis);
			close(is);
		}
	}

	public static void writeObject(Object obj, String path) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(fos);
			close(oos);
		}
	}

	public static Object readObject(String path) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(fis);
			close(ois);
		}
	}

	public static void close(AutoCloseable... closeableArray) {
		if (closeableArray == null) {
			return;
		}
		if (closeableArray.length == 0) {
			return;
		}
		for (AutoCloseable closeable : closeableArray) {
			try {
				closeable.close();
			} catch (Exception e) {
			}
		}
	}

	public static String random() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getClientIp(HttpServletRequest request) {
		String ipAddress = null;
		try {
			ipAddress = request.getHeader("x-forwarded-for");
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getRemoteAddr();
				if ("127.0.0.1".equals(ipAddress)) {
					InetAddress inetAddress = null;
					try {
						inetAddress = InetAddress.getLocalHost();
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
					ipAddress = inetAddress.getHostAddress();
				}
			}
			// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
			if (ipAddress != null && ipAddress.length() > 15) {
				if (ipAddress.indexOf(",") > 0) {
					ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
				}
			}
		} catch (Exception e) {
			ipAddress="";
		}
		return ipAddress;
	}

	private static InetAddress getHostIp() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress ip = (InetAddress) addresses.nextElement();
					if (ip != null
							&& ip instanceof Inet4Address
							&& !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {
						return ip;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public static String getIp() {
		InetAddress address = getHostIp();
		if (address == null) {
			return "";
		}
		return address.getHostAddress();
	}

	public static boolean isListEmpty(List list) {
		return list == null || list.isEmpty();
	}

	public static <T> T[] filterArray(T[] array) {
		List<T> list = new ArrayList<>(array.length);
		for (T t : array) {
			if (t == null || "".equals(t.toString())) {
				continue;
			}
			list.add(t);
		}
		T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), list.size());
		list.toArray(result);
		return result;
	}
}
