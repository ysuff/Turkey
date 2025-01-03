package com.example.turkey.views
class Tree {
    private val adjacencyList = mutableMapOf<String, List<String>>()

    init {
        adjacencyList["Adana"] = listOf("Mersin", "Niğde", "Kayseri", "Kahramanmaraş", "Osmaniye", "Hatay")
        adjacencyList["Adıyaman"] = listOf("Malatya", "Kahramanmaraş", "Gaziantep", "Şanlıurfa", "Diyarbakır")
        adjacencyList["Afyon"] = listOf("Eskişehir", "Konya", "Isparta", "Burdur", "Denizli", "Uşak", "Kütahya")
        adjacencyList["Ağrı"] = listOf("Kars", "Iğdır", "Van", "Bitlis", "Muş", "Erzurum")
        adjacencyList["Amasya"] = listOf("Tokat", "Samsun", "Çorum", "Yozgat")
        adjacencyList["Ankara"] = listOf("Eskişehir", "Konya", "Kırıkkale", "Çankırı", "Bolu", "Kırşehir")
        adjacencyList["Antalya"] = listOf("Muğla", "Burdur", "Isparta", "Konya", "Karaman", "Mersin")
        adjacencyList["Artvin"] = listOf("Rize", "Erzurum", "Ardahan")
        adjacencyList["Aydın"] = listOf("İzmir", "Manisa", "Denizli", "Muğla")
        adjacencyList["Balıkesir"] = listOf("Çanakkale", "Bursa", "Kütahya", "Manisa", "İzmir")
        adjacencyList["Bilecik"] = listOf("Bursa", "Sakarya", "Bolu", "Eskişehir")
        adjacencyList["Bingöl"] = listOf("Erzincan", "Erzurum", "Muş", "Diyarbakır", "Elazığ", "Tunceli")
        adjacencyList["Bitlis"] = listOf("Van", "Siirt", "Batman", "Muş", "Ağrı")
        adjacencyList["Bolu"] = listOf("Düzce", "Sakarya", "Bilecik", "Eskişehir", "Ankara", "Çankırı", "Zonguldak")
        adjacencyList["Burdur"] = listOf("Muğla", "Antalya", "Isparta", "Afyon", "Denizli")
        adjacencyList["Bursa"] = listOf("Balıkesir", "Kütahya", "Bilecik", "Sakarya", "Yalova")
        adjacencyList["Çanakkale"] = listOf("Balıkesir", "Tekirdağ", "Edirne")
        adjacencyList["Çankırı"] = listOf("Kastamonu", "Çorum", "Kırıkkale", "Ankara", "Bolu", "Karabük")
        adjacencyList["Çorum"] = listOf("Sinop", "Samsun", "Amasya", "Yozgat", "Kırıkkale", "Çankırı", "Kastamonu")
        adjacencyList["Denizli"] = listOf("Aydın", "Manisa", "Uşak", "Afyon", "Burdur", "Muğla")
        adjacencyList["Diyarbakır"] = listOf("Şanlıurfa", "Mardin", "Batman", "Muş", "Bingöl", "Elazığ", "Malatya", "Adıyaman")
        adjacencyList["Edirne"] = listOf("Kırklareli", "Tekirdağ", "Çanakkale")
        adjacencyList["Elazığ"] = listOf("Malatya", "Diyarbakır", "Bingöl", "Tunceli")
        adjacencyList["Erzincan"] = listOf("Sivas", "Tunceli", "Bingöl", "Erzurum", "Bayburt", "Gümüşhane", "Giresun")
        adjacencyList["Erzurum"] = listOf("Artvin", "Ardahan", "Kars", "Ağrı", "Muş", "Bingöl", "Erzincan", "Bayburt")
        adjacencyList["Eskişehir"] = listOf("Bilecik", "Kütahya", "Afyon", "Konya", "Ankara", "Bolu")
        adjacencyList["Gaziantep"] = listOf("Kahramanmaraş", "Adıyaman", "Şanlıurfa", "Kilis", "Hatay", "Osmaniye")
        adjacencyList["Giresun"] = listOf("Ordu", "Sivas", "Erzincan", "Gümüşhane", "Trabzon")
        adjacencyList["Gümüşhane"] = listOf("Trabzon", "Giresun", "Erzincan", "Bayburt")
        adjacencyList["Hakkari"] = listOf("Van", "Şırnak")
        adjacencyList["Hatay"] = listOf("Osmaniye", "Gaziantep", "Adana")
        adjacencyList["Isparta"] = listOf("Antalya", "Konya", "Afyon", "Burdur")
        adjacencyList["Mersin"] = listOf("Adana", "Niğde", "Konya", "Karaman", "Antalya")
        adjacencyList["İstanbul"] = listOf("Kocaeli", "Tekirdağ")
        adjacencyList["İzmir"] = listOf("Aydın", "Manisa", "Balıkesir")
        adjacencyList["Kars"] = listOf("Ardahan", "Ağrı", "Iğdır")
        adjacencyList["Kastamonu"] = listOf("Sinop", "Çorum", "Çankırı", "Karabük", "Bartın")
        adjacencyList["Kayseri"] = listOf("Adana", "Kahramanmaraş", "Sivas", "Yozgat", "Nevşehir", "Niğde")
        adjacencyList["Kırklareli"] = listOf("Tekirdağ", "Edirne")
        adjacencyList["Kırşehir"] = listOf("Nevşehir", "Yozgat", "Ankara", "Kırıkkale")
        adjacencyList["Kocaeli"] = listOf("İstanbul", "Yalova", "Sakarya")
        adjacencyList["Konya"] = listOf("Antalya", "Karaman", "Mersin", "Niğde", "Aksaray", "Ankara", "Eskişehir", "Afyon", "Isparta")
        adjacencyList["Kütahya"] = listOf("Bursa", "Bilecik", "Eskişehir", "Afyon", "Uşak", "Manisa", "Balıkesir")
        adjacencyList["Malatya"] = listOf("Sivas", "Kahramanmaraş", "Adıyaman", "Diyarbakır", "Elazığ")
        adjacencyList["Manisa"] = listOf("İzmir", "Aydın", "Denizli", "Uşak", "Kütahya", "Balıkesir")
        adjacencyList["Kahramanmaraş"] = listOf("Sivas", "Kayseri", "Adana", "Osmaniye", "Gaziantep", "Adıyaman", "Malatya")
        adjacencyList["Mardin"] = listOf("Şanlıurfa", "Diyarbakır", "Batman", "Siirt", "Şırnak")
        adjacencyList["Muğla"] = listOf("Antalya", "Burdur", "Denizli", "Aydın")
        adjacencyList["Muş"] = listOf("Erzurum", "Ağrı", "Bitlis", "Batman", "Diyarbakır", "Bingöl")
        adjacencyList["Nevşehir"] = listOf("Kırşehir", "Yozgat", "Kayseri", "Niğde", "Aksaray")
        adjacencyList["Niğde"] = listOf("Aksaray", "Nevşehir", "Kayseri", "Adana", "Mersin", "Konya")
        adjacencyList["Ordu"] = listOf("Samsun", "Tokat", "Sivas", "Giresun")
        adjacencyList["Rize"] = listOf("Trabzon", "Artvin")
        adjacencyList["Sakarya"] = listOf("Kocaeli", "Bilecik", "Bolu", "Düzce")
        adjacencyList["Samsun"] = listOf("Sinop", "Çorum", "Amasya", "Tokat", "Ordu")
        adjacencyList["Siirt"] = listOf("Batman", "Bitlis", "Van", "Şırnak", "Mardin")
        adjacencyList["Sinop"] = listOf("Kastamonu", "Çorum", "Samsun")
        adjacencyList["Sivas"] = listOf("Tokat", "Ordu", "Giresun", "Erzincan", "Malatya", "Kahramanmaraş", "Kayseri", "Yozgat")
        adjacencyList["Tekirdağ"] = listOf("İstanbul", "Kırklareli", "Edirne", "Çanakkale")
        adjacencyList["Tokat"] = listOf("Samsun", "Amasya", "Yozgat", "Sivas", "Ordu")
        adjacencyList["Trabzon"] = listOf("Rize", "Giresun", "Gümüşhane")
        adjacencyList["Tunceli"] = listOf("Elazığ", "Bingöl", "Erzincan")
        adjacencyList["Şanlıurfa"] = listOf("Gaziantep", "Adıyaman", "Diyarbakır", "Mardin")
        adjacencyList["Uşak"] = listOf("Manisa", "Kütahya", "Afyon", "Denizli")
        adjacencyList["Van"] = listOf("Hakkari", "Şırnak", "Siirt", "Bitlis", "Ağrı")
        adjacencyList["Yozgat"] = listOf("Çorum", "Amasya", "Tokat", "Sivas", "Kayseri", "Nevşehir", "Kırşehir", "Kırıkkale")
        adjacencyList["Zonguldak"] = listOf("Bartın", "Karabük", "Bolu", "Düzce")
        adjacencyList["Aksaray"] = listOf("Nevşehir", "Niğde", "Konya", "Ankara", "Kırşehir")
        adjacencyList["Bayburt"] = listOf("Erzurum", "Erzincan", "Gümüşhane")
        adjacencyList["Karaman"] = listOf("Mersin", "Konya", "Antalya")
        adjacencyList["Kırıkkale"] = listOf("Çankırı", "Çorum", "Yozgat", "Kırşehir", "Ankara")
        adjacencyList["Batman"] = listOf("Mardin", "Siirt", "Bitlis", "Muş", "Diyarbakır")
        adjacencyList["Şırnak"] = listOf("Mardin", "Siirt", "Van", "Hakkari")
        adjacencyList["Bartın"] = listOf("Zonguldak", "Kastamonu", "Karabük")
        adjacencyList["Ardahan"] = listOf("Artvin", "Kars")
        adjacencyList["Iğdır"] = listOf("Kars", "Ağrı")
        adjacencyList["Yalova"] = listOf("İstanbul", "Kocaeli", "Bursa")
        adjacencyList["Karabük"] = listOf("Zonguldak", "Bartın", "Kastamonu", "Çankırı")
        adjacencyList["Kilis"] = listOf("Gaziantep")
        adjacencyList["Osmaniye"] = listOf("Adana", "Kahramanmaraş", "Gaziantep", "Hatay")
        adjacencyList["Düzce"] = listOf("Zonguldak", "Bolu", "Sakarya")




    }

