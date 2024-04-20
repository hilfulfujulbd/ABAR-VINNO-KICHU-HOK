package com.toufikhasan.abarvinnokichuhok;

import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int UPDATE_IN_APP_CODE = 8045;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ReviewManager manager;
    ReviewInfo reviewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Title Change
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.abar_vinno_kichu_hok);

        // Drawable Show & hide java program
        drawerLayout = findViewById(R.id.drawerLayout);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Navigation on menu item selected
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        //card button on Item On Click
        findViewById(R.id.SN01).setOnClickListener(view -> startActivityApplication(getString(R.string.apnare_ami_khujiya_berai), "text/chapter/apnare_ami_khujiya_berai.txt"));
        findViewById(R.id.SN02).setOnClickListener(view -> startActivityApplication(getString(R.string.je_sutai_badha_jibon), "text/chapter/je_sutai_badha_jibon.txt"));
        findViewById(R.id.SN03).setOnClickListener(view -> startActivityApplication(getString(R.string.gahi_notuner_gan), "text/chapter/gahi_notuner_gan.txt"));
        findViewById(R.id.SN04).setOnClickListener(view -> startActivityApplication(getString(R.string.potoner_ayaj_paoya_jay), "text/chapter/potoner_ayaj_paoya_jay.txt"));
        findViewById(R.id.SN05).setOnClickListener(view -> startActivityApplication(getString(R.string.bisshojora_patsala_more), "text/chapter/bisshojora_patsala_more.txt"));
        findViewById(R.id.SN06).setOnClickListener(view -> startActivityApplication(getString(R.string.kokhono_vul_hole), "text/chapter/kokhono_vul_hole.txt"));
        findViewById(R.id.SN07).setOnClickListener(view -> startActivityApplication(getString(R.string.bondishibir_theke), "text/chapter/bondishibir_theke.txt"));
        findViewById(R.id.SN08).setOnClickListener(view -> startActivityApplication(getString(R.string.jodi_tor_dak_sune_keo_na_ase), "text/chapter/jodi_tor_dak_sune_keo_na_ase.txt"));
        findViewById(R.id.SN09).setOnClickListener(view -> startActivityApplication(getString(R.string.je_jai_boluk_piche), "text/chapter/je_jai_boluk_piche.txt"));
        findViewById(R.id.SN10).setOnClickListener(view -> startActivityApplication(getString(R.string.khule_jak_jiboner_bondho_duyar), "text/chapter/khule_jak_jiboner_bondho_duyar.txt"));
        findViewById(R.id.SN11).setOnClickListener(view -> startActivityApplication(getString(R.string.khelaghor_pata_ase_ai_akhane), "text/chapter/khelaghor_pata_ase_ai_akhane.txt"));
        findViewById(R.id.SN12).setOnClickListener(view -> startActivityApplication(getString(R.string.ridoyer_janala_khule_dao_na), "text/chapter/ridoyer_janala_khule_dao_na.txt"));
        findViewById(R.id.SN13).setOnClickListener(view -> startActivityApplication(getString(R.string.jiboner_kompass), "text/chapter/jiboner_kompass.txt"));
        findViewById(R.id.SN14).setOnClickListener(view -> startActivityApplication(getString(R.string.valobasi_valobasi), "text/chapter/valobasi_valobasi.txt"));
        findViewById(R.id.SN15).setOnClickListener(view -> startActivityApplication(getString(R.string.sumudher_sad), "text/chapter/sumudher_sad.txt"));
        findViewById(R.id.SN16).setOnClickListener(view -> startActivityApplication(getString(R.string.abar_vinno_kichu_hok), "text/chapter/abar_vinno_kichu_hok.txt"));

    }

    /**
     * Called when leaving the activity
     */

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            exitAlertApplication();
            //super.onBackPressed();
        }
    }

    public void exitAlertApplication() {
        AlertDialog.Builder exitAlert = new AlertDialog.Builder(MainActivity.this);
        // Title set
        exitAlert.setTitle("Alert Dialog Application.");
        // Massage Set
        exitAlert.setMessage("আপনি কি এখান থেকে বের হতে চান?");
        // Icon set
        exitAlert.setIcon(R.drawable.alert_icon);

        // Positive Button
        exitAlert.setCancelable(false);

        exitAlert.setPositiveButton("হ্যাঁ", (dialogInterface, i) -> finish());
        exitAlert.setNegativeButton("না", (dialogInterface, i) -> dialogInterface.cancel());

        AlertDialog alertDialog = exitAlert.create();
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        } else if (item.getItemId() == R.id.writter) {
            startActivityApplication("লেখক পরিচিতি", "text/app/writter_info.txt");
        } else if (item.getItemId() == R.id.about_us) {
            startActivityApplication("আমাদের সম্পর্কে", "text/app/about.txt");
        } else if (item.getItemId() == R.id.privacy) {
            gotoUrl("https://toufikhasan.com/android-apk/book/abar-vinno-kichu-hok/privacy-policy.html");
        } else if (item.getItemId() == R.id.update_app) {
            IN_APP_UPDATE_AVAILABLE();
        } else if (item.getItemId() == R.id.ahobban_app) {
            gotoUrl("https://play.google.com/store/apps/details?id=com.toufikhasan.ahobban");
        } else if (item.getItemId() == R.id.message_book_app) {
            gotoUrl("https://play.google.com/store/apps/details?id=com.toufikhasan.massagebook");
        } else if (item.getItemId() == R.id.moreApp) {
            gotoUrl("https://play.google.com/store/apps/dev?id=5871408368342725724");
        } else if (item.getItemId() == R.id.ratting) {
            IN_APP_REVIEW_AVAILABLE_ABER_VINNO_KISU_APP();
        } else if (item.getItemId() == R.id.contact_us) {
            startActivityApplication("যোগাযোগ পেইজ", "text/app/contact.txt");
        } else if (item.getItemId() == R.id.website) {
            gotoUrl("http://toufikhasan.com");
        } else if (item.getItemId() == R.id.shair) {
            Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Abar Vinno Kichu Hok App contact");
            String shareMassage = "https://play.google.com/store/apps/details?id=com.toufikhasan.abarvinnokichuhok";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMassage);

            startActivity(Intent.createChooser(shareIntent, "ShareVia"));
        } else if (item.getItemId() == R.id.facebook_page) {
            gotoUrl("https://www.facebook.com/toufik.bd.official");
        } else if (item.getItemId() == R.id.facebook_group) {
            gotoUrl("https://www.facebook.com/groups/books.my.friend");
        } else if (item.getItemId() == R.id.youtube) {
            gotoUrl("https://www.youtube.com/channel/UCJWmYNTgEvJsDm0zqj3lIxw");
        } else if (item.getItemId() == R.id.youtube2) {
            gotoUrl("https://www.youtube.com/channel/UCSw15OyHP_dEzEyHQALwjzw");
        } else if (item.getItemId() == R.id.linkedin) {
            gotoUrl("https://www.linkedin.com/in/ownertoufikhasan/");
        }
        return false;
    }

    private void startActivityApplication(String title, String fileName) {
        Intent intent = new Intent(MainActivity.this, ShowText.class);
        intent.putExtra(ShowText.TITLE_NAME, title);
        intent.putExtra(ShowText.FILE_NAME, fileName);
        startActivity(intent);
    }

    public void gotoUrl(String link) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
    }

    private void IN_APP_UPDATE_AVAILABLE() {
        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);

// Returns an intent object that you use to check for an update.
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

// Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    // This example applies an immediate update. To apply a flexible update
                    // instead, pass in AppUpdateType.FLEXIBLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                // Request the update.

                try {
                    appUpdateManager.startUpdateFlowForResult(appUpdateInfo, AppUpdateType.IMMEDIATE, this, UPDATE_IN_APP_CODE);
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }


            } else {
                Toast.makeText(this, "এখনো আপডেট আসে নাই!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void IN_APP_REVIEW_AVAILABLE_ABER_VINNO_KISU_APP() {

        manager = ReviewManagerFactory.create(this);

        Task<ReviewInfo> request = manager.requestReviewFlow();

        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                reviewInfo = task.getResult();
                assert reviewInfo != null;
                Task<Void> voidTask = manager.launchReviewFlow(this, reviewInfo);

                voidTask.addOnSuccessListener(unused -> Toast.makeText(this, "রেটিং দেওয়ার জন্য ধন্যবাদ.", Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(this, "Something ERROR...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == UPDATE_IN_APP_CODE) {
            Toast.makeText(this, "Updating now...", Toast.LENGTH_SHORT).show();
        }

    }
}