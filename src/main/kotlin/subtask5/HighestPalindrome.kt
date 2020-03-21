package subtask5

import java.lang.Integer.max
import java.lang.StringBuilder

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {

        val editable = StringBuilder(digitString)
        val needToChange = BooleanArray(n / 2)
        var numberChanges = k

        for (i in 0 until editable.length / 2) {
            if (editable[i] != editable[n - 1 - i]) {
                numberChanges--
                needToChange[i] = true
            }
        }

        if (numberChanges >= 0) {
            for (i in 0 until editable.length / 2) {
                if (!needToChange[i]) {
                    if (numberChanges >= 2 && editable[i] != '9') {
                        equalize(editable, i, '9')
                        numberChanges -= 2
                    }
                } else {
                    if (editable[i] != '9' && editable[n - i - 1] != '9' && numberChanges >= 1) {
                        equalize(editable, i, '9')
                        numberChanges--
                    } else {
                        equalize(editable, i,
                            max(editable[i].toInt(), editable[n - i - 1].toInt()).toChar())
                    }
                }
            }
            if (numberChanges >= 1) {
                editable[n / 2] = '9'
            }
            return editable.toString()
        } else {
            return "-1"
        }
    }

    private fun equalize(editable: StringBuilder, index: Int, value: Char) {
        editable[index] = value
        editable[editable.length - 1 - index] = value
    }
}
