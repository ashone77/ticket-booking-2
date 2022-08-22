import java.sql.DriverManager

data class Passengers(val passenger_id:Int, val passenger_name:String, val passenger_age:Int, val gender:String, val phone:String)

fun main(args:Array<String>) {
    val jdbcURL = "jdbc:mysql://localhost:3306/ticketbooking"
    val connection = DriverManager.getConnection(jdbcURL, "root", "root")
    println(connection.isValid(0))

    // --------- Insert Query -------------
//    val res = connection.createStatement()
//        .executeUpdate("insert into passengers(passenger_id,passenger_name,passenger_age,gender,phone) values (2,'Jimmy', 20, 'M', '9864567829')")
//    if (res > 0) {
//        println("Successfully inserted a record into Database")
//    } else {
//        println("Insert not successful")
//    }

//-------------- Update Table ------------------------
//    val res_update=connection.createStatement().executeUpdate("update Passengers set passenger_name='Rohini',passenger_age=24,gender='F' where passenger_id=2")
//    if(res_update > 0){
//        println("Successfully updated a record into Database")
//    }
//    else{
//        println("Updation not successful")
//    }

//------------ Displaying the table -------------------------
    val query = connection.prepareStatement("select *  from passengers")
    val result = query.executeQuery()
    val Passenger = mutableListOf<Passengers>()
    while (result.next()) {
        val passenger_id = result.getInt("passenger_id")
        val passenger_name = result.getString("passenger_name")
        val passenger_age = result.getInt("passenger_age")
        val passenger_gender = result.getString("gender")
        val passenger_phone = result.getString("phone")
        Passenger.add(Passengers(passenger_id,passenger_name,passenger_age,passenger_gender,passenger_phone))

    }
    println(Passenger)
}