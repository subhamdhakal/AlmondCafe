package com.example.almondcafe.repository

import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.almondcafe.database.dao.ItemDao
import com.example.almondcafe.database.model.Item
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(var dao: ItemDao) {
    val TAG = Repository::class.java.simpleName
    var listOfItems: List<Item> = listOf(
        Item(1, "Coke 250 ml", 40, 0),
        Item(2, "Coke 500 Ml", 70, 1),
        Item(3, "Coke 1500 ml", 190, 2),
        Item(4, "Dew 500 Ml", 70, 3),
        Item(5, "Frooti 250 ml", 30, 4),
        Item(6, "Frooti 500 ml", 70, 5),
        Item(7, "Rara", 20, 6),
        Item(8, "Active Juice", 230, 7),
        Item(9, "Lays", 40, 8),
        Item(10, "Kurkure", 40, 9),
        Item(11, "Mineral Water", 25, 10),
        Item(12, "Testy BIscuit", 10, 11),
        Item(13, "Digestive Bis", 20, 12),
        Item(14, "Butter Crakers", 15, 13),
        Item(15, "Talo 120KO", 120, 14),
        Item(16, "Toilet Paper", 100, 15),
        Item(17, "Adults Daiper", 100, 16),
        Item(18, "Baby Diaper", 105, 17),
        Item(19, "Marry Cake ", 50, 18),
        Item(20, "T Brush", 25, 19),
        Item(21, "T paste", 25, 20),
        Item(22, "Bata", 60, 21),
        Item(23, "Blade", 5, 22),
        Item(24, "Lux Soap", 30, 23),
        Item(25, "B.Oil", 100, 24),
        Item(26, " Lactogan", 590, 25),
        Item(27, "Sugar Free biscuits", 15, 26),
        Item(28, "Myaksi", 350, 27),
        Item(29, "Nippal Botal", 175, 28),
        Item(30, "Spoon ", 15, 29),
        Item(31, "Lemon Tea", 20, 30),
        Item(32, "Black Tea ", 15, 31),
        Item(33, "Milk tea", 20, 32),
        Item(34, "MilK Coffee", 50, 33),
        Item(35, "Cardomon Tea", 25, 34),
        Item(36, "Black Coffee", 30, 35),
        Item(37, "Cloth Soap", 40, 36),
        Item(38, "Rich Soap", 10, 37),
        Item(39, "Navaratna oil", 60, 38),
        Item(40, "Safty", 50, 39),
        Item(41, "Napkien", 80, 40),
        Item(42, "Baby .Soap", 50, 41),
        Item(43, "Life Buoy Soap", 30, 42),
        Item(44, "C.Petikot", 200, 43),
        Item(45, "Baby Shampoo", 150, 44),
        Item(46, "Baby Lotion ", 100, 45),
        Item(47, "Blanket", 1000, 46),
        Item(48, "B.Blanket", 650, 47),
        Item(49, "Mask", 25, 48),
        Item(50, "Penty", 150, 49),
        Item(51, "Moja ", 80, 50),
        Item(52, "Panja", 50, 51),
        Item(53, "Baby.topi", 150, 52),
        Item(54, "Rumal S", 30, 53),
        Item(55, "Vaslin", 130, 54),
        Item(56, "Kayo", 20, 55),
        Item(57, "F.Voto", 250, 56),
        Item(58, "Rumal. L", 80, 57),
        Item(59, "safty .B", 90, 58),
        Item(60, "B.set", 500, 59),
        Item(61, "H.B.M oil200ml ", 270, 60),
        Item(62, "Nicyl Powder", 140, 61),
        Item(63, "B.Cream", 62, 62),
        Item(64, "Nail Cutter", 60, 63),
        Item(65, "B.C gift packet M", 480, 64),
        Item(66, "B.C gift basket", 1010, 65),
        Item(67, "H.B.wipes -S", 65, 66),
        Item(68, "B.C gift packet ", 680, 67),
        Item(69, "Baby Wipes -24", 120, 68),
        Item(70, "Baby Wipes-72 ", 300, 69),
        Item(71, "Baby Soap -75gm", 70, 70),
        Item(72, "Baby Soap -125gm", 100, 71),
        Item(73, "Diper R  Cream-20gm", 80, 72),
        Item(74, "Baby Shampoo -200", 250, 73),
        Item(75, "Baby Shampoo -100", 125, 74),
        Item(76, "Baby Bath- 100ml", 115, 75),
        Item(77, "Baby Massage oil", 145, 76),
        Item(78, "Baby Powder -200gm", 160, 77),
        Item(79, "Baby Powder- 100gm", 100, 78),
        Item(80, "Baby Cream-200ml", 370, 79),
        Item(81, "Baby Cream-100ml", 210, 80),
        Item(82, "Baby Cream-50ml", 115, 81),
        Item(83, "Baby Loation-100ml", 140, 82),
        Item(84, "Mattrice", 500, 83),
        Item(85, "Soup bowl", 60, 84),
        Item(86, "Red Bull", 100, 85),
        Item(87, "Jebra jhola -L", 150, 86),
        Item(88, "Jebra jhola -M", 120, 87),
        Item(89, "Jebra jhola -S", 100, 88),
        Item(90, "Bed Tanna", 600, 89),
        Item(91, "Potato Cracker", 20, 90),
        Item(92, "Latte", 50, 91),
        Item(93, "Soup ", 92, 92),
        Item(94, "Coke 250 ml", 30, 93),
        Item(95, "Frooti 250 ml", 35, 94),
        Item(96, "Appy 250 ml", 35, 95),
        Item(97, "Wai Wai", 20, 96),
        Item(98, "Rara", 20, 97),
        Item(99, "ABC", 15, 98),
        Item(100, "Bis Rs 10", 10, 99),
        Item(101, "Digestive Bis", 25, 100),
        Item(102, "Somosa", 15, 101),
        Item(103, "Dunot", 15, 102),
        Item(104, "Jery", 15, 103),
        Item(105, "B.egg", 20, 104),
        Item(106, "Butter Craker Bis", 15, 105),
        Item(107, "Minral Water", 25, 106),
        Item(108, "Slice", 40, 107),
        Item(109, "Cup-Curd", 40, 108),
        Item(110, "Bhujiya", 35, 109),
        Item(111, "Creamlight", 20, 110),
        Item(112, "Jambo Coke", 140, 111),
        Item(113, "Marry Cake", 50, 112),
        Item(114, "Ness Coffe", 113, 12),
        Item(115, "Maddi Noodles", 114, 114),
        Item(116, "Coke 500 Ml", 70, 115),
        Item(117, "T.Choice", 20, 116),
        Item(118, "cookies", 117, 117)
    )

    fun insertItem(item: Item) {
        Completable.fromAction {
            dao.insertItem(item)
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d(TAG, "Sucessfully inserted")
            }, {
                it.printStackTrace()
            })
    }

    fun getAllItems(name: String): LiveData<List<Item>> {
        return dao.getItems(name)
    }

    fun insertAllData() {
        Completable.fromAction {
            dao.insertAllItems(listOfItems)
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d(TAG, "Sucessfully inserted")
            }, {
                it.printStackTrace()
            })
    }

    fun updateItem(item: Item) {
        Completable.fromAction {
            dao.updateItem(item)
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d(TAG, "Sucessfully updated")
            }, {
                it.printStackTrace()
            })
    }

    fun deleteItem(item: Item) {
        Completable.fromAction {
            dao.deleteItem(item)
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d(TAG, "Sucessfully updated")
            }, {
                it.printStackTrace()
            })    }
}