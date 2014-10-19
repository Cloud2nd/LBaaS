package com.exactsix.mibaas.lecture.util;

import java.util.UUID;

public class LectureUtil {

	public static String getLectureKey(String lectureCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("lecture::");
		sb.append(lectureCode);
		return sb.toString();
	}

	public static String getChapterKey(String lectureCode, String chapterCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("lecture::");
		sb.append(lectureCode);
		sb.append("::chapter::");
		sb.append(chapterCode);
		return sb.toString();
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

}
