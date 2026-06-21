class Solution {

    private Map<Integer,List<Integer>> prereqHash;

    private Set<Integer> checked;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //add all courses to hashmap
        prereqHash = new HashMap<>();
        checked = new HashSet<>();

        for(int i = 0; i < numCourses; i++){
            prereqHash.put(i,new ArrayList());
        }

        //add prerequisite courses to arraylist associated with course
        for(int i = 0; i < prerequisites.length; i++){
            prereqHash.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!search(i)) return false;
        }

        return true;
    }

    //returns true if valid false if not
    private boolean search(int course){

        if(prereqHash.get(course).isEmpty()) return true;

        if(checked.contains(course)) return false;

        checked.add(course);

        for(int c: prereqHash.get(course)){
            if(!search(c)) return false;
        }
        checked.remove(course);
        return true;
    }
}

// need a set for all impossible courses
// find loops and if loop 