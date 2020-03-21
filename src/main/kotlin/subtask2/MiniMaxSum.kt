package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        val sum = input.sum()
        return arrayOf(sum - (input.max() ?: 0), sum - (input.min() ?: 0)).toIntArray()
    }
}
