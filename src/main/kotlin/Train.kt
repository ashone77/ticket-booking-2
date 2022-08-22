import java.sql.DriverManager

data class Train(val Train_id:Int, val Train_no:Int,val Train_name:String,val Source:String,val Destination:String,val Start_date_time:String,val Arrival_time:String)

fun main() {
    val jdbcURL = "jdbc:mysql://localhost:3306/ticketbooking"
    val connection = DriverManager.getConnection(jdbcURL, "root", "root")
    println(connection.isValid(0))
//------------------- Insert Train ----------------------
//    val res = connection.createStatement().executeUpdate("insert into Train(Train_id,Train_no,Train_name,Source,Destination,Start_date_time,Arrival_time) values(104,89762,'Janashdabthi Express','Delhi','Ernakulam','08-08-2022 04:00 AM','10-08-2022 06:00PM')")
//     if (res > 0) {
//         println("Successfully inserted a record into Database")
//     } else {
//         println("Insert not successful")
//     }

//-------- Update Train ------------------------
//    val res_update=connection.createStatement().executeUpdate("Update Train set Train_name='Kochuveli Express' where Train_id=104")
//    if(res_update > 0){
//        println("Successfully updated a record into db!!!")
//    }
//    else{
//        println("updation not successful")
//    }

// ------------- Delete train -------------------
    val delete_res=connection.createStatement().executeUpdate("delete from Train where Train_id=104")
    if(delete_res > 0){
        println("Successfully deleted a record from db!!!")
    }
    else{
        println("Deletion is not successful")
    }


// ----------------- Display Table ------------------
    val query = connection.prepareStatement("select *  from Train")
    val result = query.executeQuery()
    val Train = mutableListOf<Train>()
    while (result.next()) {
        val Train_id = result.getInt("Train_id")
        val Train_no = result.getInt("Train_no")
        val Train_name = result.getString("Train_name")
        val Source = result.getString("Source")
        val Destination = result.getString("Destination")
        val Start_date_time = result.getString("Start_date_time")
        val Arrival_time = result.getString("Arrival_time")
        Train.add(Train(Train_id,Train_no,Train_name,Source,Destination,Start_date_time,Arrival_time))

    }
    println(Train)
}
