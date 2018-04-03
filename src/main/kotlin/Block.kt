import java.util.Date;

class Block(
        val hash: String,
        val previousHash: String,
        val data: String,
        val timeStamp: Long
){
    fun Block(){
      val data = this.data
      val previousHash = this.previousHash
      val timeStamp = this.timeStamp.toByte()
    }
}
