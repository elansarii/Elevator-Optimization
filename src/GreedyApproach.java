import java.util.Arrays;

public class GreedyApproach {

    public static void minWalkingDistance(int[] passengers, int maxStops) {
        Arrays.sort(passengers);
        int elevator;//The floor the elevator at
        int stopsUsed = 0;//The stopped used
        int nextPassengerWalk; //Walked floors for the next passenger from the floor the elevator at
        int afterNextPassengerWalk;//Walked floors for the after next passenger from the floor the elevator at
        int walkingFloors = 0;//Total walked floors
        int[] stops = new int[maxStops];


        //if the max stops allowed is equal to the number of passengers deliver each one to their floor
        if (maxStops == passengers.length) {
            for (int i = 0; i < passengers.length; i++) {
                stops[i] = passengers[i];
            }
            printResult(walkingFloors, stops, maxStops);//print results
        }

        //if the max stops allowed is less than the number of passengers
        //if the max stops allowed is less than the number of passengers
        else {
            //go to the first passenger floor
            elevator = passengers[0];
            stops[0] = elevator;
            stopsUsed++;
            //iterate on passengers until the max stops is reached
            for (int i = 1; i < passengers.length; i++) {
                if (stopsUsed < maxStops){
                    //compare the two next passengers and choose the one the results in less walking distance
                    nextPassengerWalk = passengers[i] - elevator;
                    if (i+1 < passengers.length) {
                        afterNextPassengerWalk = passengers[i+1] - elevator;
                        if (nextPassengerWalk < afterNextPassengerWalk) {
                            elevator = passengers[i+1];
                            walkingFloors += nextPassengerWalk;
                            stops[stopsUsed] = elevator;
                            stopsUsed++;
                            i++;
                        } else {
                            elevator = passengers[i];
                            stops[stopsUsed] = elevator;
                            stopsUsed++;
                        }
                    }
                    else{
                        elevator = passengers[i];
                        stops[stopsUsed] = elevator;
                        stopsUsed++;
                    }
                }
                else{
                    nextPassengerWalk = passengers[i] - elevator;
                    walkingFloors += nextPassengerWalk;
                }
            }
            printResult(walkingFloors, stops, maxStops); //print results
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
        int k = 3;//max stops allowed
        int[] passengers = {27,40,60,61};
        minWalkingDistance(passengers, k);
    }
}