    fun getNeighbors(city: String): List<String> {
        return adjacencyList[city] ?: emptyList()
    }
}




/*


class Tree {

    Adana: Mersin, Niğde, Kayseri, Kahramanmaraş, Osmaniye, Hatay

    Adıyaman: Malatya, Kahramanmaraş, Gaziantep, Şanlıurfa, Diyarbakır

    Afyon: Eskişehir, Konya, Isparta, Burdur, Denizli, Uşak, Kütahya

    Ağrı: Kars, Iğdır, Van, Bitlis, Muş, Erzurum

    Amasya: Tokat, Samsun, Çorum, Yozgat

    Ankara: Eskişehir, Konya, Kırıkkale, Çankırı, Bolu, Kırşehir

    Antalya: Muğla, Burdur, Isparta, Konya, Karaman, Mersin

    Artvin: Rize, Erzurum, Ardahan

    Aydın: İzmir, Manisa, Denizli, Muğla

    Balıkesir: Çanakkale, Bursa, Kütahya, Manisa, İzmir

    Bilecik: Bursa, Sakarya, Bolu, Eskişehir

    Bingöl: Erzincan, Erzurum, Muş, Diyarbakır, Elazığ, Tunceli

    Bitlis: Van, Siirt, Batman, Muş, Ağrı

    Bolu: Düzce, Sakarya, Bilecik, Eskişehir, Ankara, Çankırı, Zonguldak

    Burdur: Muğla, Antalya, Isparta, Afyon, Denizli

    Bursa: Balıkesir, Kütahya, Bilecik, Sakarya, Yalova

    Çanakkale: Balıkesir, Tekirdağ, Edirne

    Çankırı: Kastamonu, Çorum, Kırıkkale, Ankara, Bolu, Karabük

    Çorum: Sinop, Samsun, Amasya, Yozgat, Kırıkkale, Çankırı, Kastamonu

    Denizli: Aydın, Manisa, Uşak, Afyon, Burdur, Muğla

    Diyarbakır: Şanlıurfa, Mardin, Batman, Muş, Bingöl, Elazığ, Malatya, Adıyaman

    Edirne: Kırklareli, Tekirdağ, Çanakkale

    Elazığ: Malatya, Diyarbakır, Bingöl, Tunceli

    Erzincan: Sivas, Tunceli, Bingöl, Erzurum, Bayburt, Gümüşhane, Giresun

    Erzurum: Artvin, Ardahan, Kars, Ağrı, Muş, Bingöl, Erzincan, Bayburt

    Eskişehir: Bilecik, Kütahya, Afyon, Konya, Ankara, Bolu

    Gaziantep: Kahramanmaraş, Adıyaman, Şanlıurfa, Kilis, Hatay, Osmaniye

    Giresun: Ordu, Sivas, Erzincan, Gümüşhane, Trabzon

    Gümüşhane: Trabzon, Giresun, Erzincan, Bayburt

    Hakkari: Van, Şırnak

    Hatay: Osmaniye, Gaziantep, Adana

    Isparta: Antalya, Konya, Afyon, Burdur

    Mersin: Adana, Niğde, Konya, Karaman, Antalya

    İstanbul: Kocaeli, Tekirdağ

    İzmir: Aydın, Manisa, Balıkesir

    Kars: Ardahan, Ağrı, Iğdır

    Kastamonu: Sinop, Çorum, Çankırı, Karabük, Bartın

    Kayseri: Adana, Kahramanmaraş, Sivas, Yozgat, Nevşehir, Niğde

    Kırklareli: Tekirdağ, Edirne

    Kırşehir: Nevşehir, Yozgat, Ankara, Kırıkkale

    Kocaeli: İstanbul, Yalova, Sakarya

    Konya: Antalya, Karaman, Mersin, Niğde, Aksaray, Ankara, Eskişehir, Afyon, Isparta

    Kütahya: Bursa, Bilecik, Eskişehir, Afyon, Uşak, Manisa, Balıkesir

    Malatya: Sivas, Kahramanmaraş, Adıyaman, Diyarbakır, Elazığ

    Manisa: İzmir, Aydın, Denizli, Uşak, Kütahya, Balıkesir

    Kahramanmaraş: Sivas, Kayseri, Adana, Osmaniye, Gaziantep, Adıyaman, Malatya

    Mardin: Şanlıurfa, Diyarbakır, Batman, Siirt, Şırnak

    Muğla: Antalya, Burdur, Denizli, Aydın

    Muş: Erzurum, Ağrı, Bitlis, Batman, Diyarbakır, Bingöl

    Nevşehir: Kırşehir, Yozgat, Kayseri, Niğde, Aksaray

    Niğde: Aksaray, Nevşehir, Kayseri, Adana, Mersin, Konya

    Ordu: Samsun, Tokat, Sivas, Giresun

    Rize: Trabzon, Artvin

    Sakarya: Kocaeli, Bilecik, Bolu, Düzce

    Samsun: Sinop, Çorum, Amasya, Tokat, Ordu

    Siirt: Batman, Bitlis, Van, Şırnak, Mardin

    Sinop: Kastamonu, Çorum, Samsun

    Sivas: Tokat, Ordu, Giresun, Erzincan, Malatya, Kahramanmaraş, Kayseri, Yozgat

    Tekirdağ: İstanbul, Kırklareli, Edirne, Çanakkale

    Tokat: Samsun, Amasya, Yozgat, Sivas, Ordu

    Trabzon: Rize, Giresun, Gümüşhane

    Tunceli: Elazığ, Bingöl, Erzincan

    Şanlıurfa: Gaziantep, Adıyaman, Diyarbakır, Mardin

    Uşak: Manisa, Kütahya, Afyon, Denizli

    Van: Hakkari, Şırnak, Siirt, Bitlis, Ağrı

    Yozgat: Çorum, Amasya, Tokat, Sivas, Kayseri, Nevşehir, Kırşehir, Kırıkkale

    Zonguldak: Bartın, Karabük, Bolu, Düzce

    Aksaray: Nevşehir, Niğde, Konya, Ankara, Kırşehir

    Bayburt: Erzurum, Erzincan, Gümüşhane

    Karaman: Mersin, Konya, Antalya

    Kırıkkale: Çankırı, Çorum, Yozgat, Kırşehir, Ankara

    Batman: Mardin, Siirt, Bitlis, Muş, Diyarbakır

    Şırnak: Mardin, Siirt, Van, Hakkari

    Bartın: Zonguldak, Kastamonu, Karabük

    Ardahan: Artvin, Kars

    Iğdır: Kars, Ağrı

    Yalova: İstanbul, Kocaeli, Bursa

    Karabük: Zonguldak, Bartın, Kastamonu, Çankırı

    Kilis: Gaziantep

    Osmaniye: Adana, Kahramanmaraş, Gaziantep, Hatay

    Düzce: Zonguldak, Bolu, Sakarya
}

 */