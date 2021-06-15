package com.nurdin.submission1jetpackpro.utils

import com.nurdin.submission1jetpackpro.model.DataEntity
import com.nurdin.submission1jetpackpro.model.Genres

object DataDummy {

    fun generateDummyMovies(): List<DataEntity> {
        val movies = ArrayList<DataEntity>()

        movies.add(
            DataEntity(
                    1,
                    "A Star Is Born",
                    "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                    genre = listOf(Genres("Drama, Percintaan, Musik")),
                    "2018",
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
            2,
            "Alita: Battle Angle",
            "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                genre = listOf(Genres("Aksi, Cerita Fiksi, Petualangan")),
            "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
                3,
                "Spider-Main: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                genre = listOf(Genres("Aksi, Petualangan, Animasi")),
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
            4,
            "Bohemian Rhapsody",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                genre = listOf(Genres("Drama, Musik")),
            "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
            5,
            "Cold Pursuit",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                genre = listOf(Genres("Aksi, Kejahatan, Cerita Seru")),
            "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
                6,
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                genre = listOf(Genres("Keluarga, Animasi, Komedi, Petualangan")),
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
            7,
            "Avengers: Infinity War",
            "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi.",
                genre = listOf(Genres("Petualangan, Aksi, Cerita Seru")),
            "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
                8,
                "How to Train Your Dragon: The Hidden World",
                "Ketika Hiccup memenuhi mimpinya untuk menciptakan utopia naga yang damai, penemuan Toothless 'dari pasangan yang tak teruji dan sukar ditangkap membuat Night Fury menjauh. Ketika bahaya meningkat di rumah dan pemerintahan Hiccup sebagai kepala desa diuji, baik naga dan pengendara harus membuat keputusan yang mustahil untuk menyelamatkan jenis mereka.",
                genre = listOf(Genres("Animasi, Keluarga, Petualangan")),
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
            9,
            "Robin Hood",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                genre = listOf(Genres("Petualangan, Aksi, Cerita Seru")),
            "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        movies.add(
            DataEntity(
                10,
                "Aquaman: Heroines of Atlantis",
                "Amber Heard and Nicole Kidman discuss their characters Mera and Atlanna.",
                genre = listOf(Genres("Documentary")),
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg"
            )
        )
        return movies
    }

    fun generateDummyTvShows(): List<DataEntity> {
        val tvShows = ArrayList<DataEntity>()

        tvShows.add(
            DataEntity(
            11,
            "The Arrow",
            "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                genre = listOf(Genres("Kejahatan, Drama, Misteri")),
            "2012",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
                12,
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                genre = listOf(Genres("misteri")),
                "Drama, Mystery, Sci-Fi & Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
            13,
            "Family Guy",
            "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ).",
                genre = listOf(Genres("Animasi, Komedi")),
            "1999",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
                14,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                genre = listOf(Genres("Aksi & Petualangan, Drama")),
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
            15,
            "Gotham",
            "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka.",
                genre = listOf(Genres("Drama, Fantasi, Kejahatan")),
            "2014",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
            16,
            "Grey's Anatomy",
            "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
                genre = listOf(Genres("Drama")),
            "2005",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
            17,
            "Naruto Shippuden",
            "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                genre = listOf(Genres("Animasi, Komedi, Drama")),
            "2007",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
                18,
                "The Flash",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                genre = listOf(Genres("Drama, Sci-fi & Fantasy")),
                "2014",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
                19,
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                genre = listOf(Genres("science fiction")),
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        tvShows.add(
            DataEntity(
                20,
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                genre = listOf(Genres("science fiction")),
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg")
        )
        return tvShows
    }
}