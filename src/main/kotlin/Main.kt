fun main() {

    println("Here is the list of subsets: ${findSubsets(listOf(1,3))}")
    println("Here is the list of subsets: ${findSubsets(listOf(1,5,3))}")

    println("Here is the list of subsets no dupes: ${findSubsetsNoDupes(listOf(1,3,3))}")
    println("Here is the list of subsets no dupes: ${findSubsetsNoDupes(listOf(1,5,3,3))}")
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