# CN Lab Experiment 10: Dijkstra's Shortest Path Algorithm
# Use 0 to mean "no direct edge" and positive values for edge weights.

INF = 10**9

n = int(input("Enter number of vertices: "))
print("Enter adjacency matrix (0 means no edge):")
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))  # Read one matrix row.

source = int(input("Enter source vertex (0-based): "))

distance = [INF] * n       # Shortest known distance to each vertex.
visited = [False] * n      # True after a vertex is finalized.
distance[source] = 0

for _ in range(n):         # Repeat until all possible vertices are finalized.
    u = -1
    best = INF

    for v in range(n):     # Find the unvisited vertex with smallest distance.
        if not visited[v] and distance[v] < best:
            best = distance[v]
            u = v

    if u == -1:
        break              # Remaining vertices are unreachable.

    visited[u] = True

    for v in range(n):     # Relax every neighbor of the selected vertex.
        if graph[u][v] > 0 and not visited[v]:
            new_distance = distance[u] + graph[u][v]
            if new_distance < distance[v]:
                distance[v] = new_distance

print("Shortest distances from vertex", source)
for v in range(n):         # Display the final distance to each vertex.
    if distance[v] == INF:
        print(v, "-> INF")
    else:
        print(v, "->", distance[v])
