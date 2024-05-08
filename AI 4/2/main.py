class Graph:
    def __init__(self, edges, n):
        self.adjList = [[] for _ in range(n)]
        for (src, dest) in edges:
            self.adjList[src].append(dest)
            self.adjList[dest].append(src)

    def colorGraph(self, n):
        result = {}
        colors = ['', 'BLUE', 'GREEN', 'RED', 'YELLOW', 'ORANGE', 'PINK', 'BLACK', 'BROWN', 'WHITE', 'PURPLE', 'VIOLET']
        
        for u in range(n):
            assigned = set([result.get(i) for i in self.adjList[u] if i in result])
            color = 1
            for c in assigned:
                if color != c:
                    break
                color += 1
            result[u] = color

        for v in range(n):
            print(f'Color assigned to vertex {v} is {colors[result[v]]}')

if __name__ == '__main__':
    edges = [(0, 1), (0, 4), (0, 5), (4, 5), (1, 4), (1, 3), (2, 3), (2, 4)]
    n = 8
    graph = Graph(edges, n)
    graph.colorGraph(n)
