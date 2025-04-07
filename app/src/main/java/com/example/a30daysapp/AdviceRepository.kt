package com.example.a30daysapp

import android.content.Context
import android.content.res.AssetManager
import java.io.BufferedReader
import java.io.InputStreamReader

object AdviceRepository {
    private var adviceList = mutableListOf<Advice>()

    fun loadAdviceData(context: Context) {
            val assetManager: AssetManager = context.assets
            val inputStream = assetManager.open("advices.csv")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val lines = reader.readLines()

            for (i in 1 until lines.size) {
                val line = lines[i]
                val parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)".toRegex()).map { it.trim('"') }


                val id = parts[0].trim().toInt()
                adviceList.add(Advice(
                    day = "День $id",
                    title = parts[1].trim(),
                    imageResource = context.resources.getIdentifier("image$id", "drawable", context.packageName),
                    explanation = parts[2].trim()
                ))
            }
            reader.close()

    }

    fun getAdviceList(): MutableList<Advice> {
        return adviceList
    }
}


//package com.example.a30daysapp
//
//import android.content.Context
//import android.content.res.AssetManager
//import java.io.BufferedReader
//import java.io.InputStreamReader
//
//object AdviceRepository {
//    private var adviceList = mutableListOf<Advice>()
//
//    fun loadAdviceData(context: Context) {
//        try {
//            val assetManager: AssetManager = context.assets
//            val inputStream = assetManager.open("advices.csv")
//            val reader = BufferedReader(InputStreamReader(inputStream))
//            val lines = reader.readLines()
//
//            for (i in 1 until lines.size) {
//                val line = lines[i]
//                val parts = line.split(",\"").map { it.trim('"') }
//
////                if (parts.size < 2) {
////                    continue // Пропускаем строки с недостаточным количеством данных
////                }
//                val id = parts[0].trim().toInt()
//                adviceList.add(Advice(
//                    day = "День $id",
//                    title = parts[1].trim(),
//                    imageResource = context.resources.getIdentifier("image$id", "drawable", context.packageName),
//                    explanation = parts[2].trim()
//                ))
//            }
//            reader.close()
//        } catch (e: Exception) {
//            e.printStackTrace() // Выводим стек ошибок в лог
//        }
//    }
//
//    fun getAdviceList(): MutableList<Advice> {
//        return adviceList
//    }
//}
