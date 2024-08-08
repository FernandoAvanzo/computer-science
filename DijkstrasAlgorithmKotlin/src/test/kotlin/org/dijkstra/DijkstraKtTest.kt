package org.dijkstra

import org.junit.jupiter.api.Test

class DijkstraKtTest {

    @Test
    fun testDijkstra() {
        val graph = mapOf(
            "A" to mapOf("B" to 1, "C" to 4),
            "B" to mapOf("A" to 1, "C" to 2, "D" to 5),
            "C" to mapOf("A" to 4, "B" to 2, "D" to 1),
            "D" to mapOf("B" to 5, "C" to 1)
        )
        val expected = mapOf("A" to 0, "B" to 1, "C" to 3, "D" to 4)
        assert(dijkstra(graph, "A") == expected)
    }
}