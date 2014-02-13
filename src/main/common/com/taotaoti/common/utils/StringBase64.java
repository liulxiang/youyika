package com.taotaoti.common.utils;

/**
 * 非标准base64的Java实现
 */
public class StringBase64 {
	 
	// Base64编码字符表
	static char BASE64CHAR[]= "0KajD7AZcF2QnPr5fwiHRNygmupUTIXx69BWb-hMCGJo_V8Eskz1YdvL34letqSO".toCharArray();
	static byte LOW[] = { 0x0, 0x1, 0x3, 0x7, 0xF, 0x1F, 0x3F };
	static char BASE64VAL[] = {
		(char)-1,(char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1,
		(char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1,
		(char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, 37, (char) -1, (char) -1,
		0, 51, 10, 56, 57, 15, 32, 5, 46, 33, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1,
		(char) -1, 6, 34, 40, 4, 47, 9, 41, 19, 29, 42, 1, 55, 39, 21, 63,
		13, 11, 20, 62, 28, 27, 45, 35, 30, 52, 7, (char) -1, (char) -1, (char) -1, (char) -1, 44,
		(char) -1, 2, 36, 8, 53, 59, 16, 23, 38, 18, 3, 49, 58, 24, 12, 43,
		26, 61, 14, 48, 60, 25, 54, 17, 31, 22, 50, (char) -1, (char) -1, (char) -1, (char) -1, (char) -1
	};

	/**
	 * 编码函数
	 * @author 	ying
	 * @since	1.0.0
	 * @param 	in 		待编码字符串
	 * @return 	String	编码后字符串
	 */
	public static String bc_base64_enc(String in){
		
		if(in==null||in.length()<1)
		{
			return null;
		}
		byte[] inByte = in.getBytes();
		int inlen = in.getBytes().length;
		int outlen = 0;
		if(inlen%3>0){
			outlen = inlen * 8 / 6 +1;
		}else{
			outlen = inlen * 8 / 6 +0;
		}
		char[] out = new char[outlen];
		
		int l = outlen;
		byte b = 0;
		int n=0;
		int p=0;
		
		while (l> 0)
		{
			b = 0;
			if (n > 0)
			{
				if(inByte[p]<0)
				{
					b |= ((inByte[p]+256)& LOW[n]) << (6 - n);
					p++;
				}else{
					b |= (inByte[p] & LOW[n]) << (6 - n);
					p++;
				}
			}
			n = 6 - n;
			if (n > 0 && inlen > 0 )
			{
				if (p<inlen) 
				{
					if(inByte[p]<0)
					{
						b |= (inByte[p]+256) >> (8 - n);
						n = 8 - n;
					}else{
						b |= inByte[p] >> (8 - n);
						n = 8 - n;
					}
				}else if (p==inlen)
				{
					b |= 0 >> (8 - n);
					n = 8 - n;
				}
			}
			out[outlen-l] = BASE64CHAR[b];
			l--;			
		}
		
		return new String(out);
	}
	
	/**
	 * 解码函数
	 * @author 	ying
	 * @since	1.0.0
	 * @param 	in	 	待解码字符串
	 * @return	String	解码后字符串
	 */
	public static String bc_base64_dec(String in)
	{

		int inlen = in.getBytes().length;
		int outlen = 0;
		
		if(in==null || inlen<1 || (inlen * 6) % 8 >= 6)
		{
			return null;
		}
		
		byte[] inByte = in.getBytes();
		for (int i = 0; i < inlen; i++)
		{
			if (inByte[i] > 127 || BASE64VAL[inByte[i]] == (char)-1)
			{
				return null;
			}
		}
		
		outlen = inlen * 6 / 8;
		char[] out = new char[outlen];
		byte[] outbyte = new byte[outlen];
		
		int l = outlen;
		int n=0;
		int p=0;
		
		while (l > 0)
		{
			if (n > 0)
			{
				out[outlen-l] |= (BASE64VAL[in.charAt(p)] & LOW[n]) << (8 - n);
				p++;
			}
			n = 8 - n;
			if (n >= 6)
			{
				out[outlen-l] |= BASE64VAL[in.charAt(p)] << (n - 6);
				n -= 6;
				p++;
			}
			if (n > 0)
			{
				out[outlen-l] |= BASE64VAL[in.charAt(p)] >> (6 - n);
				n = 6 - n;
			}
			l--;
		}
		for(int i=0;i<outlen;i++)
		{
			if(out[i]>127)
				outbyte[i]=(byte) (out[i]-256);
			else
				outbyte[i]=(byte) out[i];
		}
		return new String(outbyte);
		
	}
	
	 public static void main(String[] args) { 
		 
/*		
		    String a = "dddd123";
		  //  http://tc-sf-drd09.tc.baidu.com:8000/cb.php?c=IgF_pyfqn10kn1R0IZ0qn0K9ujYknjn1rjnz0Aw-5H00TAq15H00T1YknWnYPHmLrjbsnHc1PjRv0AwY5HDzrjf1rjTzPj60Thfqn0KBUHYs0ZKz5H00Iy-b5H00Uv-b5H00mv-b5H00ULI85H00IgF_5y9YIZ0lQzq9uAdYugPYQhF9pywdQhPEUHC3nj6sQvd9py38pZwVUanEUy7YugFGmysEmLF-mgw-00
		    String encode = bc_base64_enc(a);
			System.out.println("afer encode is:"+encode);

			String decode = bc_base64_dec("IgF_pyfqn10kn1R0IZ0qn0K9ujYknjn1rjnz0Aw-5H00TAq15H00T1YknWnYPHmLrjbsnHc1PjRv0AwY5HDzrjf1rjTzPj60Thfqn0KBUHYs0ZKz5H00Iy-b5H00Uv-b5H00mv-b5H00ULI85H00IgF_5y9YIZ0lQzq9uAdYugPYQhF9pywdQhPEUHC3nj6sQvd9py38pZwVUanEUy7YugFGmysEmLF-mgw-00");
			System.out.println("afer encode is:"+decode);

			String decodeA = bc_base64_dec("IgF_pyfqn101PHnL0Zws5H00myfqPfKbuHYs0ZKET1Ys0ZnqnHc1PjRvP164njDzn1fdP6KbIjYknW6YrH0zPWb10ZFb5H00mhYqn0KsTWYs0ZNGujYs0AqGujYs0APGujYs0AqLUWYs0ZNzUjdCIZwsrBtEILILQWDvnz4WUvY0");
			System.out.println("afer decode is:"+decodeA);
		
			String decodeb = bc_base64_dec("mbxnW11j9Dfmh7GuZR8mvqV");
			System.out.println("afer decode is:"+decodeb+"ff");
				
				
			
			String aa = "0001000000000000";
			String bb = "0010000000000000";
			int res = aa.compareTo(bb);
			System.out.println("afer res is:"+res);
			*/
			String test = "4294967296";
			String kk=bc_base64_enc(test);
			System.out.println(bc_base64_enc(test).length());
			System.out.println(bc_base64_dec("Ps"));
			
			Integer a = new Integer(1);
			int b=1;
			System.out.print(a.equals(b));
		
	 }
}
