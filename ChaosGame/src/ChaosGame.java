import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ChaosGame {

    private final Random random = new Random();
    private final int GAME_HEIGHT;
    private final int GAME_WIDTH;
    private final int POINTS;

    public ChaosGame(int GAME_HEIGHT, int GAME_WIDTH, int POINTS) {
        this.POINTS = POINTS;
        this.GAME_HEIGHT = GAME_HEIGHT;
        this.GAME_WIDTH = GAME_WIDTH;
    }

    public ArrayList<Point<Integer,Integer>> generate(int nodes, double stepFraction){
        ArrayList<Point<Integer,Integer>> nodeList = findNodes(nodes);
        //starting point
        Point<Integer,Integer> point = randomPoint();
        int x=point.getX(); //
        int y=point.getY(); // next point

        System.out.println("Start: " + x + ", " + y);
        System.out.print("Nodes : ");
        for(Point p : nodeList){
            System.out.print("(" + p.getX() + "," + p.getY() + ") ");
        }
        System.out.println("");

        ArrayList<Point<Integer,Integer>> chaos = new ArrayList<>(nodeList);

        int xn,yn; // next random node

        //System.out.println("Next:");
        for( int i=0; i!=POINTS; i++ ){
            int nodeIndex = random.nextInt(nodes);
            //System.out.println("\tPoint : " + x + ", " + y);
            xn = nodeList.get(nodeIndex).getX();
            yn = nodeList.get(nodeIndex).getY();
            //System.out.println("\tNode : " + xn + ", " + yn);
            x = (int)(x+stepFraction*(double)(xn-x));
            y = (int)(y+stepFraction*(double)(yn-y));

            chaos.add(new Point<Integer, Integer>(x,y));
        }

        return chaos;
    }

    private ArrayList<Point<Integer,Integer>> findNodes(int nodes){

        // Parameters of a circle
        int xs = GAME_WIDTH/2;
        int ys = GAME_HEIGHT/2;
        int r = (int)(0.8*GAME_WIDTH/2);

        ArrayList<Point<Integer,Integer>> nodeList = new ArrayList<>();

        // Point on the circle
        double phi = 0;
        int x = xs + (int)(r*Math.cos(phi));
        int y = ys + (int)(r*Math.sin(phi));
        nodeList.add(new Point<Integer, Integer>(x,y));
        for( int i=0; i!= nodes-1; i++ ){
            phi += 2*Math.PI/nodes;
            x = xs + (int)(r*Math.cos(phi));
            y = ys + (int)(r*Math.sin(phi));
            nodeList.add(new Point<Integer, Integer>(x,y));
        }

        return nodeList;
    }

    private Point<Integer,Integer> randomPoint(){
        int x = (int)(random.nextDouble()*GAME_WIDTH);
        int y = (int)(random.nextDouble()*GAME_HEIGHT);
        Point<Integer,Integer> point = new Point<>(x,y);

        return point;
    }
}
