package programmers.level2;

import java.util.*;

public class openChatRoom {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
    static class Log {
        String command,id;
        public Log (String command, String id) {
            this.command =command;
            this.id = id;
        }
    }
    public static String[] solution(String[] record) {
        List<Log> logList = new ArrayList<>();
        Map<String,String> idMap = new HashMap<>();
        for(String command : record){
            String[] splitCommand = command.split(" ");
            String id = splitCommand[1];
            if(splitCommand[0].equals("Enter")) {
                String nickname = splitCommand[2];
                if(idMap.containsKey(id)) {
                    String pastNickname = idMap.get(id);
                    if(!pastNickname.equals(nickname)) {
                        idMap.put(id,nickname);
                    }
                }
                idMap.put(id,nickname);
                logList.add(new Log("Enter",id));
                continue;
            }
            if(splitCommand[0].equals("Leave")) {
                logList.add(new Log("Leave",id));
                continue;
            }
            if(splitCommand[0].equals("Change")) {
                String nickname = splitCommand[2];
                idMap.put(id,nickname);
                continue;
            }
        }
        String[] answer = new String[logList.size()];
        int idx =0;
        for(Log log:logList) {
            if(log.command.equals("Enter")) {
                answer[idx++] = idMap.get(log.id) + "님이 들어왔습니다.";
                continue;
            }
            answer[idx++] = idMap.get(log.id) + "님이 나갔습니다.";
        }
        return answer;

    }
}
