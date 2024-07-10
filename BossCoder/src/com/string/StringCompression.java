package com.string;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int compress = compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'});
		
		System.out.println(compress);
	}

	public static int compress(char[] chars) {
		int length = chars.length;
		if (length == 1) {
			return 1;
		}

		int ans = 0;

		for (int i = 0; i < length;) {
			final char letter = chars[i];
			int count = 0;
			
			while (i < length && chars[i] == letter) {
				++i;
				++count;
			}

			chars[ans++] = letter;

			if (count > 1) {
				for (char s : String.valueOf(count).toCharArray()) {
					chars[ans++] = s;
				}
			}

		}

		return ans;
	}

}
