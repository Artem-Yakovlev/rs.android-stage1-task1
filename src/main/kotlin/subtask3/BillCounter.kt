package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val actualBill = (bill.sum() - bill[k]) / 2
        return if (actualBill == b) {
            "Bon Appetit"
        } else {
            (b - actualBill).toString()
        }
    }
}
