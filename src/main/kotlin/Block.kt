
class Block(
        val data: String,
        val previousHash: String,
        val timeStamp: Long,
        val hash: calculateHash()
){

    fun Block(){
      val data = this.data
      val previousHash = this.previousHash
      val timeStamp = this.timeStamp.toByte()
    }

    fun calculateHash(): String {
        val calculatedhash = StringUtil.applySha256(
                this.previousHash +
                        java.lang.Long.toString(this.timeStamp) +
                        this.data
        )
        return calculatedhash
    }

    fun isChainValid(): Boolean {
        var currentBlock: Block
        var previousBlock: Block

        //loop through blockchain to check hashes:
        for (i in 1 until blockchain.size()) {
            currentBlock = blockchain.get(i)
            previousBlock = blockchain.get(i - 1)
            //compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                println("Current Hashes not equal")
                return false
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                println("Previous Hashes not equal")
                return false
            }
        }
        return true
    }
}
