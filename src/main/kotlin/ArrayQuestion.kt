

fun main() {
//    println(runningSum(intArrayOf(1, 1, 1, 1, 1)))
//    println(pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
//    println(isIsomorphic("paper", "title"))
//    val nodeOne = ListNode(1)
//    val nodeTwo = ListNode(2)
//    val nodeThree = ListNode(3)
//    val nodeFour = ListNode(4)
//    val nodeFive = ListNode(5)
//    nodeOne.next = nodeTwo
//    nodeTwo.next = nodeThree
//    nodeThree.next = nodeFour
//    nodeFour.next = nodeFive
//    reverseList(nodeOne)


}

//https://leetcode.com/problems/running-sum-of-1d-array/
fun runningSum(nums: IntArray): IntArray {
    val newRunningSum = mutableListOf<Int>()
    var sum = 0
    for (num in nums) {
        sum += num
        newRunningSum.add(sum)
    }
    return newRunningSum.toIntArray()
}

//https://leetcode.com/problems/find-pivot-index/
fun pivotIndex(nums: IntArray): Int {
    var rightSum = 0
    var leftSum = 0
    for (num in nums) rightSum += num
    for (i in nums.indices) {
        rightSum -= nums[i]
        if (rightSum == leftSum) return i
        leftSum += nums[i]
    }
    return -1
}

//https://leetcode.com/problems/isomorphic-strings/
fun isIsomorphic(s: String, t: String): Boolean {
    val myMap = mutableMapOf<Char, Char>()
    for (i in 0..s.length - 1) {
        if (myMap[s[i]] == null) {
            myMap[s[i]] = t[i]
        } else if (myMap[s[i]] == t[i]) {
            return false
        }
    }
//        for ((i, letter) in s.withIndex()) {
//        val targetChar = t[i]
//        if (map.containsKey(letter) && map[letter] != targetChar) {
//            return false
//        }
//        if (map.containsValue(targetChar)) {
//            map.entries.find {
//                it.value == targetChar && it.key == letter
//            } ?: return false
//        }
//        map[letter] = targetChar
//    }
    return true
//    "badc"    "egg"
//    "baba"    "add"
}


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
fun maxProfit(prices: IntArray): Int {
//    var max = prices[0]
//    var min = prices[0]
//    var diff = 0
//    for (i in 1..prices.size - 1) {
//        if (prices[i] > max) {
//            max = prices[i]
//            if ((max - min) > diff) {
//                diff = max - min
//            }
////            diff = max - min
//        } else if (prices[i] < min) {
//            min = prices[i]
//            max = prices[i]
//        }
//    }
////    println("max $max min $min")
//    return diff
    var lowestPrice = prices[0]
    var diff = 0
    for (i in 0..prices.size - 1) {
        lowestPrice = Math.min(lowestPrice, prices[i])
        diff = Math.max(diff, prices[i] - lowestPrice)
    }
    return diff
}

/*
 val map = mutableMapOf<Char, Int>()
    s.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    var count = 0
    map.values.forEach {
        count += it % 2
    }
    return if (count > 1) {
        s.length - count + 1
    } else {
        s.length
    }
 */
//https://leetcode.com/problems/longest-palindrome/
fun longestPalindrome(s: String): Int {
    if (s.length == 1) return 1
    var length = 0
    var oddChar = 0
    val myMap = mutableMapOf<Char, Int>()
    for (char in s) {
        if (myMap[char] != null) {
            myMap[char] = myMap[char]!! + 1
        } else {
            myMap[char] = 1
        }
    }
    println(myMap)
    if (myMap.size == 1) return myMap[s[0]]!!
    for (num in myMap.values) {
        if (num % 2 == 0) {
            length += num
        } else {
            length += (num-1)
            oddChar++
        }
    }
    println("oddChar $oddChar")
    println("length $length")
    if (oddChar > 0) length += 1
    return length
}
