import java.util.Arrays;

public class GreedyApproach {

    public static void minWalkingDistance(int[] passengers, int maxStops) {
        Arrays.sort(passengers);
        int elevator = 0;
        int stopsUsed = 0;
        int nextPassengerWalk;
        int afterNextPassengerWalk;
        int walkingDistance = 0;
        int[] stops = new int[maxStops];
        if (maxStops == passengers.length) {
            for (int i = 0; i < passengers.length; i++) {
                stops[i] = passengers[i];
            }
            printResult(walkingDistance, stops, maxStops);
        } else {
            elevator = passengers[0];
            stops[0] = elevator;
            stopsUsed++;

            for (int i = 1; i < passengers.length; i++) {
                if (stopsUsed < maxStops){
                    nextPassengerWalk = passengers[i] - elevator; //dist1=2
                    afterNextPassengerWalk = passengers[i+1] - elevator;//dist2=13
                    if (nextPassengerWalk < afterNextPassengerWalk) {
                        elevator = passengers[i+1];
                        walkingDistance += nextPassengerWalk;
                        stops[stopsUsed] = elevator;
                        stopsUsed++;
                        i++;
                    } else {
                        elevator = passengers[i];
                        stops[stopsUsed] = elevator;
                        stopsUsed++;
                    }
                }else{
                    nextPassengerWalk = passengers[i] - elevator; //dist1=2
                    walkingDistance += nextPassengerWalk;
                }
            }
            printResult(walkingDistance, stops, maxStops);
        }
    }

    public static void printResult(int walkingDistance, int[] stops, int maxStops) {
        System.out.println("While using " + maxStops + " stops, the stops are: ");
        for (int i = 0; i < maxStops; i++) {
            System.out.print(stops[i] + " ");
        }
        System.out.println("\nwith walking distance of " + walkingDistance + " floors");
    }

    public static void main(String[] args) {
        int k = 2;
        int[] passengers = {6, 8, 12,14};
        minWalkingDistance(passengers, k);
    }
}