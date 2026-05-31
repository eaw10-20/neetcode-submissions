class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //need to get position and speed into a single sorted array
        //int[2] [position,speed]

        int len = position.length;
        List<int[]> cars = new ArrayList<>();

        for(int i = 0; i < len; i++){
            int[] car = new int[2];
            car[0] = position[i];
            car[1] = speed[i];
            cars.add(car);
        }

        cars.sort((a,b) -> b[0] - a[0]);
        Stack<Double> fleets = new Stack();

        for(int[] car: cars){
            fleets.push(1.0*(target - car[0]) / car[1]);

            if(fleets.size() >= 2 && fleets.peek() <= fleets.get(fleets.size()-2)) fleets.pop();
        }

        return fleets.size();
    }
}
