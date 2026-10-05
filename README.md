# Member 4: Graph, BFS, DFS, and Integration

## Student Details

- Name: Athnan
- Student ID: 23DA2-0490
- Responsibility: Graph, BFS, DFS, and integration

## Individual Contribution

Implemented the graph module and the integrated Final-Project menu in this workspace. Review and update this statement with the group so it accurately describes actual individual contributions.

## Graph Representation

The member graph is undirected and stores vertices plus each vertex’s neighbors in custom dynamic arrays. Traversal queues/stacks and visited flags also use arrays. Duplicate vertices, self-edges, duplicate edges, and edges with missing endpoints are rejected.

## BFS and DFS

- **BFS** visits neighbors level by level from a valid start vertex. It uses a custom array queue and a visited array.
- **DFS** explores a path before backtracking. It uses a custom array stack and a visited array.
- Traversal from a start vertex visits only its connected component; the menu reports this when other vertices are unreachable.

## Complexity

For an adjacency-list graph, BFS and DFS take O(V + E) time and O(V) auxiliary space. Vertex lookup is linear for graph updates; traversal stores neighbor indexes, so BFS/DFS do not repeat label lookups while visiting edges.

## Error Handling

Empty graph traversal, duplicate vertices, missing edge endpoints, duplicate/self edges, invalid starting vertices, and invalid menu/value input are handled with messages.

## Testing

**PASS — manual scenarios run:** graph module compiled; adding vertices and edges, duplicate edge, display, and valid BFS/DFS were rechecked after the custom-array rewrite. Earlier manual scenarios also covered duplicate vertex, missing endpoint, and invalid traversal start. These were manual console scenarios, not automated tests.


## Sample Output

Illustrative example (not a captured transcript):

```text
1 -> [2, 3]
BFS traversal: [1, 2, 3]
DFS traversal: [1, 2, 3]
```
