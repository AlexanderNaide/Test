package com.test.test5

abstract class Middleware {
    private var next : Middleware? = null

    constructor(next : Middleware){
        this.next = next
    }

    fun process(transfer: Cluster){
        if (CanDo(transfer)){
            if(!Do(transfer)){
                return
            }
        }
        next?.process(transfer)
    }

    abstract fun Do(transfer: Cluster) : Boolean
    abstract fun CanDo(transfer: Cluster) : Boolean

}