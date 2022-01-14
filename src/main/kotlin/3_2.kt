import java.lang.Exception
import java.util.*

abstract class DocGia{
    private var id: String? = null
    private var name: String? = null
    private var expiredDate: String? = null
    private var gender: String? = null

    constructor(){
        this.id = null
        this.name = null
        this.gender = null
        this.expiredDate = null
    }

    constructor(id: String){
        this.id = id;
    }
    constructor(id: String, name: String) {
        this.id = id
        this.name = name
    }
    constructor(id: String, name: String, gender: String){
        this.id = id
        this.name = name
        this.gender = gender
    }
    constructor(id: String, name: String, gender: String, expiredDate: String){
        this.id = id
        this.name = name
        this.gender = gender
        this.expiredDate = expiredDate
    }


    fun input() {
        var scanner = Scanner(System.`in`)
        println("======================== Input information ========================")
        print("Input ID: ")
        id = scanner.nextLine()
        print("Input name: ")
        name = scanner.nextLine()
        print("Input expired date: ")
        expiredDate = scanner.nextLine()
        print("Input gender: ")
        gender = scanner.nextLine()
    }

    fun output() {
        println("======================== Output Information ========================")
        println("ID: $id")
        println("Name: $name")
        println("Expired date: $expiredDate")
        println("Gender: $gender")
    }

    abstract fun calculateFee(): String
}

class DocGiaThuong : DocGia {
    private var numberOfBook: Int = 0
    constructor(): super()
    constructor(id: String) : super(id)
    constructor(id: String, name: String): super(id, name)
    constructor(id: String, name: String, gender: String): super(id, name, gender)
    constructor(id: String, name: String, gender: String, expiredDate: String): super(id, name, gender, expiredDate)
    constructor(id: String, name: String, gender: String, expiredDate: String, book: Int): super(id, name, gender, expiredDate){
        this.numberOfBook = book
    }

    override fun calculateFee(): String {
        return "Your fee is ${5000 * this.numberOfBook}"
    }
}

class DocGiaVIP : DocGia {
    constructor(): super()
    constructor(id: String) : super(id)
    constructor(id: String, name: String): super(id, name)
    constructor(id: String, name: String, gender: String): super(id, name, gender)
    constructor(id: String, name: String, gender: String, expiredDate: String): super(id, name, gender, expiredDate)
    override fun calculateFee(): String {
        return "Your fee is ${50000}"
    }
}

fun main(args: Array<String>) {
    var docGiaThuong = DocGiaThuong("DG01", "Nguyen Van A", "Male", "30/1/2022", 30)
    docGiaThuong.output()
    println(docGiaThuong.calculateFee())

    var docGiaVIP = DocGiaVIP()
    docGiaVIP.input()
    docGiaVIP.output()
    println(docGiaVIP.calculateFee())
}