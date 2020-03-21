package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyArrayList = sadArray.toCollection(ArrayList())
        var index = 0

        while (index < happyArrayList.size) {
            if (isElementBad(happyArrayList, index)) {
                happyArrayList.removeAt(index--)
            } else {
                index++
            }
        }
        return happyArrayList.toIntArray()
    }

    private fun isElementBad(arrayList: ArrayList<Int>, index: Int): Boolean =
        index != 0 && index != arrayList.size - 1
                && arrayList[index] > arrayList[index - 1] + arrayList[index + 1]
}

