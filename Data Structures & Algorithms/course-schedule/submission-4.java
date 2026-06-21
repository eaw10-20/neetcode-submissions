class Solution {

    private Map<Integer,List<Integer>> prereqHash;

    private Set<Integer> checked;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //hash that contains all prerequisites
        prereqHash = new HashMap<>();
        //while in loop keeps passed courses to determine if already covered
        checked = new HashSet<>();

        //add all courses to hash
        for(int i = 0; i < numCourses; i++){
            prereqHash.put(i,new ArrayList());
        }

        //update all courses that have prerequisites in hash
        for(int i = 0; i < prerequisites.length; i++){
            prereqHash.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //for each course find if there are loops that make course imposible to take
        for(int i = 0; i < numCourses; i++){
            if(!search(i)) return false;
        }

        // if no loops we can say all courses are possible
        return true;
    }

    //returns true if valid false if not
    private boolean search(int course){

        // if this course has no prerequisites (or was previously determined to be possible)
        if(prereqHash.get(course).isEmpty()) return true;

        // if course is in our loop check then it's impossible to do prerequisites
        if(checked.contains(course)) return false;

        // add course to loop check
        checked.add(course);

        // check prerequisites for if they're possible
        for(int c: prereqHash.get(course)){
            if(!search(c)) return false;
        }

        // clear loo check
        checked.remove(course);

        // update hash so that we don't repeat checks
        prereqHash.put(course,new ArrayList());

        // no issues found
        return true;
    }
}