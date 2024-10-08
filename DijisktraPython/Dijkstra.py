import heapq

global_graph = [[0, 1, 0.25],
                [0, 2, 0.3],
                [1, 3, 0.3],
                [1, 4, 0.15],
                [2, 4, 0.20],
                [2, 5, 0.20],
                [3, 6, 0.1],
                [3, 7, 0.15],
                [4, 7, 0.2],
                [5, 7, 0.30],
                [6, 8, 0.3],
                [7, 8, 0.15]]


def dijkstra(graph, start):
    queue = [(start[0], start[2])]
    distances = {element[0]: float('infinity') for element in graph}
    distances[start[0]] = start[2]
    while queue:
        (vertex, current_distance) = heapq.heappop(queue)

        if current_distance > distances[vertex]:
            continue

        for element in graph:
            neighbour = element[1]
            distance = current_distance + element[2]

            if neighbour in distances and distance < distances[neighbour]:
                distances[neighbour] = distance
                heapq.heappush(queue, (neighbour, distance))

    return distances


if __name__ == '__main__':
    expected = 0.75
    result = 0
    G = dijkstra(global_graph, (0,0,0.0))
    print(G)
    for key in G:
        result += G[key]

    print(result)
    print(expected)
    print(result == expected)
