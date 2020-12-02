    // public static void search(int j, int k, int stepUp){
    //     Queue <Point> coordQueue = new ArrayDeque<>();
    //     coordQueue.add(new Point(j,k));
    //     int [] xDir = {1,-1,0,0};
    //     int [] yDir = {0,0,1,-1};
    //     while(!coordQueue.isEmpty()){
    //         Point curr = coordQueue.poll();
    //         int currX = curr.cordX;
    //         int currY = curr.cordY;
    //         for(int i = 0; i < 4; i++){
    //             int nextX = currX + xDir[i];
    //             int nextY = currY + yDir[i];
    //             if(nextX < 0 || nextY < 0 || nextX >= rows || nextY >=columns){
    //                 continue; //Skip out of bounds
    //             } else if(coordinates[currX][currY] == coordinates[nextX][nextY]){
    //                 if(groupRank[nextX][nextY] < stepUp){
    //                     coordQueue.add(new Point(nextX, nextY));
    //                     groupRank[nextX][nextY] = stepUp;
    //                 } else {
    //                     continue;
    //                 }
    //             } else{
    //                 continue; //Conflicted zones... SKIP!
    //             }
    //         }
    //     }
    // }