/**
 * 下午08:21:20
 * @author zengyunfeng
 * @version 1.1.0
 */
package com.taotaoti.common.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author zengyunfeng
 * 
 */
public class UrlParser {
	
	private static Log LOG = LogFactory.getLog(UrlParser.class);
	
//	(	(?<=/|\\.|=)
//		(?:(?!/|\\.|=).)+
//		(\\.(com|cn|net|org|biz|info|cc|tv|mobi|asia|me|gov|hk|cc|name|la|jp))+
//	)|
//	(\\d+\\.\\d+\\.\\d+\\.\\d+)
	private static final String[] URL_IGNORE_SUFFIX = new String[] { "ac.",
			"ah.", "bj.", "co.", "com.", "cq.", "ed.", "edu.", "fj.", "gd.",
			"go.", "gov.", "gs.", "gx.", "gz.", "ha.", "hb.", "he.", "hi.",
			"hk.", "hl.", "hn.", "jl.", "js.", "jx.", "ln.", "mo.", "ne.",
			"net.", "nm.", "nx.", "or.", "org.", "pe.", "qh.", "sc.", "sd.",
			"sh.", "sn.", "sx.", "tj.", "tw.", "www.", "xj.", "xz.", "yn.",
			"zj." };
	
	public static final String[] URL_GLOBAL_SUFFIX = new String[] { "aero",
			"asia", "biz", "cat", "com", "coop", "edu", "gov", "info", "int",
			"jobs", "mil", "mobi", "museum", "name", "net", "org", "pro",
			"tel", "travel" };
	
	public static final String[] URL_COUNTRY_SUFFIX = new String[] { "ac",
			"ad", "ae", "af", "ag", "ai", "al", "am", "an", "ao", "aq", "ar",
			"as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf",
			"bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bv",
			"bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck",
			"cl", "cm", "cn", "co", "cr", "cu", "cv", "cx", "cy", "cz", "de",
			"dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "er", "es", "et",
			"eu", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge",
			"gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs",
			"gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id",
			"ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm",
			"jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw",
			"ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu",
			"lv", "ly", "ma", "mc", "md", "me", "mg", "mh", "mk", "ml", "mm",
			"mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx",
			"my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np",
			"nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl",
			"pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs",
			"ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj",
			"sk", "sl", "sm", "sn", "so", "sr", "st", "su", "sv", "sy", "sz",
			"tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to",
			"tp", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "uk", "us", "uy",
			"uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye",
			"yt", "yu", "za", "zm", "zw" };
	
	
	public static final String[] URL_KNOWN_LEVEL2_SUFFIX = new String[] {
			"ac.cn", "ac.il", "ac.kr", "ac.nz", "ac.uk", "ad.jp", "ah.cn",
			"bj.cn", "busan.kr", "chungbuk.kr", "chungnam.kr", "club.tw",
			"co.il", "co.jp", "co.kr", "co.nz", "co.uk", "com.cn", "com.hk",
			"com.tw", "cq.cn", "cri.nz", "daegu.kr", "daejeon.kr", "ebiz.tw",
			"ed.jp", "edu.cn", "edu.hk", "edu.tw", "es.kr", "fj.cn", "game.tw",
			"gangwon.kr", "gd.cn", "geek.nz", "gen.nz", "go.jp", "go.kr",
			"gov.cn", "gov.hk", "gov.il", "gov.tw", "gov.uk", "govt.nz",
			"gr.jp", "gs.cn", "gwangju.kr", "gx.cn", "gyeongbuk.kr",
			"gyeonggi.kr", "gyeongnam.kr", "gz.cn", "ha.cn", "hb.cn", "he.cn",
			"hi.cn", "hl.cn", "hn.cn", "hs.kr", "idf.il", "idv.hk", "idv.tw",
			"incheon.kr", "iwi.nz", "jeju.kr", "jeonbuk.kr", "jeonnam.kr",
			"jl.cn", "js.cn", "jx.cn", "k12.il", "kg.kr", "lg.jp", "ln.cn",
			"ltd.uk", "maori.nz", "me.uk", "mil.kr", "mil.nz", "mil.tw",
			"mod.uk", "ms.kr", "muni.il", "ne.jp", "ne.kr", "net.cn", "net.hk",
			"net.il", "net.nz", "net.tw", "net.uk", "nhs.uk", "nic.uk",
			"nm.cn", "nx.cn", "or.jp", "or.kr", "org.cn", "org.hk", "org.il",
			"org.nz", "org.tw", "org.uk", "parliament.nz", "parliament.uk",
			"pe.kr", "plc.uk", "qh.cn", "re.kr", "sc.cn", "sc.kr", "sch.uk",
			"sd.cn", "seoul.kr", "sh.cn", "sn.cn", "sx.cn", "tj.cn", "tw.cn",
			"ulsan.kr", "xj.cn", "xz.cn", "yn.cn", "zj.cn" };

