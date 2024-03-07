package com.example.swiggy.method

import com.example.swiggy.model.FoodOrderItem
import com.example.swiggy.model.Restaurants

object InsertMethod {
    fun getAllInsertRestaurantData(): ArrayList<Restaurants> {
        val list = ArrayList<Restaurants>()

        list.add(
            Restaurants(
                1,
                4,
                "₹150 OFF",
                "pureVeg",
                0,
                "4.2(10k+), 25 mins",
                "Pizzas,Italian,pastas",
                "Sector 18",
                "Free Delivery",
                "Domino's Pizza"
            )
        )
        list.add(
            Restaurants(
                2,
                4,
                "60% OFF",
                "pureVeg",
                0,
                "4.2(100+),45-50 mins",
                "NorthIndia,Biryani",
                "Noida Sec 41,6.9 km",
                "Free Delivery",
                "Goila Butter Chicken"
            )
        )

        list.add(
            Restaurants(
                3,
                4,
                "50% OFF",
                "pureVeg",
                0,
                "4.3(10k+) ,15-20 mins",
                "Burgers, American",
                "Gautam Buddha ",
                "Free Delivery",
                "Burger King"
            )
        )
        list.add(
            Restaurants(
                4,
                4,
                "70% OFF",
                "pureVeg",
                0,
                "NEW ,30-40 mins",
                "Tibetan,FastFood,pastas",
                "New Ashok Nagar, 1.0 km",
                "Free Delivery",
                "All Fav Restro Cloud.."
            )
        )
        list.add(
            Restaurants(
                1,
                4,
                "50%",
                "pureVeg",
                0,
                "4.5",
                "NorthIndia",
                "4km",
                "Free Delivery",
                "Mohan Dhaba"
            )
        )
        list.add(
            Restaurants(
                2,
                4,
                "",
                "pureVeg",
                0,
                "4.3(10k+) ,20-30 mins",
                "American",
                "Sector 16, 1.3 km",
                "Free Delivery",
                "Mc Donald's "
            )
        )
        list.add(
            Restaurants(
                2,
                4,
                "30% OFF",
                "pureVeg",
                0,
                "4.4(100+),25-30 mins",
                "Beverages, Cafe, Snacks",
                "Sector 16, 2.5 km",
                "Free Delivery",
                "Starbucks Coffee"
            )
        )
        list.add(
            Restaurants(
                4,
                4,
                "20% OFF",
                "pureVeg",
                0,
                "4.1(10k+),15-20 mins",
                "Burgers,Biryani,American",
                "Vasundhara Enclave,1.4km",
                "Free Delivery",
                "KFC"
            )
        )
        list.add(
            Restaurants(
                1,
                4,
                "₹150 OFF",
                "pureVeg",
                0,
                "4.5 (100+), 25-30 mins ",
                "Chinese,Asian",
                "Sector 4,2.1 km",
                "Free Delivery",
                "Mainland China"
            )
        )
        list.add(
            Restaurants(
                2,
                4,
                "50% OFF",
                "pureVeg",
                0,
                "4.1 (10k+),20-25 mins",
                "Salads,Snacks,Desserts",
                "Sector 16, 1.2 km",
                "Free Delivery",
                "Subway"
            )
        )
        return list
    }

    fun getAllInsertFoodData(): ArrayList<FoodOrderItem> {
        val list = ArrayList<FoodOrderItem>()

        list.add(
            FoodOrderItem(
                "bestSeller",
                "Farmhouse Pizza ",
                123,
                "4.4",
                "Delightful combination of onion, capsicum,tomato",
                1,
                1
            )
        )
        list.add(
            FoodOrderItem(
                "Margherita Pizza ",
                "Pizza",
                259,
                "4.2",
                "We Sanchhaya Education Pvt. Ltd., are registered and headquartered",
                1,
                1
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Paneer Tikka Stuffed Garlic Bread",
                169,
                "4.4",
                "We Sanchhaya Education Pvt. Ltd., are registered and headquartered",
                1,
                1
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Crispy Veg Combo",
                229,
                "3.9",
                "Save Rs 45| Our best- selling burger with crispy veg",
                1,
                3
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Medium Fries",
                115,
                "4.4",
                "Save Rs 45| Our best- selling burger with crispy veg",
                1,
                3
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Veg Whopper",
                179,
                "4.4",
                "Save Rs 45| Our best- selling burger with crispy veg",
                1,
                3
            )
        )
        list.add(FoodOrderItem("bestSeller", "Burger King", 123, "4.4", "everything is good", 1, 4))
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Spring Roll[10]",
                169,
                "4.4",
                "A delight for delhi- ites! Golden fried rolls stuffed",
                1,
                4
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Paneer Butter Masala",
                219,
                "4.3",
                "A delight for delhi- ites! Golden fried rolls stuffed",
                1,
                4
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Angithi Spl Dal Makhani",
                123,
                "4.4",
                "A delight for delhi- ites! Golden fried rolls stuffed",
                1,
                4
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Sahi Tukra",
                160,
                "4.3",
                "India bread pudding with dry fruits,flavoured",
                1,
                2
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Veg Biryani",
                260,
                "4.0",
                "Dum pukht method of cooking rice with cottage cheese",
                1,
                2
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Veg Fried Rice ",
                285,
                "3.4",
                "Stir fried rice with vegetables",
                1,
                5
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Veg Chilli Garlic Noodles",
                289,
                "4.3",
                "yellow noodles ,tossed with sweet and spicy garlic sauce",
                1,
                5
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Veg Manchow Soup",
                185,
                "4.6",
                "A Berco's Best -seller! Thick ,hearty,savoury broth ",
                1,
                5
            )
        )
        list.add(
            FoodOrderItem(
                "bestSeller",
                "Paneer chilli with Gravy",
                435,
                "4.4",
                "everything is good",
                1,
                5
            )
        )
        list.add(FoodOrderItem("bestSeller", "McAloo VM", 112, "4.5", "everything is good", 1, 6))
        list.add(
            FoodOrderItem(
                "bestSeller",
                "MCAloo Tikki Burger",
                56,
                "4.4",
                "A tikki delight ,potato and peas patty",
                1,
                6
            )
        )
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 6))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 6))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 7))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 7))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 7))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 7))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 9))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 9))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 9))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 7))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 8))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 8))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 8))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 8))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 10))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 10))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 10))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 10))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 8))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 8))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 11))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 11))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 11))
        list.add(FoodOrderItem("bestSeller", "Pizza", 123, "4.4", "everything is good", 1, 11))
        return list
    }
}
