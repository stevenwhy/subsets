fun main() {

    println("Here is the list of subsets: ${findSubsets(listOf(1,3))}")
    println("Here is the list of subsets: ${findSubsets(listOf(1,5,3))}")
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