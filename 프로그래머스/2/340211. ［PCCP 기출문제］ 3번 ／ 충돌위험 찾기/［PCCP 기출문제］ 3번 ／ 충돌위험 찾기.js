function solution(points, routes) {
    let answer = 0;
    
    const robots = [];
    const SIZE = routes.length;
    
    for(let n = 0;n<SIZE;n++) {
        const point = points[routes[n][0]-1];
        robots.push({r:point[0],c:point[1]});
        routes[n].shift();
    }
    
    answer += collisionCheck(robots);
    
    
    while(true) {
        let restRobots = 0;
        
        for(let n = 0;n<SIZE;n++) {
            if(routes[n].length > 0) {
                const point = points[routes[n][0]-1];
              //  console.log(n, point, robots[n]);

                move(robots, point, n);

                if(robots[n].r === point[0] && robots[n].c === point[1]) {
                    routes[n].shift();
                }

                restRobots++;
                continue;
            }
            
            // 행성 벗어나기
            robots[n].r = -1;
            robots[n].c = -1;
        }
        
        answer += collisionCheck(robots);
        
        
        if(restRobots < 2) {
            break;
        }
        
    }
    
    return answer;
}

function collisionCheck (robots) {
    const pointMap = new Map();
    let cnt = 0;
    
    for(let n = 0;n<robots.length;n++) {
        if(robots[n].r < 0 || robots[n].c < 0) continue;

        const p = (robots[n].r-1) * 100 + (robots[n].c-1);

        if(pointMap.has(p) && pointMap.get(p) === 0) {
            pointMap.set(p,pointMap.get(p)+1);
            cnt++;
         //   console.log(p);
            continue;
        }

        if(!pointMap.has(p)) {
            pointMap.set(p,0);      
        }
    }
    
    return cnt;
    
}

function move(robots, nextPoint, n) {
    const current = robots[n];
    if(current.r < nextPoint[0]) {
        current.r += 1;
        return;
    }
    if(current.r > nextPoint[0]) {
        current.r -= 1;
        return;
    }
    if(current.c < nextPoint[1]) {
        current.c += 1;
        return;
    }
    if(current.c > nextPoint[1]) {
        current.c -= 1;
        return;
    }
}

