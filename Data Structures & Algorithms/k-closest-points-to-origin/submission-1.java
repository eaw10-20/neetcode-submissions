class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //ArrayList <{distance},{index}>
        //Collections.sort((a,b) -> a[0].compareTo(b[0]))

        //Get distances and put them in priority queue
        Queue<Distance> distances = 
        new PriorityQueue<Distance>((a,b) -> Double.compare(b.getDistance(),a.getDistance()));

        for(int i = 0; i < points.length; i++){
            double x = points[i][0]*points[i][0]*1.0;
            double y = points[i][1]*points[i][1]*1.0;
            double distance = Math.sqrt(x+y);
            distances.add(new Distance(i,distance));
            if(distances.size()>k) distances.poll();
        }
        
        int[][] ret = new int[k][2];
        for(int i = 0; i < k; i++){
            ret[i] = points[distances.poll().getIndex()];
        }
        return ret;
    }
}

class Distance{
    public int index;
    public double distance;

    public Distance(){

    } 

    public Distance(int i, double d){
        index = i;
        distance = d;
    }

    public int getIndex(){
        return index;
    }

    public double getDistance(){
        return distance;
    }
}