	public static final String[] URL_KNOWN_2ND_SUFFIX = new String[] { "co",
			"com", "edu", "gov", "net", "org" };
	
	
	private static final Pattern IP4PATTERN = Pattern
			.compile(
					"^(([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))\\."
							+ "((0)|([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))\\."
							+ "((0)|([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))\\."
							+ "((0)|([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))$",
					Pattern.CASE_INSENSITIVE);

	private static final Pattern IP6PATTERN = Pattern
			.compile(
					"^(^::$)|(^([\\d|a-fA-F]{1,4}:){7}([\\d|a-fA-F]{1,4})$)" +
					"|(^(::(([\\d|a-fA-F]{1,4}):){0,5}([\\d|a-fA-F]{1,4}))$)" +
					"|(^(([\\d|a-fA-F]{1,4})(:|::)){0,6}([\\d|a-fA-F]{1,4})$)$",
					Pattern.CASE_INSENSITIVE);
	
	private static final Pattern DOMAIN_PATTERN = Pattern.compile("^(\\w+:\\/\\/)?([^\\/:\\?]+).*", Pattern.CASE_INSENSITIVE);

	@Deprecated
	private static String getMainDomainFromDomain(final String domain){
		if(domain == null){
			return null;
		}
		String mainDomain = null;
		int  last = domain.lastIndexOf('.');
		int begin = -1;
		while (last != -1){
			begin = domain.lastIndexOf('.', last-1);
			if(begin == -1){
				break ;
			}
			if(Arrays.binarySearch(URL_IGNORE_SUFFIX,domain.substring(begin+1, last+1))>=0){
				last = begin;
			}else{
				break;
			}
		}
		mainDomain = domain.substring(begin+1);
		return mainDomain;
	}
	/**
	 * 根据url获得主域 ^http:\/\/([^\/]+)\/.*$
	 * 
	 * @author zengyunfeng
	 * @version 1.1.0
	 * @param url
	 * @return
	 */
	@Deprecated
	public static String getMainDomain(final String urlAddress) {
		if (urlAddress == null) {
			return null;
		}
		String url = urlAddress.toLowerCase();
		String domain = null;
		Matcher matcher = DOMAIN_PATTERN.matcher(url);
		if(matcher.find()){
			domain = matcher.group(2);
		}
		if(!IP4PATTERN.matcher(domain).matches() && !IP6PATTERN.matcher(domain).matches()){
			domain = getMainDomainFromDomain(domain);
			
		}
		return domain;
	}

	
	/**
	 * 根据url获得站点site,即?, :, \之前,://(如何存在)之后的数据
	 * @author zengyunfeng
	 * @param urlAddress
	 * @return
	 */
	public static String parseUrl(final String urlAddress){
		if (urlAddress == null) {
			return null;
		}
		String url = urlAddress.toLowerCase();
		String domain = null;
		Matcher matcher = DOMAIN_PATTERN.matcher(url);
		if(matcher.find()){
			domain = matcher.group(2);
		}
		return domain;
	}
	
