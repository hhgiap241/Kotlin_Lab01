
import java.util.*

abstract class DocGia{
    protected var id: String? = null
    protected var name: String? = null
    protected var expiredDate: String? = null
    protected var gender: String? = null

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


    abstract fun input()
    abstract fun output()

    abstract fun calculateFee(): String
}

class DocGiaThuong : DocGia {
    private var numberOfBorrowBook: Int = 0
    constructor(): super()
    constructor(id: String) : super(id)
    constructor(id: String, name: String): super(id, name)
    constructor(id: String, name: String, gender: String): super(id, name, gender)
    constructor(id: String, name: String, gender: String, expiredDate: String): super(id, name, gender, expiredDate)
    constructor(id: String, name: String, gender: String, expiredDate: String, book: Int): super(id, name, gender, expiredDate){
        this.numberOfBorrowBook = book
    }
    override fun input() {
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
        print("Input number of book you want to borrow: ")
        numberOfBorrowBook = scanner.nextInt()
    }
    override fun output() {
        println("======================== Output Information ========================")
        println("ID: $id")
        println("Name: $name")
        println("Expired date: $expiredDate")
        println("Gender: $gender")
        println("Number of borrow book: $numberOfBorrowBook")
        println("Fee: ${calculateFee()}")
    }
    override fun calculateFee(): String {
        return "Your fee is ${5000 * this.numberOfBorrowBook}"
    }
}

class DocGiaVIP : DocGia {
    constructor(): super()
    constructor(id: String) : super(id)
    constructor(id: String, name: String): super(id, name)
    constructor(id: String, name: String, gender: String): super(id, name, gender)
    constructor(id: String, name: String, gender: String, expiredDate: String): super(id, name, gender, expiredDate)

    override fun input() {
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
    override fun output() {
        println("======================== Output Information ========================")
        println("ID: $id")
        println("Name: $name")
        println("Expired date: $expiredDate")
        println("Gender: $gender")
        println("Fee: ${calculateFee()}")
    }

    override fun calculateFee(): String {
        return "Your fee is ${50000}"
    }
}

fun main(args: Array<String>) {
    var docGiaThuong_1 = DocGiaThuong("DGT01")
    var docGiaThuong_2 = DocGiaThuong("DGT02", "Nguyen Hoang Vinh")
    var docGiaThuong_3 = DocGiaThuong("DGT03", "Nguyen Hoang Nhan", "Male")
    var docGiaThuong_4 = DocGiaThuong("DGT04", "Nguyen Thi Minh", "Female", "30/1/2022")
    var docGiaThuong_5 = DocGiaThuong("DGT05", "Nguyen Van An", "Male", "30/1/2022", 30)
    var docGiaThuong = DocGiaThuong()
    docGiaThuong.input()
    docGiaThuong.output()


    var docGiaVIP_1 = DocGiaVIP("DGV01")
    var docGiaVIP_2 = DocGiaVIP("DGV02", "Pham Trong Hoang")
    var docGiaVIP_3 = DocGiaVIP("DGV03", "Le Phu Quy", "Male")
    var docGiaVIP_4 = DocGiaVIP("DGV04", "Le Thi Minh Thu", "Female", "30/1/2022")
    var docGiaVIP = DocGiaVIP()
    docGiaVIP.input()
    docGiaVIP.output()
}