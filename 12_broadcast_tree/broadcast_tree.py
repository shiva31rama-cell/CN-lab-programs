# CN Lab Experiment 12: Broadcast Tree
# BFS creates a simple spanning/broadcast tree from a chosen source.

n = int(input("Enter number of hosts: "))
print("Enter adjacency matrix (0 = no link):")
graph = [list(map(int, input().split())) for _ in range(n)]

source = int(input("Enter source host (0-based): "))

visited = [False] * n          # Track hosts already included in the tree.
queue = [source]               # BFS queue starts at the source.
visited[source] = True

tree_edges = []

while queue:                   # Continue while hosts remain to process.
    current = queue.pop(0)     # Remove the first host from the queue.

    for neighbor in range(n):  # Check every possible neighbor.
        if graph[current][neighbor] != 0 and not visited[neighbor]:
            visited[neighbor] = True
            queue.append(neighbor)
            tree_edges.append((current, neighbor))  # Add a tree link.

print("Broadcast tree edges:")
for parent, child in tree_edges:  # Display every parent-child tree edge.
    print(parent, "->", child)
