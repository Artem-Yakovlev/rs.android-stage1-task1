package subtask4

import java.lang.StringBuilder

class StringParser {

    private val openBrackets = arrayOf('(', '[', '<')
    private val closeBrackets = arrayOf(')', ']', '>')

    fun getResult(inputString: String): Array<String> {
        val inputEditable = StringBuilder(inputString)
        val resultArrayList = ArrayList<String>()

        for (i in inputString.length - 1 downTo 0) {
            if (inputString[i] in openBrackets) {
                val closeIndex = searchCloseIndexString(inputEditable, i)
                resultArrayList.add(0, inputString.substring(i + 1, closeIndex))
                inputEditable[i] = ' '
                inputEditable[closeIndex] = ' '
            }
        }
        return resultArrayList.toTypedArray()
    }

    private fun searchCloseIndexString(string: StringBuilder, startIndex: Int): Int {
        val closeBracket = closeBrackets[openBrackets.indexOf(string[startIndex])]
        for (i in startIndex until string.length) {
            if (string[i] == closeBracket) {
                return i
            }
        }
        throw IllegalArgumentException("No closing bracket")
    }
}
