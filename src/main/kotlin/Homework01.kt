import java.util.*
import java.util.function.DoubleBinaryOperator
import kotlin.collections.ArrayList
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt


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

    fun outputTuple(pair: Pair<Int, Int>) {
        println("First: ${pair.first}")
        println("Second: ${pair.second}")
    }

    fun cau1(array: Array<Int>): Array<Int> {
        array.reverse();
        var result: Array<Int> = Array(array.size) { 0 }
        for (i in array.indices) {
            result[i] = array[i]
        }
        return result
    }

    fun cau2(n: Int): Pair<Int, Int> {
        var array = ArrayList<Int>()
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

    fun cau3(n: Int): Pair<Int, Int> {
        var m = n
        var count: Int = 0
        var sum: Int = 0
        while (m > 0) {
            var number = m % 10
            sum += number
            count++
            m /= 10
        }
        var result: Pair<Int, Int> = Pair(count, sum)
        return result
    }

    fun cau4(n: Int): Pair<Int, Int> {
        var m = n
        var odd: Int = 0
        var even: Int = 0
        while (m > 0) {
            var number = m % 10
            if (number % 2 == 0)
                even++
            else
                odd++
            m /= 10
        }
        var result: Pair<Int, Int> = Pair(odd, even)
        return result
    }

    fun cau5(n: Int): Double {
        var result: Double = 0.0
        for (i in 1..n) {
            result += i.toDouble().pow(2)
        }
        return result
    }

    fun cau6(value: String): Array<String> {
        var array = Array<String>(100) { value }
        for (i in array.indices) {
            array[i] += "-" + (i + 1)
        }
        return array
    }

    fun cau7(array: Array<Int>): Array<Int> {
        for (i in 0 until array.size - 1) {
            for (j in i until array.size) {
                if (array[i] > array[j]) {
                    var temp = array[i]
                    array[i] = array[j]
                    array[j] = temp
                }
            }
        }
        return array
    }

    fun cau8(array: Array<Int>): Array<Int> {
        for (i in 0 until array.size - 1) {
            for (j in i until array.size) {
                if (array[i] < array[j]) {
                    var temp = array[i]
                    array[i] = array[j]
                    array[j] = temp
                }
            }
        }
        return array
    }

    fun cau9(array: Array<Int>, k: Int): Array<Int> {
        if (k == 1) {
            return cau7(array)
        }
        return cau8(array)
    }

    fun cau10(n: Int): Boolean {
        var m = n
        var reversedNumber: Int = 0
        while (m > 0) {
            var digit = m % 10
            reversedNumber = reversedNumber * 10 + digit
            m /= 10
        }
        if (reversedNumber == n)
            return true
        return false
    }

    fun cau11(n: Int): Boolean {
        var count: Int = 0
        for (i in 2..sqrt(n.toDouble()).roundToInt()) {
            if (n % i == 0)
                count++
        }
        if (count == 0)
            return true
        return false
    }

    fun cau12(array: Array<Int>): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        var max = array[0]
        var min = array[0]
        var max_odd = array[0]
        var max_prime = 2
        for (i in array.indices) {
            if (array[i] >= max)
                max = array[i]
            if (array[i] <= min)
                min = array[i]
            if (array[i] % 2 != 0 && array[i] >= max_odd)
                max_odd = array[i]
            if (cau11(array[i]) && array[i] > max_prime)
                max_prime = array[i]
        }
        var result: Pair<Pair<Int, Int>, Pair<Int, Int>> = Pair(Pair(max, min), Pair(max_odd, max_prime))
        return result
    }
}

class OtherExercise {
    fun cau1(km: Int): Double {
        var money: Double = 0.0
        for (i in 1..km) {
            if (i == 1)
                money += 15000
            else if (i in 2..5)
                money += 13500
            else
                money += 11000
        }
        if (km > 120)
            money = money - money * 0.1
        return money
    }

    fun cau2(dongia: Int, soluong: Int, ship: Boolean): Double {
        var money: Double = 0.0
        // ship =  true => co giao hang, false => khong giao hang
        if (ship)
            money = (dongia * soluong + 20000).toDouble()
        else
            money = (dongia * soluong).toDouble()

        if (money > 100000)
            money = money - money * 0.1
        return money
    }

    fun cau3(value: Long, option: Boolean): Double {
        // option = true => USD to VND, false => VND to USD
        if (option) {
            return (value * 27000).toDouble()
        }
        return value.toDouble() / 27000
    }

    fun cau4(N: Int): Int {
        var k = 1
        var sum = 1
        for (i in 1..N) {
            if (sum > N) {
                k = i
                break
            }
            sum += i
        }
        return k
    }
}

