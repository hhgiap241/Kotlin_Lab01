import java.util.*
import kotlin.collections.ArrayList


/**
 * Homework01
 * Lab01
 * Created by 19127640 - Hoang Huu Giap
 * Date 1/14/2022 - 11:20 PM
 * Description: Homework 01
 */
class StringExercise {
    fun getStringLength(s: String): Int {
        return s.length
    }

    fun concateString(s1: String, s2: String): String {
        return s1.plus(s2)
    }

    fun getUpperCase(s: String): String {
        return s.uppercase()
    }

    fun findAndReplace(s1: String, s2: String): String {
        return s1.replace(s2, "nlhdung", true)
    }

    fun findAndRemove(s1: String, s2: String): String {
        var result: String = ""
        var originalString: String = s1
        var newPos: Int = 0
        var oldPos: Int = 0
        var found: Int = originalString.indexOf(s2)
        while (true) {
            if (found == -1) {
                result += originalString.substring(oldPos)
                break
            }
            result += originalString.substring(oldPos, found)
            newPos = found + s2.length
            originalString = originalString.substring(newPos)
            found = originalString.indexOf(s2)
        }
        return result
    }

    fun addHead(s: String): String {
        return s.prependIndent("nlhdung")
    }

    fun addTail(s: String): String {
        return s.plus("nlhdung")
    }

    fun insertToPosition(s: String, x: Int): String {
        if (x > s.length)
            return "Can't insert at position $x"
        return s.substring(0, x) + "nlhdung" + s.substring(x)
    }

    fun calculateNumberOfElement(s: String): Int {
        var count: Int = 0
        var position: Int = -1
        var value: String = s
        position = value.indexOf("nlhdung")
        while (position != -1) {
            count++
            value = value.substring(position + "nlhdung".length)
            position = value.indexOf("nlhdung")
        }
        return count
    }

    fun randomString(s: String): String {
        val random = Random()
        var startIndex: Int = random.nextInt(s.length / 2)
        var endIndex: Int = startIndex + s.length / 2
        return s.substring(startIndex, endIndex)
    }
}

class LoopExercise {
    fun outputArray(array: Array<Int>) {
        print("[ ")
        for (item in array) {
            print(item)
            print(" ")
        }
        print("]")
        println()
    }
    fun outputTuple(pair: Pair<Int, Int>){
        println("First: ${pair.first}")
        println("Second: ${pair.second}")
    }

    fun reverseArray(array: Array<Int>): Array<Int> {
        array.reverse();
        var result: Array<Int> = Array(array.size) { 0 }
        for (i in array.indices) {
            result[i] = array[i]
        }
        return result
    }

    fun gcdHandle(n: Int): Pair<Int, Int> {
        var array =  ArrayList<Int>()
        var sum: Int = 0
        for (i in 1..n) {
            if (n % i == 0) {
                array.add(i)
                sum += i
            }
        }
        var result: Pair<Int, Int> = Pair(array.size, sum)
        return result
    }
    fun cau3(n: Int):Pair<Int, Int>{
        var m = n
        var count: Int = 0
        var sum: Int = 0
        while (m > 0){
            var number = m % 10
            sum += number
            count++
            m /= 10
        }
        var result: Pair<Int, Int> = Pair(count, sum)
        return result
    }

}

fun main(args: Array<String>) {
//    var stringExercise = StringExercise()
//    println(stringExercise.getStringLength("nlhdung"))
//    println(stringExercise.concateString("nlhdung", "123"))
//    println(stringExercise.getUpperCase("nlhdung"))
//    println(stringExercise.findAndReplace("Dai Hoc Khoa Hoc Tu Nhien", "hoc"))
//    println(stringExercise.findAndRemove("nlhdungnlhdungnlhdungHonlhdungannlhdungg nlhdungHunlhdungu Giapnlhdungnlhdungnlhdungnlhdungnlhdungnlhdung", "nlhdung"))
//    println(stringExercise.addHead("123"))
//    println(stringExercise.addTail("Teacher: "))
//    println(stringExercise.insertToPosition("Teacher of me", 8))
//    println(stringExercise.calculateNumberOfElement("nlhdungnlhdungnlhdungHonlhdungannlhdungg nlhdungHunlhdungu Giapnlhdungnlhdungnlhdungnlhdungnlhdungnlhdung"))
//    println(stringExercise.randomString("Hoang Huu Giap"))

    var loopExercise = LoopExercise()
    loopExercise.outputArray(loopExercise.reverseArray(arrayOf(1, 2, 3, 4, 5)))
    loopExercise.outputTuple(loopExercise.gcdHandle(8))
    loopExercise.outputTuple(loopExercise.cau3(101100))

}