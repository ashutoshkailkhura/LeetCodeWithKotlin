import node.ListNode

fun main() {
//    println(isSubsequence("b", "c")) //false
//    println(isSubsequence("", "ahbgdc")) //true
//    println(isSubsequence("b", "cb")) //true
//    println(isSubsequence("acb", "ahbgdc")) //false
//    println(isSubsequence("bb", "ahbgdc")) //false
//    val list1 = ListNode(1)
//    val list2 = ListNode(2)
//    list1.next = list2
//    list2.next = list1
//    println(detectCycle(list1))


}

//https://leetcode.com/problems/is-subsequence/
fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) return true
    var sPosition = 0
    for (i in 0..t.length - 1) {
        if (s[sPosition] == t[i]) {
            sPosition++
        }
    }
    return sPosition == s.length
}

//https://leetcode.com/problems/reverse-linked-list/
fun reverseList(head: ListNode?): ListNode? {
    return reverseLinkList(head, null)
}

fun reverseLinkList(curr: ListNode?, prev: ListNode?): ListNode? {
    if (curr == null) return prev
    val next = curr.next
    curr.next = prev
    return reverseLinkList(next, curr)
}

//https://leetcode.com/problems/merge-two-sorted-lists/
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

//    if (list1 == null) return list2
//    if (list2 == null) return list1
//    var first = list1
//    var second = list2
//    var mergeList: ListNode? = null
//    while (first != null || second != null) {
//        if (first!!.`val` < second!!.`val`) {
//            val next = first.next
//            mergeList = first
//            first = next
//        }else{
//            val next = second.next
//            mergeList = second
//            second = next
//        }
//    }
//    while (first != null) {
//        val next = first.next
//        mergeList = first
//        first = next
//    }
//    while (second != null) {
//        val next = second.next
//        mergeList = second
//        second = next
//    }
//
//    return mergeList
    if (list1 == null && list2 == null) {
        return null
    }
    if (list1 == null && list2 != null) {
        return list2
    }
    if (list1 != null && list2 == null) {
        return list1
    }

    var next1 = list1
    var next2 = list2
    var firstVal: Int

    if (next1!!.`val` >= next2!!.`val`) {
        firstVal = next2?.`val`
        next2 = next2.next
    } else {
        firstVal = next1?.`val`
        next1 = next1.next
    }

    var next3 = ListNode(firstVal)
    var list3Start = next3

    while (next1 != null || next2 != null) {
        if (next1 == null) {
            next3.next = next2
            break
        }
        if (next2 == null) {
            next3.next = next1
            break
        }
        if (next1!!.`val` >= next2!!.`val`) {
            next3.next = ListNode(next2?.`val`)
            next3 = next3.next!!
            next2 = next2.next
        } else {
            next3.next = ListNode(next1?.`val`)
            next3 = next3.next!!
            next1 = next1.next
        }
    }

    return list3Start
}

//https://leetcode.com/problems/middle-of-the-linked-list/
fun middleNode(head: ListNode?): ListNode? {
    var firstHead = head
    var secondHead = head

    while (secondHead?.next != null) {
        firstHead = firstHead?.next
        secondHead = secondHead?.next?.next
    }
    return firstHead
}


//https://leetcode.com/problems/linked-list-cycle-ii/
fun detectCycle(head: ListNode?): ListNode? {
//    if (head?.next == null) return null
//    val myMap = mutableSetOf<Int>()
//    var newHead = head
//    while (newHead != null) {
//        if (myMap.contains(newHead.`val`)) {
//            return newHead
//        } else {
//            myMap.add(newHead.`val`)
//            newHead = newHead.next
//        }
//    }
//    return null
    val set = mutableSetOf<ListNode>()
    var pointer = head
    while (pointer != null) {
        if (!set.contains(pointer)) {
            set.add(pointer)
            pointer = pointer?.next
        } else {
            return pointer
        }
    }
    return null
}