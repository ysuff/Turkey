package com.example.turkey.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.R
import com.example.turkey.databinding.FragmentCityNameBinding
import com.example.turkey.views.adapters.CityRawAdapter

class CityName : Fragment() {
    private lateinit var binding: FragmentCityNameBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityNameBinding.inflate(inflater, container, false)

        recyclerView = binding.cityNameRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val getCityImage = getCityImage()
        val cityName = getCityNames()
        val cityVisit=getCityVisit()
        val cityFood=getCityFood()


        val adapter = CityRawAdapter(cityName, getCityImage,cityVisit,cityFood)
        recyclerView.adapter = adapter






        return binding.root
    }

    private fun getCityImage(): ArrayList<Int> {
        val adana = R.drawable.adana
        val adiyaman = R.drawable.adiyaman
        val afyonkarahisar = R.drawable.afyonkarahisar
        val agri = R.drawable.agri
        val amasya = R.drawable.amasya
        val ankara = R.drawable.ankara


        val cityImageList = ArrayList<Int>()
        cityImageList.add(adana)
        cityImageList.add(adiyaman)
        cityImageList.add(afyonkarahisar)
        cityImageList.add(agri)
        cityImageList.add(amasya)
        cityImageList.add(ankara)
        return cityImageList
    }

    private fun getCityNames(): ArrayList<String> {
        val sehirAdlari = ArrayList<String>()
        sehirAdlari.add("ADANA")
        sehirAdlari.add("ADİYAMAN")
        sehirAdlari.add("AFYONKARAHİSAR")
        sehirAdlari.add("AĞRI")
        sehirAdlari.add("AMASYA")
        sehirAdlari.add("ANKARA")
        sehirAdlari.add("ANTALYA")
        sehirAdlari.add("ARTVİN")
        sehirAdlari.add("AYDIN")
        sehirAdlari.add("BALIKESİR")
        sehirAdlari.add("BİLECİK")
        sehirAdlari.add("BİNGÖL")
        sehirAdlari.add("BİTLİS")
        sehirAdlari.add("BOLU")
        sehirAdlari.add("BURDUR")
        sehirAdlari.add("BURSA")
        sehirAdlari.add("ÇANAKKALE")
        sehirAdlari.add("ÇANKIRI")
        sehirAdlari.add("ÇORUM")
        sehirAdlari.add("DENİZLİ")
        sehirAdlari.add("DİYARBAKIR")
        sehirAdlari.add("EDİRNE")
        sehirAdlari.add("ELAZIĞ")
        sehirAdlari.add("ERZİNCAN")
        sehirAdlari.add("ERZURUM")
        sehirAdlari.add("ESKİŞEHIR")
        sehirAdlari.add("GAZİANTEP")
        sehirAdlari.add("GİRESUN")
        sehirAdlari.add("GÜMÜŞHANE")
        sehirAdlari.add("HAKKARİ")
        sehirAdlari.add("HATAY")
        sehirAdlari.add("ISPARTA")
        sehirAdlari.add("MERSİN")
        sehirAdlari.add("İSTANBUL")
        sehirAdlari.add("İZMİR")
        sehirAdlari.add("KARS")
        sehirAdlari.add("KASTAMONU")
        sehirAdlari.add("KEYSERİ")
        sehirAdlari.add("KIRIKKALE")
        sehirAdlari.add("KIRŞEHİR")
        sehirAdlari.add("KOCAELİ")
        sehirAdlari.add("KONYA")
        sehirAdlari.add("KÜTAHYA")
        sehirAdlari.add("MALATYA")
        sehirAdlari.add("MANİSA")
        sehirAdlari.add("KARAMAN")
        sehirAdlari.add("MARDİN")
        sehirAdlari.add("MUĞLA")
        sehirAdlari.add("MÜŞ")
        sehirAdlari.add("NEVŞEHİR")
        sehirAdlari.add("NİĞDE")
        sehirAdlari.add("ORDU")
        sehirAdlari.add("RİZE")
        sehirAdlari.add("SAKARYA")
        sehirAdlari.add("SAMSUN")
        sehirAdlari.add("SİİRT")
        sehirAdlari.add("SİNOP")
        sehirAdlari.add("SIVAS")
        sehirAdlari.add("TEKİRDAĞ")
        sehirAdlari.add("TOKAT")
        sehirAdlari.add("TRABZON")
        sehirAdlari.add("TUNCELİ")
        sehirAdlari.add("SANLIURFA")
        sehirAdlari.add("UŞAK")
        sehirAdlari.add("VAN")
        sehirAdlari.add("YOZGAT")
        sehirAdlari.add("ZONGULDAK")
        sehirAdlari.add("AKSARAY")
        sehirAdlari.add("BAYBURT")
        sehirAdlari.add("KARAMAN")
        sehirAdlari.add("KIRIKKALE")
        sehirAdlari.add("BATMAN")
        sehirAdlari.add("ŞIRNAK")
        sehirAdlari.add("BARTIN")
        sehirAdlari.add("ARDAHAN")
        sehirAdlari.add("IĞDIR")
        sehirAdlari.add("YALOVA")
        sehirAdlari.add("KARABUK")
        sehirAdlari.add("KİLİS")
        sehirAdlari.add("OSMANİYE")
        sehirAdlari.add("DÜZCE")
        return sehirAdlari
    }

    private fun getCityVisit(): ArrayList<String> {
        val visitPalace = ArrayList<String>()
        visitPalace.add(
        "Adana, Türkiye'nin güneyinde, Akdeniz Bölgesi'nde yer alan ve tarihi, kültürel ve gastronomik zenginlikleriyle öne çıkan bir şehirdir. Akdeniz iklimi etkisi altında olan Adana, sıcak yazları ve ılıman kışlarıyla bilinir. Tarım ve sanayi şehri olmasının yanı sıra, tarihi ve doğal güzellikleriyle de dikkat çeker.\n" +
                "\n" +
                "Adana'nın gezilecek yerlerinden bazıları şunlardır:\n" +
                "\n" +
                "Taşköprü: Seyhan Nehri üzerinde bulunan ve Roma dönemine dayanan tarihi bir köprüdür. Adana'nın sembolü haline gelmiştir ve şehrin panoramik manzarasını görmek için harika bir noktadır.\n" +
                "\n" +
                "Merkez Park: Şehrin merkezinde yer alan bu park, dinlenmek ve doğayla iç içe vakit geçirmek için ideal bir mekandır. Piknik yapabilir, yürüyüş yapabilir veya gölet etrafında gezinebilirsiniz.\n" +
                "\n" +
                "Sabancı Merkez Camii: Türkiye'nin en büyük camilerinden biridir. Modern mimarisiyle dikkat çeken bu cami, Adana'nın önemli dini ve turistik noktalarından biridir.\n" +
                "\n" +
                "Adana Arkeoloji Müzesi: Şehrin tarihini ve kültürel mirasını keşfetmek isteyenler için ideal bir yerdir. Birbirinden değerli eserlerin sergilendiği müzede, Hitit, Roma, Bizans ve Osmanlı dönemlerine ait eserler bulunmaktadır.\n" +
                "\n" +
                "Adana Ulu Camii ve Ramazanoğulları Külliyesi: Osmanlı dönemi mimarisinin güzel bir örneği olan bu kompleks, tarihi ve mimari açıdan önemli bir yapıdır. Ulu Camii'nin yanı sıra medrese, türbe ve çeşmeler de bu komplekste yer alır.\n" +
                "\n" +
                "Varda Köprüsü: Adana'nın tarihi yapılarından biri olan Varda Köprüsü, Misis Köprüsü olarak da bilinir. Roma dönemine ait olan bu köprü, Seyhan Nehri üzerinde yer alır ve etkileyici bir mimariye sahiptir.\n" +
                "\n" +
                "Adana Kebapları ve Lezzet Durakları: Adana, Türkiye'nin gastronomi başkentlerinden biridir. Burada mutlaka denemeniz gereken lezzetler arasında Adana kebabı, şırdan, beyran çorbası ve tas kebabı bulunur. Şehrin çeşitli noktalarında yer alan kebapçılar ve restoranlar, bu lezzetleri tadabileceğiniz yerlerdir."
        )
        visitPalace.add(" Türkiye'nin güneydoğusunda yer alan bir şehirdir. Doğal ve tarihi güzellikleriyle öne çıkar.\n" +
                "\n" +
                "Adıyaman'ın gezilecek yerlerinden bazıları şunlardır:\n" +
                "\n" +
                "Nemrut Dağı: UNESCO Dünya Mirası Listesi'nde yer alan Nemrut Dağı, muhteşem doğal manzarası ve tarihi kalıntılarıyla ünlüdür. Kommagene Krallığı dönemine ait heykeller ve mezar anıtları burada bulunur.\n" +
                "\n" +
                "Perre Antik Kenti: Adıyaman'ın tarihî zenginliklerinden biridir. Kommagene Krallığı'na ait kalıntıları içerir ve tarihi ziyaretçilere antik bir yolculuk sunar.\n" +
                "\n" +
                "Cendere Köprüsü: Cendere Çayı üzerinde yer alan bu Roma dönemine ait köprü, muhteşem bir mühendislik harikasıdır. Antik çağlarda önemli bir ticaret yolu olan İpek Yolu'nun bir parçasıdır.\n" +
                "\n" +
                "Adıyaman Müzesi: Şehir merkezinde bulunan bu müze, Adıyaman ve çevresinin arkeolojik ve etnografik mirasını sergiler. Kommagene Krallığı'na ait eserler burada görülebilir.\n" +
                "\n" +
                "Kahta Kalesi: Kahta ilçesinde bulunan bu tarihi kale, Pers, Roma ve Bizans dönemlerinde kullanılmıştır. Muhteşem manzarası ile ziyaretçileri etkiler.\n" +
                "\n" +
                "Adıyaman, tarih ve doğa severler için keşfedilmeyi bekleyen birçok güzelliği bünyesinde barındırır.")

        visitPalace.add("Afyon Kalesi: Şehrin simgelerinden biri olan bu kale, tarihi zenginliği ve etkileyici manzarasıyla dikkat çeker. Hititler, Frigyalılar, Romalılar ve Bizanslılar gibi birçok medeniyet tarafından kullanılmıştır.\n" +
                "\n" +
                "Afyonkarahisar Kocatepe Camii: Türkiye'nin en büyük camilerinden biri olan Kocatepe Camii, modern mimarisi ve büyüklüğü ile göz alıcı bir yapıdır. Şehrin merkezinde bulunur ve dini ziyaretler için önemli bir noktadır.\n" +
                "\n" +
                "Afyonkarahisar Arkeoloji Müzesi: Şehir merkezinde bulunan bu müze, bölgedeki arkeolojik buluntuları sergiler. Frigya, Lidya, Hitit ve Roma dönemlerine ait eserler müzede görülebilir.\n" +
                "\n" +
                "Afyonkarahisar Zafer Müzesi: Türk Kurtuluş Savaşı'nda önemli bir rol oynayan Afyonkarahisar'ın kurtuluşunu ve savaşın izlerini anlatan müzedir. Müzede, savaşa dair belgeler, fotoğraflar ve objeler bulunur.\n" +
                "\n" +
                "Termal Kaplıcalar: Afyonkarahisar, termal kaplıcalarıyla da ünlüdür. Şehirde birçok termal otel ve tesis bulunur ve bu kaplıcaların sağlık açısından faydalarından yararlanabilirsiniz.\n" +
                "\n" +
                "Afyonkarahisar, tarihi ve doğal güzellikleriyle ziyaretçilerine çeşitli deneyimler sunar.")
        visitPalace.add("Ağrı Dağı: Türkiye'nin en yüksek dağı olan Ağrı Dağı, sadece bir doğa harikası değil aynı zamanda mitolojik ve tarihi öneme sahiptir. Zirvesi, Dağın Kutsalı (Ararat Tepesi) olarak bilinir ve Nuh'un Gemisi'nin tufandan sonra buraya oturduğuna inanılır.\n" +
                "\n" +
                "İshak Paşa Sarayı: Doğu'nun en önemli yapılarından biri olan İshak Paşa Sarayı, Ağrı'nın İshak Paşa Köyü'nde bulunur. Osmanlı dönemi mimarisinin eşsiz bir örneğidir ve muazzam detaylarıyla dikkat çeker.\n" +
                "\n" +
                "Ağrı Arkeoloji Müzesi: Şehir merkezinde bulunan bu müze, Ağrı ve çevresindeki arkeolojik buluntuları sergiler. Hitit, Urartu ve Osmanlı dönemlerine ait eserler müzede görülebilir.\n" +
                "\n" +
                "Doğubayazıt Kalesi: Ağrı'nın Doğubayazıt ilçesinde yer alan bu kale, Urartu dönemine aittir ve Ağrı Dağı'nın eteklerinde konumlanmıştır. Tarihi ve manevi bir öneme sahip olan kale, etkileyici bir görüntü sunar.\n" +
                "\n" +
                "Noah's Ark National Park (Nuh'un Gemisi Milli Parkı): Ağrı Dağı'nın eteklerinde bulunan bu milli park, Nuh'un Gemisi'nin inşa edildiği yer olarak kabul edilir. Doğal güzellikleriyle ünlü parkta yürüyüş yapabilir ve dağın muhteşem manzarasını seyredebilirsiniz.\n" +
                "\n" +
                "Ağrı, eşsiz doğal güzellikleri ve tarihi mirasıyla ziyaretçilerine unutulmaz bir deneyim sunar.")

        visitPalace.add("Amasya Kalesi: Şehrin tarihi merkezinde bulunan kale, yeşil ve mavinin birleştiği muhteşem bir manzaraya sahiptir. Tarihi zenginlikleriyle ünlüdür ve Amasya'nın sembollerinden biridir.\n" +
                "\n" +
                "Yeşilırmak Kıyıları: Amasya'yı ikiye bölen Yeşilırmak Nehri'nin kıyıları, tarihi konaklar ve doğal güzelliklerle çevrilidir. Yürüyüş yapabilir, nehir kenarında dinlenebilir ve şehrin güzelliklerini seyredebilirsiniz.\n" +
                "\n" +
                "Amasya Saat Kulesi: Şehrin simgelerinden biri olan Saat Kulesi, Osmanlı dönemi mimarisinin güzel bir örneğidir. Şehrin merkezinde bulunur ve çevresi ticaret ve sosyal etkinlikler için önemli bir buluşma noktasıdır.\n" +
                "\n" +
                "Amasya Müzesi: Şehrin tarihini ve kültürel mirasını keşfetmek isteyenler için ideal bir yerdir. Müzede Hitit, Frig, Roma ve Osmanlı dönemlerine ait eserler sergilenir.\n" +
                "\n" +
                "Hazeranlar Konağı: Amasya'nın tarihi konaklarından biri olan Hazeranlar Konağı, geleneksel Türk ev mimarisinin güzel bir örneğidir. Konak, müze olarak ziyaretçilere açıktır ve şehrin kültürel mirasını yansıtır.\n" +
                "\n" +
                "Amasya, tarihi ve doğal güzellikleriyle büyüleyici bir şehirdir. Nehir kıyılarındaki tarihi yapılar, müzeler ve yöresel lezzetler, şehri ziyaret edenleri cezbeder.\n" +
                "\n"
               )
        visitPalace.add("Anıtkabir: Türkiye'nin kurucusu Mustafa Kemal Atatürk'ün anıt mezarının bulunduğu bu alan, Ankara'nın en önemli simgelerinden biridir. Tarihi ve anlamıyla ziyaretçiler için önemli bir merkezdir.\n" +
                "\n" +
                "Kocatepe Camii: Ankara'nın en büyük camisi olan Kocatepe Camii, modern mimarisi ve muhteşem iç dekorasyonuyla dikkat çeker. Şehrin merkezinde bulunur ve dini ziyaretler için önemli bir noktadır.\n" +
                "\n" +
                "Ankara Kalesi: Şehrin tarihi merkezinde yer alan Ankara Kalesi, antik çağlardan günümüze kadar pek çok medeniyetin izlerini taşır. Kale, muhteşem bir panoramik manzaraya sahiptir ve şehrin sembollerinden biridir.\n" +
                "\n" +
                "Atatürk Orman Çiftliği: Şehrin merkezine yakın bir konumda bulunan bu çiftlik, geniş yeşil alanları, piknik alanları ve spor alanlarıyla şehir halkının ve ziyaretçilerin dinlenme ve eğlenme mekanıdır.\n" +
                "\n" +
                "Müze ve Kültür Merkezleri: Ankara, birçok müze ve kültür merkeziyle doludur. Bu merkezler arasında Ankara Etnografya Müzesi, Devlet Resim ve Heykel Müzesi, ve Türk Hava Kurumu Müzesi gibi yerler bulunur.\n" +
                "\n" +
                "Ankara, Türkiye'nin başkenti ve tarihi, kültürel ve politik açıdan önemli bir şehridir. Bu nedenle, birçok önemli tarihi ve turistik mekanı bünyesinde barındırır.")
        return visitPalace
    }
    private fun getCityFood():ArrayList<String>{
        val sehirAdlari = ArrayList<String>()
        sehirAdlari.add("Adana Kebabı: Adana'nın en ünlü yemeği olan Adana kebabı, ince kıyılmış dana etiyle hazırlanan ve baharatlarla harmanlanan bir kebap çeşididir. Mangalda pişirilen bu lezzet, özellikle acı sevenler için idealdir.\n" +
                "\n" +
                "Şırdan: İnce bağırsaklardan yapılan ve baharatlarla lezzetlendirilen şırdan, Adana'nın geleneksel atıştırmalıklarından biridir. Genellikle kebapçılarda ve meyhanelerde bulunur.\n" +
                "\n" +
                "Beyran Çorbası: Bu kahvaltılık çorba, bulgur, kuzu eti ve baharatlarla yapılan bir çeşit çorbadır. Genellikle sabahları tüketilen beyran çorbası, Adana'da kahvaltıların vazgeçilmezidir.\n" +
                "\n" +
                "Tas Kebabı: Adana'ya özgü bir başka kebap çeşidi olan tas kebabı, özel bir kapta pişirilir ve servis edilir. Etin özel pişirme tekniği ve baharatlarıyla damaklarda unutulmaz bir tat bırakır.\n" +
                "\n" +
                "Analı Kızlı: Adana mutfağının sevilen tatlılarından biri olan analı kızlı, ince hamurun arasına ceviz ve şeker karışımı konularak hazırlanan bir tattır. Üzerine yoğurt ve tereyağı dökülerek servis edilir.\n" +
                "\n" +
                "Adana mutfağı, zengin baharatları ve özel pişirme teknikleriyle tanınır. Bu lezzetler, Adana'nın kültürel ve gastronomik mirasının önemli bir parçasını oluşturur.")
        sehirAdlari.add("Ciğer Kebabı: Adıyaman'ın en ünlü yemeklerinden biri olan ciğer kebabı, közlenmiş ciğerin özel baharatlarla marine edilip mangalda pişirilmesiyle yapılır.\n" +
                "\n" +
                "Analı Kızlı: Bulgurun içine kıyma, ceviz, salça ve baharat karışımı konularak hazırlanan bu yemek, küçük toplar halinde pişirilir ve üzerine yoğurt sosuyla servis edilir.\n" +
                "\n" +
                "Kiremitte Kuzu Tandır: Adıyaman'ın yöresel lezzetlerinden biri olan kuzu tandırı, kiremitte pişirilerek sunulur. Uzun süre pişirilen kuzu eti, yumuşak ve lezzetli olur.\n" +
                "\n" +
                "Tike Kebabı: İnce dilimlenmiş etlerin özel baharatlarla marine edilip şişe dizilerek mangalda pişirilmesiyle hazırlanan bu kebap, Adıyaman mutfağının vazgeçilmez lezzetlerindendir.\n" +
                "\n" +
                "Çökelekli Köfte: İçine çökelek konularak hazırlanan köfteler, yoğurtlu sos ile servis edilir ve lezzetiyle damaklarda unutulmaz bir tat bırakır.\n" +
                "\n" +
                "Çılbır: Yoğurtlu ve tereyağlı sosun üzerine yumurta konularak hazırlanan bu lezzetli yemek, Adıyaman'da sıkça tüketilir.")
        sehirAdlari.add("Kaymaklı Ekmek Kadayıfı: Afyonkarahisar'ın en ünlü tatlılarından biridir. İnce tel kadayıfın arasına kaymak ve şerbet eklenerek hazırlanır. Hem tatlı hem de hafif ekşi bir lezzete sahiptir.\n" +
                "\n" +
                "Döner Kebap: Türkiye genelinde olduğu gibi Afyonkarahisar'da da döner kebap oldukça popülerdir. Etin özel baharatlarla marine edilip, döner şeklinde pişirilmesiyle hazırlanır.\n" +
                "\n" +
                "Haşhaşlı Çörek: Afyonkarahisar'a özgü bir lezzet olan haşhaşlı çörek, hamurun içine bol miktarda haşhaş ve şeker konularak hazırlanır. Tatlı bir hamur işidir.\n" +
                "\n" +
                "Fırın Kebabı: Kuzu eti, patates ve sebzelerin fırında uzun süre pişirilerek hazırlanan bu lezzetli yemek, Afyonkarahisar mutfağının vazgeçilmezlerindendir.\n" +
                "\n" +
                "Sucuk Ekmek: Afyonkarahisar'ın yöresel lezzetlerinden biri olan sucuk ekmek, taze ekmek içine yerleştirilen sucukla hazırlanır. Sıklıkla kahvaltıda tercih edilir.\n" +
                "\n" +
                "Madımak Yemeği: Afyonkarahisar ve çevresinde yaygın olarak tüketilen madımak yemeği, madımak otunun etle birlikte pişirilmesiyle hazırlanır. Besleyici ve lezzetli bir yemektir.")

        sehirAdlari.add("Dımbıl Çorbası: Ağrı yöresine özgü bir çorba çeşididir. Genellikle bulgur, nohut, et ve baharatlarla hazırlanır. Besleyici ve doyurucu bir çorbadır.\n" +
                "\n" +
                "Kürt Böreği: Ağrı ve çevresinde sıkça yapılan bir börek çeşididir. İnce yufka katları arasına peynir veya patates konularak hazırlanır ve genellikle kahvaltılarda tercih edilir.\n" +
                "\n" +
                "Haşıl: Ağrı'nın geleneksel yemeklerinden biridir. Buğdayın haşlanarak üzerine tereyağı ve lor peyniri eklenmesiyle hazırlanır. Genellikle sabah kahvaltılarında tüketilir.\n" +
                "\n" +
                "Kürt Köftesi: Yöresel baharatlarla zenginleştirilmiş, et ve bulgurdan yapılan köfte çeşididir. Genellikle özel günlerde veya davetlerde servis edilir.\n" +
                "\n" +
                "Gendime Çorbası: Ağrı yöresine özgü bir çorba olan gendime çorbası, pirinç ve nohutun bir arada pişirilmesiyle hazırlanır. Zengin bir lezzete sahiptir.\n" +
                "\n" +
                "Kesme Çorbası: Ağrı'nın kış aylarında sıkça tüketilen bir çorba çeşididir. İnce kesilmiş hamurların et suyunda pişirilmesiyle hazırlanır. Sıcak ve besleyici bir çorbadır.")

        sehirAdlari.add("Borani: Yoğurt, nohut ve etin bir araya gelerek hazırlanan bir yemektir. Genellikle özel günlerde ve davetlerde tercih edilir.\n" +
                "\n" +
                "Bulgur Pilavı: Bulgurun farklı baharatlarla pişirilerek hazırlanan bir pilav çeşididir. Et yemekleriyle birlikte servis edilir.\n" +
                "\n" +
                "Yağ Mantısı: İnce hamurların içine kıyma ve baharatlar konularak yapılan bir mantı çeşididir. Üzerine yoğurt ve tereyağı dökülerek servis edilir.\n" +
                "\n" +
                "Laz Böreği: Yufka katları arasına lor peyniri ve maydanoz konularak yapılan bir börek çeşididir. Genellikle kahvaltılarda tercih edilir.\n" +
                "\n" +
                "Cızlak: Kuru fasulye ve bulgurun bir araya gelerek pişirildiği bir yemektir. Genellikle et yemekleriyle birlikte tüketilir.\n" +
                "\n" +
                "Hengel: Yoğurt ve kıyma ile yapılan, köfte benzeri bir yemektir. Özellikle düğün ve bayramlarda sıkça yapılan geleneksel bir lezzettir.\n" +
                "\n" +
                "Pıt pıt Tatlısı: Amasya'nın meşhur tatlılarından biridir. İnce hamurun içine ceviz veya fındık konularak hazırlanır ve şerbetle buluşturulur.")

        sehirAdlari.add("Döner: Ankara'da da oldukça popüler olan döner, etin özel baharatlarla marine edilip şişe dizilerek pişirilmesiyle hazırlanır. Genellikle dürüm veya ekmek arası olarak tüketilir.\n" +
                "\n" +
                "Kuzu Tandır: Yavaş ateşte pişirilen kuzu eti, Ankara mutfağının vazgeçilmez lezzetlerinden biridir. Etin yumuşaklığı ve lezzetiyle bilinir.\n" +
                "\n" +
                "Höşmerim: İnce tel tel kesilmiş irmik helvası şeklinde hazırlanan bu tatlı, sıcak sıcak servis edilir ve üzerine genellikle kaymak veya dondurma ile servis edilir.\n" +
                "\n" +
                "Ankara Tava: Kuşbaşı etin, domates ve biberle birlikte kızartılmasıyla hazırlanan bu yemek, yöresel bir lezzettir. Genellikle sıcak olarak servis edilir.\n" +
                "\n" +
                "Keşkek: Buğday ve etin uzun saatler boyunca pişirilip ezilmesiyle hazırlanan geleneksel bir yemektir. Yoğurt ve tereyağı ile servis edilir.\n" +
                "\n" +
                "Macun Kavurması: Dana eti ve sebzelerin özel bir sosla kavrulmasıyla hazırlanan bu yemek, Ankara'da oldukça popülerdir. Genellikle pilav veya ekmekle servis edilir.\n" +
                "\n" +
                "Sızgıt Kebabı: Dövme yöntemiyle inceltilmiş dana etinin közde pişirilerek hazırlanan bir kebap çeşididir. Genellikle közde pişirilmiş domates, biber ve soğan ile servis edilir.")


        return sehirAdlari
    }

}
/*

 */