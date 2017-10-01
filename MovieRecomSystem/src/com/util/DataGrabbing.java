package com.util;

import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class DataGrabbing {
	public void GetUDList(Set<String> userList, Set<String> movieList){
		// read file and get list
		List<String> infoList = ReadFileUtil
				.ReadFileByLine("res/user_history.txt");

		// the number of file lines
		int size = infoList.size();

		StringTokenizer st;

		for (int i = 0; i < size; i++) {
			// remove blank lines
			if (!infoList.get(i).equals("")) {
				// split data by "\t"
				st = new StringTokenizer(infoList.get(i), "\t");
				userList.add(st.nextToken());
				movieList.add(st.nextToken());
			}
		}
	}
}
