package engine;

import obstacles.*; 
import java.util.ArrayList;

public class LevelManager {

    public static ArrayList<Rintangan> muatLevel1() {
        ArrayList<Rintangan> level1 = new ArrayList<>();

        level1.add(new RintanganAlam(
            "Jurang Kematian", 
            "Kamu menyusuri gua yang gelap dan lembab. Tiba-tiba langkahmu terhenti.\nSebuah jurang selebar 10 meter menganga di depanmu. Tidak ada jembatan.", 
            "TALI_01", 
            40 
        ));

        level1.add(new RintanganMakhluk(
            "Ular Piton Raksasa", 
            "Dari langit-langit gua, seekor piton raksasa menjatuhkan diri!\nMata kuningnya menatap tajam, bersiap melilit tubuhmu.", 
            "CAMBUK_01", 
            30
        ));

        return level1;
    }

    public static ArrayList<Rintangan> muatLevel2() {
        ArrayList<Rintangan> level2 = new ArrayList<>();

        level2.add(new JebakanLogika(
            "Pintu Kuil Suku Maya", 
            "Kamu tiba di depan pintu batu raksasa. Ada ukiran wajah iblis dan tulisan kuno.", 
            50, 
            "'Aku selalu lapar, aku harus selalu diberi makan. Jari yang menyentuhku akan segera merah dan mati. Siapakah aku?'", 
            "Api" 
        ));

        return level2;
    }

    public static ArrayList<Rintangan> muatLevel3() {
        ArrayList<Rintangan> level3 = new ArrayList<>();

        level3.add(new RintanganAlam(
            "Batu Menggelinding Raksasa", 
            "Begitu kau mengangkat Patung Emas itu, tanah bergetar!\nSebuah batu bundar raksasa seukuran rumah menggelinding dari arah belakangmu!", 
            "LARI", 
            80 
        ));

       level3.add(new JebakanLogika(
            "Jalan Buntu Kuil Runtuh", 
            "Jalan keluarnya tertutup puing! Ada tiga tuas: Merah, Hijau, dan Biru. \nTulisan di dinding: 'Warna darah adalah kematian, warna langit adalah ilusi, ikuti warna kehidupan hutan.'", 
            100,
            "Tuas warna apa yang akan kamu tarik?", 
            "Hijau" 
        ));

        return level3;
    }

    public static void putarNarasi(int nomorLevel) {
        DisplayHandler.cetakGaris();
        if (nomorLevel == 1) {
            DisplayHandler.cetakInfo("CHAPTER 1: MULUT GUA TERLARANG");
            System.out.println("Udara Amazon terasa sangat lembab.");
            System.out.println("Indiana Jones menyalakan cerutunya, menatap kegelapan di depannya.");
            System.out.println("Kabar burung mengatakan tidak ada yang pernah kembali hidup-hidup dari sini.");
        } else if (nomorLevel == 2) {
            DisplayHandler.cetakInfo("CHAPTER 2: JANTUNG KUIL");
            System.out.println("Napasmu tersengal. Bahaya di mulut gua berhasil dilewati.");
            System.out.println("Kini kamu berdiri di depan gerbang utama peninggalan Suku Maya.");
            System.out.println("Harta karun itu semakin dekat...");
        } else if (nomorLevel == 3) { 
            DisplayHandler.cetakInfo("CHAPTER 3: PELARIAN DARI KEMATIAN");
            System.out.println("Kamu berhasil masuk ke ruang utama. Di tengah ruangan, Patung Emas Suku Maya bersinar terang.");
            System.out.println("Dengan hati-hati, kamu mengambilnya dan memasukkannya ke dalam tas.");
            System.out.println("Tiba-tiba...");
            System.out.println("*KRAAAKKK! GRRRRMMM...*");
            System.out.println("Kuil ini mulai runtuh! Kau telah memicu sistem pertahanan kuno!");
            System.out.println("Lari atau mati tertimbun di sini selamanya!");
        }
        DisplayHandler.cetakGaris();
    }
}