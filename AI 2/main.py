# AI Assignment No.2(A star Alogorithm)
# Program 2 : Implement A star Algorithm for any game search problem.
from queue import PriorityQueue

class State(object):
    def __init__(self, value, parent, start=1, goal=1):
        self.children = []
        self.parent = parent
        self.value = value
        self.dist = 1
        if parent:
            self.start = parent.start
            self.goal = parent.goal
            self.path = parent.path[:]
            self.path.append(value)
        else:
            self.path = [value]
            self.start = start
            self.goal = goal
            
    def GetDistance(self):
        pass
    
    def CreateChildren(self):
        pass

class State_String(State):
    def __init__(self, value, parent, start=1, goal=1):
        super(State_String, self).__init__(value, parent, start, goal)
        self.dist = self.GetDistance()
        
    def GetDistance(self):
        if self.value == self.goal:
            return 0
        dist = 1
        for i in range(len(self.goal)):
            letter = self.goal[i]
            dist += abs(i - self.value.index(letter))
        return dist
    
    def CreateChildren(self):
        if not self.children:
            for i in range(len(self.goal) - 1):
                val = self.value
                val = val[:i] + val[i + 1] + val[i] + val[i + 2:]
                child = State_String(val, self)
                self.children.append(child)

class A_Star_Solver:
    def __init__(self, start, goal):
        self.path = []
        self.visitedQueue = []
        self.priorityQueue = PriorityQueue()
        self.start = start
        self.goal = goal
        
    def Solve(self):
        startState = State_String(self.start, 0, self.start, self.goal)
        count = 1
        self.priorityQueue.put((0, count, startState))
        while not self.path and self.priorityQueue.qsize():
            closestChild = self.priorityQueue.get()[2]
            closestChild.CreateChildren()
            self.visitedQueue.append(closestChild.value)
            for child in closestChild.children:
                if child.value not in self.visitedQueue:
                    count += 1
                    if not child.dist:
                        self.path = child.path
                        break
                    self.priorityQueue.put((child.dist, count, child))
        if not self.path:
            print("Goal of {} is not possible!".format(self.goal))
        return self.path

if __name__ == "__main__":
    start1 = "rene"
    goal1 = "eren"
    print("Output...")
    a = A_Star_Solver(start1, goal1)
    result = a.Solve()
    if result:
        for i in range(len(result)):
            print("{0}){1}".format(i, result[i]))
