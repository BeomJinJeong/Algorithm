package com.ssafy.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q05_오픈채팅방 {
	static class Person {
		int command;
		String id;
		public Person(int command, String id) {
			super();
			this.command = command;
			this.id = id;
		}		
	}
	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Person> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		StringTokenizer st = null;
		for(int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			
			String command = st.nextToken();
			String id = st.nextToken();
			String name = null;
			if(!command.equals("Leave")) {				
				name = st.nextToken();
			}
			
			if(command.equals("Enter")){
				list.add(new Person(0, id));
				map.put(id, name);
			} else if(command.equals("Leave")) {
				list.add(new Person(1, id));
			} else {
				map.put(id, name);
			}	
			
		}
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).command == 0) {
				sb.append(map.get(list.get(i).id)).append("님이 들어왔습니다");
			} else {
				sb.append(map.get(list.get(i).id)).append("님이 나갔습니다.");
			}
		}
		System.out.println(sb);
	}
}
