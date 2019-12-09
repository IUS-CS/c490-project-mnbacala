package com.c490.android.mockify

import java.util.*

class RandomizeCase {
    fun mockify(args: Array<String>){
        val input = Scanner(System.`in`)
        var getInput = true
        while (getInput)
        {
            print("Enter text: ")
            var str = input.nextLine()
            str = str.toLowerCase()
            if (str == "q")
            {
                getInput = false
            }
            var toReturn = ""
            for (ch in str.toCharArray())
            {
                if (toCap())
                {
                    var temp = "" + ch
                    temp = temp.toUpperCase()
                    toReturn += temp
                }
                else
                {
                    toReturn += ch
                }
            }
            println(toReturn)
            if (str != "q")
            {
                println("\n" + "This text has been copied to your clipboad. Press Ctrl + V to paste.")
                println("\nPress Q to quit.")
            }
        }
    }

    fun toCap():Boolean {
        val rand = Random()
        val chance = rand.nextInt(100)
        if (chance <= 50)
        {
            return true
        }
        else
        {
            return false
        }
    }
}