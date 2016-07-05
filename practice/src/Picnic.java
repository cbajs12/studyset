import java.util.Scanner;
import java.util.StringTokenizer;

public class Picnic {
    int n;
    boolean[][] areFriends = new boolean[10][10];
    public int findWays(String firstLine, String secondLine){
        StringTokenizer st = new StringTokenizer(firstLine, " ");
        int students = Integer.parseInt(st.nextToken());
        int relations = Integer.parseInt(st.nextToken());
        int[][] relationArray = new int[relations][2];
        String[] secondConditions = secondLine.split(" ");
        for(int i = 0; i < relations; ++i){
            for(int j = 0; j < secondConditions.length; j+=2) {
                relationArray[i][0] = Integer.parseInt(secondConditions[j]);
                relationArray[i][1] = Integer.parseInt(secondConditions[j + 1]);
            }
//            System.out.print(relationArray[i][0]+" ");
//            System.out.println(relationArray[i][1]);
        }
        return 0;
    }

    public int countPairings(boolean[] taken){
        int firstFree = -1;
        for(int i = 0; i < n; ++i){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }

        if(firstFree == -1) return 1;
        int ret = 0;

        for(int pairWith = firstFree+1; pairWith < n; ++pairWith){
            if(!taken[pairWith] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairings(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }

    public void picnicMain(){
        Scanner sc = new Scanner(System.in);
        int totalCount = sc.nextInt();
        int[] resultArray = new int[totalCount];
        for(int i = 0; i < totalCount; i++) {
            Scanner sc1 = new Scanner(System.in);
            String firstLine = sc1.nextLine();
            //System.out.println(firstLine);
            Scanner sc2 = new Scanner(System.in);
            String secondLine = sc2.nextLine();
            //System.out.println(secondLine);
            Picnic picnic = new Picnic();
            int result = picnic.findWays(firstLine, secondLine);
//            System.out.println(result);

            resultArray[i] = result;

            sc1.close();
            sc2.close();
        }
        sc.close();

//        for(int i : resultArray){
//            System.out.println(i);
//        }
    }
}