	/**
	 * 一个站点是否为IP
	 * @author zengyunfeng
	 * @param site
	 * @return
	 */
	public static boolean isIp(final String site){
		if(IP4PATTERN.matcher(site).matches() || IP6PATTERN.matcher(site).matches()){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据站点获得一级域名
	 * @author zengyunfeng
	 * @param site: 必须为site格式
	 * @return
	 */
	public static String fetchMainDomain(final String site){
		return getMainDomainFromDomain(site);
	}
	
	/**
	 * 根据站点获得二级域名
	 * @author zengyunfeng
	 * @param site: 必须为site格式
	 * @return
	 */
	public static String fetchSecondDomain(final String site){
		if(site == null){
			return null;
		}
		int  last = site.lastIndexOf('.');
		int begin = -1;
		while (last != -1){
			begin = site.lastIndexOf('.', last-1);
			if(begin == -1){
				break ;
			}
			if(Arrays.binarySearch(URL_IGNORE_SUFFIX,site.substring(begin+1, last+1))>=0){
				last = begin;
			}else{
				break;
			}
		}
		if(begin==-1){
			//为一级域名
			return null;
		}
		begin = site.lastIndexOf('.', begin-1);
		return site.substring(begin+1);
	}
	
	/**
	 * 根据业务部门与COM组讨论后的处理原则修改
	 * @author zhuqian
	 * @version 1.2.5
	 * 
	 * @param urlAddress
	 * @return
	 */
	public static String getMainDomainUpdatedRules(final String urlAddress) {
		if (urlAddress == null) {
			return null;
		}
		String url = urlAddress.toLowerCase();
		String domain = null;
		Matcher matcher = DOMAIN_PATTERN.matcher(url);
		if(matcher.find()){
			domain = matcher.group(2);
		}else{
			return urlAddress; //如果match不到，则程序无法处理，原样返回给用户 added @1.2.13
		}
		
		//如果满足IP地址规则，则按IP地址返回
		if(IP4PATTERN.matcher(domain).matches() || IP6PATTERN.matcher(domain).matches()){
			return domain;
		}
		
		//先按COM组规则截取主域，如果截取失败，使用业务部分的补充规则截取
		String mainDomain = getMainDomainComStandard(domain);
		if(mainDomain == null){
			mainDomain = getMainDomainAdditionRules(domain);
		}
		
		//如果还截取不到，就是非常特殊的情况的，需要打WARNING日志
		if(mainDomain == null){
			LOG.warn("无法提取主域：URL='" + domain + "'");
		}
		
		return mainDomain;
	}
	
	/**
	 * COM组的主域切割规则。如果不符合规则，则返回NULL
	 * 
	 * @param domain
	 * @return null - 不满足COM组主域切割规则
	 */
	private static String getMainDomainComStandard(final String domain){
		
		if(domain == null){
			return null;
		}
		
		String[] digits = domain.split("\\.");
		int length = digits.length;
		
		//如果按点分隔后不足两位，则返回错误
		if(length < 2){
			return null;
		}
		
		String lastDigit = digits[length-1];
		String last2Digits = digits[length-2]+"."+digits[length-1];
				
		//如果以国际通用域名结尾，则将倒数第二节开始的部分作为域名
		if(Arrays.binarySearch(URL_GLOBAL_SUFFIX, lastDigit) >= 0){
			return last2Digits;
		}
		
		//如果不是以国家域名结尾的，则返回错误
		if(Arrays.binarySearch(URL_COUNTRY_SUFFIX, lastDigit) < 0){
			return null;
		}
		
		//如果其国家二级域名是我们所熟知的，则返回倒数第三节开始的部分作为域名
		if(Arrays.binarySearch(URL_KNOWN_LEVEL2_SUFFIX, last2Digits) >= 0 || 
				Arrays.binarySearch(URL_KNOWN_2ND_SUFFIX, digits[length-2]) >= 0){
			
			if(length < 3){
				return null; //如果只有两位，则返回错误(补充规则中会捕获处理)
			}
			return digits[length-3]+"."+last2Digits;
		}
		//否则，返回最后两位
		return last2Digits;
	}

	/**
	 * 在COM组的主域切割规则上，增加业务系统的补充规则，如果域名不符合COM组规则，使用此规则检查
	 * 
	 * @param domain
	 * @return null - 不满足补充规则
	 */
	private static String getMainDomainAdditionRules(String domain){
		if(domain == null){
			return null;
		}
		
		String[] digits = domain.split("\\.");
		int length = digits.length;
		
		//如果域名在两级以上，则取最后两级为主域
		if(length >= 2){
			return digits[length-2] + "." + digits[length-1];
		}
		//如果域名只有本身，则返回本身
		if(length == 1){
			return domain;			
		}

		return null;
	}
	
	/**
	 * 根据key从url参数中获取value
	 * 例如	url=http://www.baidu.com/ns/test.html?p=k&t=a			
	 * 		key=p
	 * 		output:k
	 * @param url
	 * @param key
	 * @return
	 */
	public static String getURLQueryValue(String url,String key){
		if(url==null||key==null){
			return null;
		}
		int i=url.indexOf("?");
		if(i<0){
			return null;
		}
		String query=url.substring(i+1);
		String[]	arr=query.split("&");
		if(arr==null){
			return null;
		}
		for(String s:arr){
			String[] keyvalue=s.split("=");
			if(key.equals(keyvalue[0])){
				return keyvalue[1];
			}
		}
		
		return null;
	}
	
	/**
	 * @author zengyunfeng
	 * @version 1.1.0
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMainDomain("http://321.0.0.1:8080/asdf"));
		System.out.println(getMainDomain("http://localhost:8080/asdf"));
		System.out.println(getMainDomain("http://www.baidu.com./asdf"));
		System.out.println(getMainDomain("http://www.baidu.com.cn/asdf"));
		System.out.println(getMainDomain("www.baidu.com.cn?a=c"));
		System.out.println(getMainDomain("http://www.baidu.com.ccn:8080/?a=c"));
		System.out.println(getMainDomain("http://tc-veyron.tc.baidu.com/asdf"));
		System.out.println(getMainDomain("http://10.22.240.123:8080/asdf"));
		System.out.println(getMainDomain("http://bbs.www.com.cn/index.aspx"));
		System.out.println(getMainDomain("http://bbs.wwww.com.cn/index.aspx"));
		System.out.println(getMainDomain("http://www.cn.com/"));
		System.out.println(getMainDomain("http://zhu/"));
		System.out.println(getMainDomain("www.bj.abc.cn"));
		System.out.println(getMainDomain("www.abc.bj.cn"));
		System.out.println(getMainDomain("xn--fsqu00a.xn--0zwm56d"));
		System.out.println(getMainDomain("www.com.com"));
		System.out.println(getMainDomain("www.net.edu"));
		System.out.println(getMainDomain("www.com.cn"));
		System.out.println(getMainDomain("bbs.www.com.cn"));
		
		Arrays.sort(URL_KNOWN_LEVEL2_SUFFIX);
		for(String s : URL_KNOWN_LEVEL2_SUFFIX){
			System.out.print("\""+s+"\", ");
		}
		
		
	}

}
