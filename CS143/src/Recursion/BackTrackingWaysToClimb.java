package Recursion;

/**
 *
 * @author robert
 */
public class BackTrackingWaysToClimb {

    public static void main(String[] args) {
        BackTrackingWaysToClimb solution = new BackTrackingWaysToClimb();
        solution.waysToClimb(3);
    }

    public void waysToClimb(int targetSteps) {
        if (targetSteps > 0) {
            waysToClimb(targetSteps, 0, "");
        }
    }

    public void waysToClimb(int targetSteps, int walkedSteps, String path) {
        if (walkedSteps == targetSteps) {
            System.out.println("[" + path + "]");
        }

        if (walkedSteps + 1 <= targetSteps) {
            String pa = (walkedSteps + 1 == targetSteps) ? path + "1" : path + "1, ";
            waysToClimb(targetSteps, walkedSteps + 1, pa);
        }

        if (walkedSteps + 2 <= targetSteps) {
            String pa = (walkedSteps + 2 == targetSteps) ? path + "2" : path + "2, ";
            waysToClimb(targetSteps, walkedSteps + 2, pa);
        }

    }

}
