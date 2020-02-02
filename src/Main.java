import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        final int phase1 = 1;
        final int phase2 = 2;

        long u1Cost;
        long u2Cost;
        int phase1Rockets;
        int phase2Rockets;

        ArrayList<Item> phase1Item;
        ArrayList<Item> phase2Item;

        Simulation simulation = new Simulation();

        phase1Item = simulation.loadItems(phase1);
        phase2Item = simulation.loadItems(phase2);

        //zmiana
        //zmiana1

        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------SPACE CHALLENGE SIMULATION----------------------");
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println("-----------------------STARTING SIMULATION FOR U1-------------------\n");
        System.out.println("Simulating Phase 1");
        simulation.runSimulation(simulation.loadU1(phase1Item), 1);
        System.out.println("Simulation done.");
        phase1Rockets = U1.getRocketU1Counter();
        System.out.println("Rockets used for phase 1: " + phase1Rockets + "\n");

        System.out.println("Simulating Phase 2");
        simulation.runSimulation(simulation.loadU1(phase2Item), 1);
        phase2Rockets = U1.getRocketU1Counter() - phase1Rockets;
        System.out.println("Rockets used for phase 2: " + phase2Rockets + "\n");
        System.out.println("----------------------FINISH SIMULATION FOR U1-------------------------\n");

        u1Cost = totalCost(1);

        System.out.println("-----------------STARTING SIMULATION FOR U2-----------------------------\n");
        System.out.println("Simulation Phase 1");
        simulation.runSimulation(simulation.loadU2(phase1Item), 2);
        System.out.println("Simulation done.");
        phase1Rockets = U2.getRocketU2Counter();
        System.out.println("Rockets used for phase 1: " + phase1Rockets );

        System.out.println("Simulating Phase 2");
        simulation.runSimulation(simulation.loadU2(phase2Item), 2);
        phase2Rockets = U2.getRocketU2Counter() - phase1Rockets;
        System.out.println("Rockets used for phase 2: " + phase2Rockets);
        System.out.println("-------------FINISH SIMULATION FOR U2------------------\n");

        u2Cost = totalCost(2);



        System.out.println("\nTotal budget needed for U1: " + u1Cost);
        System.out.println("A total of " + U1.getRocketU1Counter() + " U1 rockets was used.\n");
        System.out.println("Total budget needed for U2: " + u2Cost);
        System.out.println("A total of " + U2.getRocketU2Counter() + " U2 rockets was used." + "\n");

        if (u1Cost > u2Cost){
            System.out.println("Using U2 is cheaper in this simulation.");
        } if (u1Cost < u2Cost){
            System.out.println("Using U1 is cheaper in this simulation.");
        } if (u1Cost == u2Cost){
            System.out.println("Cost is the same.");
        }

    }

    public static long totalCost(int i){return (i == 1) ? U1.getTotalCost() : U2.getTotalCost();}
}
