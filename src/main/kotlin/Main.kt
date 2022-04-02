import java.util.*

fun main() {

    println("Here is the list of subsets: ${findSubsets(listOf(1,3))}")
    println("Here is the list of subsets: ${findSubsets(listOf(1,5,3))}")

    println("Here is the list of subsets no dupes: ${findSubsetsNoDupes(listOf(1,3,3))}")
    println("Here is the list of subsets no dupes: ${findSubsetsNoDupes(listOf(1,5,3,3))}")

    println("Find permutations: ${findPermutations(listOf(1,3,5))}")
    println("Find permutations: ${findPermutations(listOf(2,3))}")
}
// O(2^n) time and space
fun findSubsets(list: List<Int>): MutableList<List<Int>> {
    val result = mutableListOf<List<Int>>(listOf())

    var i = 0
    while(i < list.size) {
        val currentNumber = list[i]
        var j = 0
        val count = result.size
        while(j < count) {
            val newList = result[j].toMutableList()
            newList.add(currentNumber)
            result.add(newList)
            j++
        }
        i++
    }
    return result
}

fun findSubsetsNoDupes(list: List<Int>): MutableList<List<Int>> {
    val result = mutableListOf(listOf<Int>())
    val sortedList = list.sorted()
    var i = 0

    var lastNumber = -1
    var count = 0
    while(i < sortedList.size) {
        val currentNumber = sortedList[i]
        var j = 0
        if(currentNumber == lastNumber) {
            j = count
        }
        count = result.size
        while(j < count) {
            val listToAdd = result[j].toMutableList()
            listToAdd.add(currentNumber)
            result.add(listToAdd)
            j++
        }
        lastNumber = currentNumber
        i++
    }
    return result
}

// O(n*n!) time and space
fun findPermutations(list: List<Int>): MutableList<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val queue: Queue<List<Int>> = LinkedList()
    queue.add(listOf())
    var i = 0
    while(i < list.size) {
        // i is an index of input list
        val currentNumber = list[i]
        var j = 0
        val queueSize = queue.size
        while(j < queueSize) {
            // j is index of each perm
            val currentPerm = queue.poll()
            var k = 0
            val permSize = currentPerm.size + 1
            while(k < permSize) {
                // k is each position in the perm
                val newPerm = currentPerm.toMutableList()
                newPerm.add(k, currentNumber)
                if(newPerm.size == list.size) {
                    result.add(newPerm)
                } else queue.add(newPerm)
                k++
            }
            j++
        }
        i++
    }
    return result
}