fun main(args: Array<String>) {
    println("======================== Bai tap String ========================")
    var stringExercise = StringExercise()
    print("Cau 1: Length of nlhdung = ")
    println(stringExercise.getStringLength("nlhdung"))
    print("Cau 2: ")
    println(stringExercise.concateString("nlhdung", "123"))
    print("Cau 3: ")
    println(stringExercise.getUpperCase("nlhdung"))
    print("Cau 4: ")
    println(stringExercise.findAndReplace("Dai Hoc Khoa Hoc Tu Nhien", "hoc"))
    print("Cau 5: ")
    println(stringExercise.findAndRemove("nlhdungnlhdungnlhdungHonlhdungannlhdungg nlhdungHunlhdungu Giapnlhdungnlhdungnlhdungnlhdungnlhdungnlhdung", "nlhdung"))
    print("Cau 6: ")
    println(stringExercise.addHead("123"))
    print("Cau 7: ")
    println(stringExercise.addTail("Teacher: "))
    print("Cau 8: ")
    println(stringExercise.insertToPosition("Teacher of me", 8))
    print("Cau 9: ")
    println(stringExercise.calculateNumberOfElement("nlhdungnlhdungnlhdungHonlhdungannlhdungg nlhdungHunlhdungu Giapnlhdungnlhdungnlhdungnlhdungnlhdungnlhdung"))
    print("Cau 10: ")
    println(stringExercise.randomString("Hoang Huu Giap"))
    println("======================================================================")

    println("======================== Bai tap For va Array ========================")
    var loopExercise = LoopExercise()
    var array_1 = arrayOf(1, 2, 3, 4, 5)
    println("Cau 1: Truoc khi dao nguoc mang")
    loopExercise.outputArray(array_1)
    println("Sau khi dao nguoc mang: ")
    loopExercise.outputArray(loopExercise.cau1(array_1))

    println("Cau 2: Number n = 8")
    var result_1 = loopExercise.cau2(8)
    println("So luong uoc so = ${result_1.first}")
    println("Tong cac uoc so = ${result_1.second}")

    println("Cau 3: Number n = 101100")
    var result_2 = loopExercise.cau3(101100)
    println("So luong chu so = ${result_2.first}")
    println("Tong cac chu so = ${result_2.second}")

    println("Cau 4: Number n = 102223311")
    var result_3 = loopExercise.cau4(102223311)
    println("So luong chu so le = ${result_3.first}")
    println("So luong chu so chan = ${result_3.second}")

    println("Cau 5: Number n = 11")
    var result_4 = loopExercise.cau5(11)
    println("S = $result_4")

    print("Cau 6: [")
    var result_5 = loopExercise.cau6("nlhdung")
    println(result_5.joinToString() + "]")

    var array_2 = arrayOf(10, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    println("Cau 7: Truoc khi sap xep mang tang dan")
    loopExercise.outputArray(array_2)
    println("Sau khi sap xep mang tang dan: ")
    loopExercise.outputArray(loopExercise.cau7(array_2))

    var array_3 = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 11)
    println("Cau 8: Truoc khi sap xep mang giam dan")
    loopExercise.outputArray(array_3)
    println("Sau khi sap xep mang giam dan: ")
    loopExercise.outputArray(loopExercise.cau8(array_3))

    var array_4 = arrayOf(0, 1, 9, 4, 3, 5, 2, 34, 56, 21, 432, 9, 10, 11)
    println("Cau 9: Truoc khi sap xep")
    loopExercise.outputArray(array_4)
    println("Sau khi sap xep: ")
    loopExercise.outputArray(loopExercise.cau9(array_4, 0))

    print("Cau 10: ")
    var n_1 = 121
    var result_6 = loopExercise.cau10(n_1)
    if (result_6) {
        println("$n_1 la so doi xung")
    } else {
        println("$n_1 khong phai la so doi xung")
    }

    print("Cau 11: ")
    var n_2 = 97
    var result_7 = loopExercise.cau11(n_2)
    if (result_7) {
        println("$n_2 la so nguyen to")
    } else {
        println("$n_2 khong phai la so nguyen to")
    }

    var array_5 = arrayOf(10, 97, 11, 43, 22, 44, 97, 12, 4, 13)
    println("Cau 12:")
    loopExercise.outputArray(array_5)
    var result_8 = loopExercise.cau12(array_5)
    println("So lon nhat = ${result_8.first.first}")
    println("So nho nhat = ${result_8.first.second}")
    println("So le lon nhat = ${result_8.second.first}")
    println("So nguyen to nhat = ${result_8.second.second}")
    println("======================================================================")

    println("======================== Bai tap khac ========================")
    var otherExercise = OtherExercise()
    var km = 130
    print("Cau 1: So tien taxi cho ${km}km = ")
    println(otherExercise.cau1(km))

    print("Cau 2: Phi mua sach = ")
    println(otherExercise.cau2(25000, 12, true))

    print("Cau 3: 50USD to VND = ")
    println(otherExercise.cau3(50, true))
    print("Cau 3: 500000VND to USD = ")
    println(otherExercise.cau3(500000, false))

    print("Cau 4: Number N = 10 => k = ")
    println(otherExercise.cau4(10))
    println("======================================================================")
}
