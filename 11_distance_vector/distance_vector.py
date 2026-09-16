# CN Lab Experiment 11: Distance Vector Routing
# Bellman-Ford style updates are used until no routing table changes.

INF = 10**9

n = int(input("Enter number of nodes: "))
print("Enter cost matrix (0 for same node, -1 for no direct link):")
cost = []
for i in range(n):
    row = list(map(int, input().split()))
    for j in range(n):
        if i != j and row[j] == -1:
            row[j] = INF
    cost.append(row)

distance = [row[:] for row in cost]  # Start each node with direct-link costs.

while True:
    changed = False

    for i in range(n):                       # Update table of node i.
        for j in range(n):                   # Try every destination j.
            for k in range(n):               # Try every intermediate neighbor k.
                if distance[i][k] < INF and distance[k][j] < INF:
                    new_cost = distance[i][k] + distance[k][j]
                    if new_cost < distance[i][j]:
                        distance[i][j] = new_cost
                        changed = True

    if not changed:                          # Stop when tables are stable.
        break

for i in range(n):                           # Print each node's routing table.
    print(f"\nRouting table for node {i}:")
    for j in range(n):
        value = "INF" if distance[i][j] >= INF else distance[i][j]
        print(f"Destination {j}: {value}")
