package com.example.rustoreapp.data

import com.example.rustoreapp.R

class AppRepository {
    fun getAllApps(): List<App> {
        return listOf(
            App(1, "Яндекс GO", "ООО ЯНДЕКС", R.drawable.ic_yandex_go,
                "Заказ такси", "Такси, доставка посылок, самокаты и еда из ресторанов. А ещё аптеки, зарядки, заправки и аренда авто. И, кроме того, путешествия, транспорт и каршеринг.", "Транспорт", "0+",
                listOf(R.drawable.screenshot_go_1, R.drawable.screenshot_go_2)),

            App(2, "СберБанк Онлайн", "ПАО Сбербанк", R.drawable.ic_sberbank,
                "Мобильный банк", "СберБанк Онлайн — самое востребованное банковское приложение в России: им пользуются больше 80 млн человек. Присоединяйтесь!", "Финансы", "6+",
                listOf(R.drawable.screenshot_sber_1, R.drawable.screenshot_sber_2)),

            App(3, "ВТБ Онлайн", "Банк ВТБ (ПАО)", R.drawable.ic_vtb,
                "Мобильный банк", "Вы можете управлять финансами с мобильного устройства 24/7. Регистрация и выпуск цифровой карты займет пару минут.", "Финансы", "6+",
                listOf(R.drawable.screenshot_vtb_1, R.drawable.screenshot_vtb_2)),

            App(4, "Пятерочка", "ООО ИТ ИКС 5 Технологии", R.drawable.ic_pyaterochka,
                "Продукты", "Пятёрочка — доставка продуктов и заказ готовой еды на дом.", "Еда и напитки", "0+",
                listOf(R.drawable.screenshot_pyaterochka_1, R.drawable.screenshot_pyaterochka_2)),

            App(5, "Т-Банк", "АО ТБанк", R.drawable.ic_tbank,
                "Банковские услуги", "Т-Банк — лучшее приложение для жизни. С нами просто и удобно управлять деньгами, выгодно тратить и получать кэшбэк.", "Финансы", "6+",
                listOf(R.drawable.screenshot_tbank_1, R.drawable.screenshot_tbank_2)),

            App(6, "Яндекс Карты", "ООО ЯНДЕКС", R.drawable.ic_yandex_maps,
                "Навигатор", "Яндекс Карты построят маршруты на чём угодно. На общественном транспорте — с прогнозом прибытия на остановку. На автомобиле — с учётом пробок.", "Транспорт", "0+",
                listOf(R.drawable.screenshot_maps_1, R.drawable.screenshot_maps_2)),

            App(7, "Госуслуги", "Минцифры России", R.drawable.ic_gosuslugi,
                "Госуслуги онлайн", "Приложение «Госуслуги» — ваш помощник для взаимодействия с ведомствами и государством", "Государственные", "0+",
                listOf(R.drawable.screenshot_gosuslugi_1, R.drawable.screenshot_gosuslugi_2)),


            App(8, "ВкусВилл", "АО Вкусвилл", R.drawable.ic_vkusvill,
                "Продукты", "ВкусВилл – сервис доставки еды и продуктов и других товаров от экомаркета ВкусВилл. Надежные поставщики, натуральные продукты, готовая еда.", "Еда и напитки", "0+",
                listOf(R.drawable.screenshot_vkusvill_1, R.drawable.screenshot_vkusvill_2))
        )
    }
}