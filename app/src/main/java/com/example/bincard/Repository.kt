package com.example.bincard

interface Repository {
    open class Base(
        private val dataSources: ItemDao,
        private val now: Now
    ) : Repository {
        fun add(value: String) {
            val id = now.nowMillis()
            dataSources.add(ItemCache(id, value))
        }

        fun list(): List<ItemUi> {
            return dataSources.list().map {
                ItemUi(it.text)
            }
        }

        fun item(id: Long): ItemUi {
            val itemCache = dataSources.item(id)
            return ItemUi(itemCache.text)
        }
    }
}