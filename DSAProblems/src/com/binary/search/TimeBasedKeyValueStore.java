package com.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeMap timeMap = new TimeMap();

		timeMap.set("foo", "bar", 1);
		System.out.println(timeMap.get("foo", 1));
		String string = timeMap.get("foo", 3);
		System.out.println("3 key " + string);
		timeMap.set("foo", "bar2", 4);
		System.out.println("4 key " + timeMap.get("foo", 4));
		System.out.println("5 key " + timeMap.get("foo", 5));

	}

}

class TimeMap {
	Map<String, List<String>> map = new HashMap<>();

	public TimeMap() {
		this.map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		List<String> list = map.getOrDefault(key, null);
		if (list == null) {
			list = new ArrayList<>();
			map.put(key, list);
		}
		int count = list.size();
		String last = (count == 0) ? "" : list.get(count - 1);
		while (count++ < timestamp)
			list.add(last);
		list.add(value);
	}

	public String get(String key, int timestamp) {
		List<String> list = map.getOrDefault(key, null);
		if (list == null)
			return "";
		int size = list.size();
		if (timestamp < size)
			return list.get(timestamp);
		return list.get(size - 1);
	}
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */