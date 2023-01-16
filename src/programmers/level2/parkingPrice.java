package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class parkingPrice {
    public static void main(String[] args) {
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] fees = {180, 5000, 10, 600};
        System.out.println(Arrays.toString(solution(fees,records)));
    }
    public static int[] solution(int[] fees, String[] records) {
        Map<String,String> parkingMap = new HashMap<>();
        TreeMap<String,Integer> priceMap = new TreeMap<>();


        int baseTime = fees[0];
        int basePrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];

        for(int i = 0;i<records.length;i++) {
            String[] record = records[i].split(" ");

            String time = record[0];
            String carNumber = record[1];
            boolean parking = record[2].equals("IN") ? true : false;

            if(parking) {
                parkingMap.put(carNumber,time);
                continue;
            }
            String[] inTime = parkingMap.get(carNumber).split(":");
            int inHour = Integer.parseInt(inTime[0],10);
            int inMin = Integer.parseInt(inTime[1],10);
            String[] outTime = time.split(":");
            int outHour = Integer.parseInt(outTime[0],10);
            int outMin = Integer.parseInt(outTime[1],10);

            int parkingTime = (((outHour-inHour)*60)+(outMin-inMin));
            parkingMap.remove(carNumber);
            priceMap.put(carNumber,priceMap.getOrDefault(carNumber,0)+parkingTime);
        }
        for(Map.Entry<String,String> entry : parkingMap.entrySet()) {
            String carNumber = entry.getKey();
            String[] inTime = entry.getValue().split(":");
            int inHour = Integer.parseInt(inTime[0],10);
            int inMin = Integer.parseInt(inTime[1],10);
            int parkingTime = (((23-inHour)*60)+(59-inMin));
            priceMap.put(carNumber,priceMap.getOrDefault(carNumber,0)+parkingTime);
        }
        int[] answer = new int[priceMap.size()];
        int idx = 0;
        for(Map.Entry<String,Integer> entry : priceMap.entrySet()) {
            int sumOfParkingTime = entry.getValue();
            if(sumOfParkingTime <= baseTime) {
                answer[idx++] = basePrice;
                continue;
            }
            answer[idx++] = basePrice + (int)(Math.ceil((double)(sumOfParkingTime-baseTime)/unitTime))*unitPrice;
        }
        return answer;
    }
}
