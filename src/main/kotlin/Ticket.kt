import java.sql.DriverManager

data class Ticket(val Ticket_id:Int, val Ticket_number:Int,val passenger_id:Int,val Train_id:Int, val Ticket_price:Int)

fun main() {
    val jdbcURL = "jdbc:mysql://localhost:3306/ticketbooking"
    val connection = DriverManager.getConnection(jdbcURL, "root", "root")
    println(connection.isValid(0))

// ------------- Insert Ticket -----------------
    val res = connection.createStatement().executeUpdate("insert into Ticket(Ticket_id,Ticket_number,passenger_id,Train_id,Ticket_price) values(1004,78765,1,1,1800)")
    if (res > 0) {
        println("Successfully inserted a record into db!!!")
    } else {
        println("Insert not successful")
    }

// ---------- Update Table ----------------
//    val res_update=connection.createStatement().executeUpdate("update Ticket set Ticket_price=2500 where Ticket_id=1004")
//    if(res_update > 0){
//        println("Successfully updated a record into db!!!")
//    }
//    else{
//        println("updation not successful")
//    }

// --------- Delete train -----------------
//    val delete_res = connection.createStatement().executeUpdate("delete from Ticket where Ticket_id=1004")
//    if (delete_res > 0) {
//        println("Successfully deleted a record from db!!!")
//    } else {
//        println("Deletion is not successful")
//    }

//--------- Display Tickets  -----------------
    val query = connection.prepareStatement("select *  from Ticket")
    val result = query.executeQuery()
    val Ticket = mutableListOf<Ticket>()
    while (result.next()) {
        val Ticket_id = result.getInt("Ticket_id")
        val Ticket_number = result.getInt("Ticket_number")
        val passenger_id = result.getInt("passenger_id")
        val Train_id = result.getInt("Train_id")
        val Ticket_price = result.getInt("Ticket_price")
        Ticket.add(Ticket(Ticket_id,Ticket_number,passenger_id,Train_id,Ticket_price))

    }
    println(Ticket)
}