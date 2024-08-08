package org.dijkstra

import java.util.*


fun dijkstra(graph: Map<String, Map<String, Int>>, start: String): Map<String, Int> {
    val distances = graph.keys.associateWith { Int.MAX_VALUE }.toMutableMap()
    distances[start] = 0
    val queue = PriorityQueue<Pair<Int, String>>(compareBy { it.first })
    queue.add(0 to start)
    while (queue.isNotEmpty()) {
        val (currentDistance, currentVertex) = queue.poll()
        if (currentDistance > distances[currentVertex]!!) continue
        for ((neighbor, weight) in graph[currentVertex]!!) {
            val distance = currentDistance + weight
            if (distance < distances[neighbor]!!) {
                distances[neighbor] = distance
                queue.add(distance to neighbor)
            }
        }
    }
    return distances
}