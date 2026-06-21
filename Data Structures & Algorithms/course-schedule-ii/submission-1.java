class Solution {
    private Map<Integer,ArrayList<Integer>> prereqMap;
    private Set<Integer> taken;
    private Set<Integer> loopCheck;
    private boolean possible;
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        prereqMap = new HashMap<>();
        taken = new HashSet<>();
        loopCheck = new HashSet<>();
        int[] order = new int[numCourses];
        possible = true;
        index = 0;

        //add prereqs to map
        for(int i = 0; i < numCourses; i++){
            prereqMap.put(i,new ArrayList());
        }

        for(int i = 0; i < prerequisites.length; i++){
            prereqMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // try to add courses in possible order
        for(int c = 0; c < numCourses; c++){
            if(taken.contains(c)) continue;
            dfs(prerequisites,c,order);
        }

        if(!possible) return new int[0];
        return order;
    }

    private void dfs(int[][] prereq, int course,int[] order){
        //check for loop
        if(prereqMap.get(course).isEmpty()){
            if(taken.contains(course)){
                return;
            }else{
                order[index] = course;
                taken.add(course);
                index++;
                return;
            }
            
        }
        if(loopCheck.contains(course)){
            possible = false;
            return;
        }
        loopCheck.add(course);
        ArrayList<Integer> courses = prereqMap.get(course);
        for(Integer c: courses){
            dfs(prereq,c,order);
            if(!possible) return;
        }
        //handle return
        order[index] = course;
        taken.add(course);
        index++;
        loopCheck.remove(course);
        prereqMap.put(course,new ArrayList());
        return;
    }
}
