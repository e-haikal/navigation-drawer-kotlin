# Implementasi Navigation Drawer di Android (Kotlin)

Proyek ini mendemonstrasikan cara mengimplementasikan **Navigation Drawer** (Laci Navigasi) dalam aplikasi Android menggunakan bahasa Kotlin. Navigation Drawer adalah komponen UI yang menyediakan akses mudah ke berbagai bagian aplikasi melalui panel geser samping.

## Tampilan Aplikasi

Berikut adalah tampilan Navigation Drawer dalam aplikasi:

[![Drawer Menu Active](https://github.com/e-haikal/navigation-drawer-kotlin/blob/main/documentation/Drawer%20Menu%20Active.png)](https://github.com/e-haikal/navigation-drawer-kotlin/blob/main/documentation/Drawer%20Menu%20Active.png)

## Fitur

-   Tampilan Navigation Drawer yang dapat digeser dari samping.
-   Header kustom untuk Navigation Drawer.
-   Item menu dengan ikon dan teks.
-   Penanganan klik item menu untuk navigasi dalam aplikasi.
-   Animasi tombol drawer (ikon hamburger).

## Prasyarat

-   Android Studio terinstal.
-   Pengetahuan dasar tentang pengembangan Android dengan Kotlin.
-   Dependensi Material Components Library ditambahkan di `build.gradle`:

```gradle
implementation 'com.google.android.material:material:1.x.x' // Ganti x.x.x dengan versi terbaru
```

## Cara Menjalankan Proyek

1.  **Clone repositori ini:**

```bash
git clone https://github.com/e-haikal/navigation-drawer-kotlin.git
```

2.  **Buka di Android Studio:**

    Buka proyek yang telah di-clone di Android Studio.

3.  **Build dan Jalankan:**

    Klik tombol "Run" untuk membangun dan menjalankan aplikasi di emulator atau perangkat Android.

## Struktur Proyek

```
app/
├── java/com.siaptekno.navigation_drawer_kotlin/
│   └── MainActivity.kt              # Aktivitas utama
├── res/
│   ├── drawable/                     # Ikon-ikon dan gambar
│   │   ├── ... (berbagai ikon)
│   ├── layout/                      # File layout
│   │   ├── activity_main.xml        # Layout utama
│   │   └── nav_header.xml           # Layout header drawer
│   └── menu/                        # File menu drawer
│     └── nav_menu.xml               
│   └── values
│       ├── colors.xml              # Definisi warna
│       └── strings.xml             # Definisi string
```

## Penjelasan Kode: `MainActivity.kt`

```kotlin
// ... (Kode import yang diperlukan)

class MainActivity : AppCompatActivity() {
    // ... deklarasi variabel

    override fun onCreate(savedInstanceState: Bundle?) {
        // ... (Inisialisasi tampilan, komponen, dll.)

        // ActionBarDrawerToggle untuk menangani buka/tutup drawer
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Navigasi
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle aksi untuk item Home
                }
                // ... Tambahkan case untuk item lainnya
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    // ... (Kode lain yang diperlukan)
}
```

## Kustomisasi

Anda dapat dengan mudah menyesuaikan Navigation Drawer sesuai keinginan Anda:

-   **Mengubah Header:** Edit file `nav_header.xml` untuk mengganti gambar profil, nama, atau informasi lain.
-   **Mengubah Item Menu:** Edit file `nav_menu.xml` untuk menambahkan, menghapus, atau mengubah item menu.
-   **Menangani Navigasi:** Tambahkan logika di dalam blok `when` pada `MainActivity.kt` untuk melakukan tindakan ketika suatu item menu dipilih (misalnya, membuka Activity/Fragment baru).

## Lisensi

Proyek ini dilisensikan di bawah lisensi MIT. Silakan lihat berkas `LICENSE` untuk informasi lebih lanjut.
