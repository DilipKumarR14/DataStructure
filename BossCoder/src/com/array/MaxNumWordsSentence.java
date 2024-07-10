package com.array;

public class MaxNumWordsSentence {

	public static void main(String[] args) {
		String[] sentences = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };

		mostWordsFound(sentences);

	}

	public static int mostWordsFound(String[] sentences) {
         int maxLen = 0;
         int senlen = sentences.length;
         for(int i=0;i<senlen;i++){
        	 String[] split = sentences[i].split(" ");

         }
         
         return maxLen;
    }
}
